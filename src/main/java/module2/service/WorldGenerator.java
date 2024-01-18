package module2.service;

import module2.manager.ConfigManager;
import module2.config.MapConfig;
import module2.model.Field;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WorldGenerator {

    MapConfig mapConfig = ConfigManager.getConfigManager().getMapConfig();
    EntityCreator entityCreator = new EntityCreator();

    public void generateWorld(Field field) {
        for (int i = 0; i < mapConfig.getX(); i++) {
            for (int j = 0; j < mapConfig.getY(); j++) {
                field.getCells().get(i).get(j).getListOfEntity().addAll(entityCreator.createEntities());
            }
        }
    }

}