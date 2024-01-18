package module2.service;

import module2.manager.ConfigManager;
import module2.manager.RandomManager;
import module2.config.EatingChanceConfig;
import module2.model.Fauna;
import module2.model.NatureObject;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FoodService {

    EatingChanceConfig eatingChanceConfig = ConfigManager.getConfigManager().getEatingChanceConfig();
    RandomManager randomManager = RandomManager.getRandomManager();

    public Optional<NatureObject> eat(Fauna who, NatureObject whom) {
        Integer animalEatingChance = eatingChanceConfig.getConfig().get(who.getLiveableType()).get(whom.getLiveableType());

        ThreadLocalRandom random = randomManager.getRandom();
        int generatedChance = random.nextInt(0, 100);
        return Optional.of(who)
                .filter(fauna -> generatedChance > animalEatingChance)
                .map(obj -> {
                    obj.setSatiety(whom.getWeight());
                    return whom;
                });
    }

}