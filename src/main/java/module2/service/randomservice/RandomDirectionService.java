package module2.service.randomservice;

import module2.manager.RandomManager;
import module2.model.enums.Direction;
import module2.model.Cell;
import module2.service.DirectionService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RandomDirectionService {

    DirectionService directionService = new DirectionService();
    RandomManager randomManager = RandomManager.getRandomManager();

    public Direction chooseRandomDirection(Cell cell, int speed) {
        List<Direction> directions = directionService.chooseCorrectDirection(cell, speed);
        ThreadLocalRandom random = randomManager.getRandom();
        int i = random.nextInt(0, directions.size());

        return directions.get(i);
    }

}