package module2.service.randomservice;

import module2.manager.RandomManager;
import module2.model.Fauna;
import module2.model.NatureObject;
import module2.model.Cell;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RandomReproduceService {

    RandomManager randomManager = RandomManager.getRandomManager();

    public Optional<Fauna> chooseRandomFaunaForReproduce(Cell cell, Fauna fauna) {
        List<NatureObject> collect = cell.getListOfEntity()
                .stream()
                .filter(e -> !e.equals(fauna))
                .filter(e->e.getLiveableType().equals(fauna.getLiveableType())).toList();
        ThreadLocalRandom random = randomManager.getRandom();
        int randomIndex = random.nextInt(0, collect.size());

        NatureObject randomEntity = collect.get(randomIndex);
        if (randomEntity instanceof Fauna faunaResult) {
            return Optional.of(faunaResult);
        }

        return Optional.empty();
    }
}