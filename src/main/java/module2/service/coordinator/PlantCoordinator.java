package module2.service.coordinator;

import module2.config.AnimalsConfig;
import module2.manager.ConfigManager;
import module2.manager.RandomManager;
import module2.model.Field;
import module2.service.FloraAndFaunaFactory;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static module2.model.enums.LiveableType.*;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PlantCoordinator {

    FloraAndFaunaFactory floraAndFaunaFactory = new FloraAndFaunaFactory();
    AnimalsConfig animalsConfig = ConfigManager.getConfigManager().getAnimalsConfig();
    RandomManager randomManager = RandomManager.getRandomManager();

    public void grow(Field field) {
        ThreadLocalRandom random = randomManager.getRandom();

        field.getCells()
                .stream()
                .flatMap(Collection::stream)
                .forEach(
                        cell -> {
                            int i = random.nextInt(0, 100);
                            IntStream.range(0, i)
                                    .forEach(j -> cell.getListOfEntity()
                                            .add(floraAndFaunaFactory
                                                    .getInstance(PLANT, animalsConfig.getConfig().get(PLANT))));
                        }
                );


    }

}