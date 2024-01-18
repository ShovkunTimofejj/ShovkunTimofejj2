package module2.service.coordinator;

import module2.model.Fauna;
import module2.model.NatureObject;
import module2.model.Cell;
import module2.service.FoodService;
import module2.service.randomservice.RandomFoodService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FoodCoordinator {

    FoodService foodService = new FoodService();
    RandomFoodService randomFoodService = new RandomFoodService();

    public void eatOnCell(Cell cell, Fauna who) {

        NatureObject natureObject = randomFoodService.chooseRandomNatureObjectForEat(cell, who);
        foodService.eat(who, natureObject).ifPresent(liveable -> cell.getListOfEntity().remove(liveable));

    }

}