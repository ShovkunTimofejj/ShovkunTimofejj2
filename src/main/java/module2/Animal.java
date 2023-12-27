package module2;
import java.util.Random;

public abstract class Animal {
    protected int weight;
    protected int maxPopulation;
    protected int speed;
    protected int foodRequired;
    public abstract boolean canEat(Plant plant);

    public abstract double getEatProbability();

    public Animal(int weight, int maxPopulation, int speed, int foodRequired) {
        this.weight = weight;
        this.maxPopulation = maxPopulation;
        this.speed = speed;
        this.foodRequired = foodRequired;
    }

    // Методи, які можна перевизначити у підкласах
    abstract void eat(Plant plant);

    abstract void eat(Object food);

    abstract void reproduce();
    abstract void move(Location location);

    // Метод, що визначає, чи з'їсть тварина іншу тварину за певних умов
    protected boolean willEat(Animal other, int probability) {
        Random random = new Random();
        int chance = random.nextInt(100); // випадкове число від 0 до 99

        return chance < probability; // повертає true, якщо випадкове число менше заданої ймовірності
    }
}

// Підклас для хижаків
class Predator extends Animal {
    @Override
    public boolean canEat(Plant plant) {
        // Логіка для визначення, чи може хижак з'їсти вказану рослину
        // Перевірка, чи є рослина їстівною для хижака
        return plant.isEdible();
    }

    @Override
    public double getEatProbability() {
        return 0;
    }

    public Predator(int weight, int maxPopulation, int speed, int foodRequired) {
        super(weight, maxPopulation, speed, foodRequired);
    }

    @Override
    void eat(Plant plant) {

    }

    @Override
    void eat(Object food) {
        if (food instanceof Animal) {
            Animal prey = (Animal) food;

            // Перевірка можливості з'їсти
            if (willEat(prey, 60)) { // Якщо є 60% шанс з'їсти здобич
                // Виконуємо логіку з'їдання
                System.out.println("Predator is eating the prey.");
                // Логіка зменшення кількості з'їжи
                // Тут може бути логіка збільшення кількості енергії хижака після їжі
            } else {
                System.out.println("Predator did not catch the prey this time.");
            }
        } else {
            System.out.println("Predator cannot eat this type of food.");
        }
    }

    @Override
    void reproduce() {
        // Логіка розмноження хижака
        if (maxPopulation > 1) { // Перевірка чи може розмножитися
            Random rand = new Random();
            int reproductionChance = rand.nextInt(100); // Генерація випадкового числа від 0 до 99

            if (reproductionChance < 40) { // Наприклад, є 40% шанс на розмноження
                System.out.println("Predator is reproducing.");
                // Логіка створення нового екземпляру хижака
            } else {
                System.out.println("Predator did not reproduce this time.");
            }
        } else {
            System.out.println("Predator cannot reproduce due to maximum population limit.");
        }
    }


    @Override
    void move(Location location) {
        // Логіка переміщення хижака
        Random rand = new Random();
        int moveDirection = rand.nextInt(4); // Генерація випадкового напрямку руху (можна використати Enum)

        switch (moveDirection) {
            case 0:
                System.out.println("Predator is moving north.");
                // Логіка переміщення хижака на північ
                break;
            case 1:
                System.out.println("Predator is moving east.");
                // Логіка переміщення хижака на схід
                break;
            case 2:
                System.out.println("Predator is moving south.");
                // Логіка переміщення хижака на південь
                break;
            case 3:
                System.out.println("Predator is moving west.");
                // Логіка переміщення хижака на захід
                break;
            default:
                System.out.println("Predator stays idle.");
                // Хижак залишається на місці
        }
    }
}


// Підклас для травоїдних
class Herbivore extends Animal {
    @Override
    public boolean canEat(Plant plant) {
        return false;
    }

    @Override
    public double getEatProbability() {
        return 0;
    }

    public Herbivore(int weight, int maxPopulation, int speed, int foodRequired) {
        super(weight, maxPopulation, speed, foodRequired);
    }

    @Override
    void eat(Plant plant) {

    }

    @Override
    void eat(Object food) {
        if (food instanceof Plant) {
            Plant vegetation = (Plant) food;

            // Логіка травоїдної тварини, яка їсть рослини
            System.out.println("Herbivore is eating plants.");
            // Зменшення кількості рослин
            // Поживні речовини для тварини після їжі рослин
        } else {
            System.out.println("Herbivore cannot eat this type of food.");
        }
    }


    @Override
    void reproduce() {
        // Логіка розмноження травоїдної тварини
        if (maxPopulation > 1) { // Перевірка чи може розмножитися
            Random rand = new Random();
            int reproductionChance = rand.nextInt(100); // Генерація випадкового числа від 0 до 99

            if (reproductionChance < 60) { // Наприклад, є 60% шанс на розмноження
                System.out.println("Herbivore is reproducing.");
                // Логіка створення нового екземпляру травоїдної тварини
            } else {
                System.out.println("Herbivore did not reproduce this time.");
            }
        } else {
            System.out.println("Herbivore cannot reproduce due to maximum population limit.");
        }
    }


    @Override
    void move(Location location) {
        // Логіка переміщення травоїдної тварини
        Random rand = new Random();
        int moveDirection = rand.nextInt(4); // Генерація випадкового напрямку руху (можна використати Enum)

        switch (moveDirection) {
            case 0:
                System.out.println("Herbivore is moving north.");
                // Логіка переміщення травоїдної тварини на північ
                break;
            case 1:
                System.out.println("Herbivore is moving east.");
                // Логіка переміщення травоїдної тварини на схід
                break;
            case 2:
                System.out.println("Herbivore is moving south.");
                // Логіка переміщення травоїдної тварини на південь
                break;
            case 3:
                System.out.println("Herbivore is moving west.");
                // Логіка переміщення травоїдної тварини на захід
                break;
            default:
                System.out.println("Herbivore stays idle.");
                // Травоїдна тварина залишається на місці
        }
    }
}

