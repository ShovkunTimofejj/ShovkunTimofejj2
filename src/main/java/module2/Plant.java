package module2;
import java.util.Random;

public class Plant {
    private double size; // розмір рослини
    private boolean isToxic; // чи є отруйною рослина
    private double nutritionalValue; // поживна цінність рослини
    private final Random random; // Генератор випадкових чисел

    public Plant(double size, boolean isToxic, double nutritionalValue) {
        this.size = size;
        this.isToxic = isToxic;
        this.nutritionalValue = nutritionalValue;
        this.random = new Random();
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean isToxic() {
        return isToxic;
    }

    public void setToxic(boolean toxic) {
        isToxic = toxic;
    }

    public double getNutritionalValue() {
        return nutritionalValue;
    }

    public void setNutritionalValue(double nutritionalValue) {
        this.nutritionalValue = nutritionalValue;
    }

    public boolean isEdible() {
        // Логіка, яка визначає, чи є рослина їстівною для хижака
        final double MAX_EDIBLE_SIZE = 10.0; // Максимальний розмір рослини, яку можна споживати
        return !isToxic && nutritionalValue > 0 && size < MAX_EDIBLE_SIZE;
    }

    public boolean tryToReproduce() {
        // Логіка розмноження рослини
        // Наприклад, за певних умов рослина може розмножуватись
        // Повертає true, якщо рослина змогла розмножитись, в іншому випадку - false

        // Приклад умови для розмноження: рослина може розмножуватись, якщо її розмір більше певного значення
        final double REPRODUCTION_SIZE_THRESHOLD = 5.0;
        return size > REPRODUCTION_SIZE_THRESHOLD && random.nextDouble() < 0.5; // Припустима ймовірність розмноження
    }
}