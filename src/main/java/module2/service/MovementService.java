package module2.service;

import module2.model.enums.Direction;
import module2.model.Cell;
import module2.model.Field;

public class MovementService {

    public Cell calcCellToMove(Field field, Cell cell, int speed, Direction direction) {

        return switch (direction) {
            case UP -> calcCoordinate(field, cell.getX(), cell.getY() - speed - 1);
            case DOWN -> calcCoordinate(field, cell.getX(), cell.getY() + speed - 1);
            case LEFT -> calcCoordinate(field, cell.getX() - speed - 1, cell.getY());
            case RIGHT -> calcCoordinate(field, cell.getX() + speed - 1, cell.getY());
        };
    }

    private Cell calcCoordinate(Field field, Integer x, Integer y) {
        return field.getCells().get(x).get(y);
    }

}