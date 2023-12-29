package module2;

public class Predator extends Animal {
    // Конструктор
    public Predator(String species, double weight, int maxPopulationPerLocation) {
        super(species, weight, maxPopulationPerLocation);
        // Додаткові налаштування для хижаків
    }

    @Override
    public void eat(Object food) {
        // Логіка харчування хижаків
    }

    @Override
    public void reproduce() {
        // Логіка розмноження хижаків
    }

    @Override
    public void move() {
        // Логіка переміщення хижаків
    }

    // Додаткові методи та поля для хижаків
}

