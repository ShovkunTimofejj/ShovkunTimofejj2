package module2;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.List;

public class Island {
    private final Location[][] locations;
    private final ExecutorService executor;
    private final Random random;

    public Island(int width, int height) {
        this.locations = new Location[width][height];
        initializeLocations();
        this.executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        this.random = new Random();
    }

    private void initializeLocations() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location();
            }
        }
    }

    public void simulateOneDay() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                Runnable locationTask = new LocationTask(locations[i][j]);
                executor.execute(locationTask);
            }
        }
        executor.shutdown();
    }

    private class LocationTask implements Runnable {
        private final Location location;

        public LocationTask(Location location) {
            this.location = location;
        }

        @Override
        public void run() {
            List<Animal> animals = location.getAnimals();
            List<Plant> plants = location.getPlants();

            // Логіка взаємодії тварин та рослин у даній локації
            for (Animal animal : animals) {
                for (Plant plant : plants) {
                    if (animal.canEat(plant) && random.nextDouble() < animal.getEatProbability()) {
                        animal.eat(plant);
                        location.removePlant(plant);
                        break;
                    }
                }
                animal.move(location); // Рух тварини
                animal.reproduce(); // Розмноження тварини
            }
        }
    }
}
