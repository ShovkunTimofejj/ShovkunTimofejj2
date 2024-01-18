package module2.service.coordinator;

import module2.model.Fauna;
import module2.model.enums.Direction;
import module2.model.Cell;
import module2.model.Field;
import module2.service.MovementService;
import module2.service.randomservice.RandomDirectionService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MovementCoordinator {

    MovementService movementService = new MovementService();
    RandomDirectionService randomDirectionService = new RandomDirectionService();

    public void move(Field field, Cell cell, Fauna fauna) {
        Direction direction = randomDirectionService.chooseRandomDirection(cell, fauna.getSpeed());
        Cell destinationCell = movementService.calcCellToMove(field, cell, fauna.getSpeed(), direction);

        cell.getListOfEntity().remove(fauna);
        destinationCell.getListOfEntity().add(fauna);
    }

}