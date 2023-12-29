package module2;

public class Herbivore extends Animal {
    // Конструктор
    public Herbivore(String species, double weight, int maxPopulationPerLocation) {
        super(species, weight, maxPopulationPerLocation);
        // Додаткові налаштування для травоїдних
    }

    @Override
    public void eat(Object food) {
        // Логіка харчування травоїдних
    }

    @Override
    public void reproduce() {
        // Логіка розмноження травоїдних
    }

    @Override
    public void move() {
        // Логіка переміщення травоїдних
    }

    // Додаткові методи та поля для травоїдних
}
