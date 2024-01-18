package module2.service;

import module2.config.AnimalsConfig;
import module2.manager.ConfigManager;
import module2.manager.RandomManager;
import module2.model.NatureObject;
import module2.model.enums.LiveableType;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReproduceService {

    FloraAndFaunaFactory floraAndFaunaFactory = new FloraAndFaunaFactory();
    AnimalsConfig animalsConfig = ConfigManager.getConfigManager().getAnimalsConfig();
    RandomManager randomManager = RandomManager.getRandomManager();

    public Optional<NatureObject> reproduce(LiveableType liveableType) {

        ThreadLocalRandom random = randomManager.getRandom();
        int reproduceChance = random.nextInt(0, 100);

        return Optional.of(reproduceChance)
                .filter(chance -> reproduceChance > 50)
                .map(e -> floraAndFaunaFactory.getInstance(
                        liveableType,
                        animalsConfig.getConfig().get(liveableType))
                );
    }

}