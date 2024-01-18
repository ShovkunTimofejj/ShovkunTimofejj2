package module2.service;

import module2.manager.ConfigManager;
import module2.manager.RandomManager;
import module2.config.AnimalsConfig;
import module2.model.NatureObject;
import module2.model.enums.LiveableType;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EntityCreator {

    AnimalsConfig animalConfig = ConfigManager.getConfigManager().getAnimalsConfig();
    FloraAndFaunaFactory factory = new FloraAndFaunaFactory();
    RandomManager randomManager = RandomManager.getRandomManager();

    public List<NatureObject> createEntities() {
        List<NatureObject> list = new ArrayList<>();
        LiveableType[] values = LiveableType.values();
        for (LiveableType value : values) {
            ThreadLocalRandom random = randomManager.getRandom();
            int randomCount = random.nextInt(0, animalConfig.getConfig().get(value).getCount());
            for (int j = 0; j < randomCount; j++) {
                list.add(factory.getInstance(value, animalConfig.getConfig().get(value)));
            }
        }
        Collections.shuffle(list);
        return list;
    }

}