package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Duck implements Comparable<Duck> {
    private String name;
    private String type;
    private int weightInGrams;
    private int ageInMonths;

    public Duck(String name, String type, int weightInGrams, int ageInMonths) {
        this.name = name;
        this.type = type;
        this.weightInGrams = weightInGrams;
        this.ageInMonths = ageInMonths;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getWeightInGrams() {
        return weightInGrams;
    }

    public int getAgeInMonths() {
        return ageInMonths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duck duck = (Duck) o;
        return weightInGrams == duck.weightInGrams &&
                ageInMonths == duck.ageInMonths &&
                Objects.equals(name, duck.name) &&
                Objects.equals(type, duck.type);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 17 * result + ((Integer) weightInGrams).hashCode();
        result = 37 * result + ((Integer) ageInMonths).hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s is a %s weighing %dg. They are %d months old.", name, type, weightInGrams, ageInMonths);
    }

    @Override
    public int compareTo(Duck duck) {
        if (ageInMonths > duck.ageInMonths) return 1;
        else if (ageInMonths < duck.ageInMonths) return -1;

        if (weightInGrams > duck.weightInGrams) return 1;
        else if (weightInGrams < duck.weightInGrams) return -1;

        return 0;
    }

    public static void main(String[] args) {
        Duck quack = new Duck("Sir Quackalot", "Mallard", 100, 17);
        Duck bob = new Duck("Bob", "White-winged duck", 2400, 16);
        Duck cathy = new Duck("Cathy", "Wandering Whistling Duck", 750, 23);

        List<Duck> ducks = new ArrayList<>();
        ducks.add(quack);
        ducks.add(bob);
        ducks.add(cathy);

        ducks.sort(Duck::compareTo);

        System.out.println("All my ducks in row: ");
        ducks.forEach(duck -> System.out.println(duck.toString()));
    }
}