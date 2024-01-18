package module2;

import module2.config.MapConfig;
import module2.manager.ConfigManager;
import module2.model.Fauna;
import module2.model.NatureObject;
import module2.model.Cell;
import module2.model.Field;
import module2.model.enums.LiveableType;
import module2.service.WorldGenerator;
import module2.service.coordinator.FoodCoordinator;
import module2.service.coordinator.MovementCoordinator;
import module2.service.coordinator.PlantCoordinator;
import module2.service.coordinator.ReproduceCoordinator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Island {

    MapConfig mapConfig = ConfigManager.getConfigManager().getMapConfig();
    WorldGenerator worldGenerator = new WorldGenerator();
    FoodCoordinator foodCoordinator = new FoodCoordinator();
    ReproduceCoordinator reproduceCoordinator = new ReproduceCoordinator();
    MovementCoordinator movementCoordinator = new MovementCoordinator();
    PlantCoordinator plantCoordinator = new PlantCoordinator();

    public void start() {
        Field field = initField(mapConfig);
        worldGenerator.generateWorld(field);

        Runnable scheduleTask = () -> {

            plantCoordinator.grow(field);

            Map<LiveableType, Long> collect = field.getCells()
                    .stream()
                    .flatMap(Collection::stream)
                    .flatMap(cell -> cell.getListOfEntity().stream())
                    .collect(Collectors.groupingBy(NatureObject::getLiveableType, Collectors.counting()));

            for (Map.Entry<LiveableType, Long> entry : collect.entrySet()) {
                System.out.println(entry.getKey().name() + " " + entry.getValue());
            }
            System.out.println();
        };

        ExecutorService executorService = Executors.newCachedThreadPool();

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });

        for (List<Cell> cellList : field.getCells()) {
            Runnable cellTask = () -> {
                for (Cell cell : cellList) {
                    List<NatureObject> listOfEntity = cell.getListOfEntity();
                    for (NatureObject entity : listOfEntity) {
                        if (entity instanceof Fauna fauna) {
                            foodCoordinator.eatOnCell(cell, fauna);
                            reproduceCoordinator.reproduceOnCell(cell, fauna);
                            movementCoordinator.move(field, cell, fauna);
                        }
                    }
                }
            };
            executorService.submit(cellTask);
        }

        scheduledExecutorService.scheduleWithFixedDelay(scheduleTask, 5, 15, TimeUnit.SECONDS);

        executorService.shutdown();
    }

    private Field initField(MapConfig mapConfig) {
        Field field = new Field();
        for (int i = 0; i < mapConfig.getX(); i++) {
            field.getCells().add(new ArrayList<>());
            for (int j = 0; j < mapConfig.getY(); j++) {
                field.getCells().get(i).add(new Cell(i, j));
            }
        }
        return field;
    }

}