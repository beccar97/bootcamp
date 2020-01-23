package com.company;

import com.company.models.*;

public class Main {

    public static void main(String[] args) {
        Counter<Apple> appleCounter = new Counter<>();
        Counter<Apple> redAppleCounter = new Counter<>(apple -> apple.getColour() == AppleColour.RED);

        Box<Apple> appleBox = new Box<>();
        for (int i = 0; i <= 5; i++) {
            appleBox.addItem(createRedApple());
            appleBox.addItem(createGreenApple());
            appleBox.addItem(createYellowApple());
            appleBox.addItem(createGoldenApple());
        }

        appleCounter.addContainer(appleBox);
        redAppleCounter.addContainer(appleBox);

        System.out.println(String.format("Total number of apples: %d", appleCounter.getCount()));
        System.out.println(String.format("Number of red apples: %d", redAppleCounter.getCount()));
    }

    private static Apple createRedApple() {
        return new Apple(AppleColour.RED);
    }

    private static Apple createGreenApple() {
        return new Apple(AppleColour.GREEN);
    }

    private static Apple createYellowApple() {
        return new Apple(AppleColour.YELLOW);
    }

    private static Apple createGoldenApple() {
        return new Apple(AppleColour.GOLDEN);
    }

    private void original() {
        Apple apple1 = new Apple(AppleColour.RED);
        Apple apple2 = new Apple(AppleColour.RED);

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        Box<Apple> appleBox = new Box<>();
        appleBox.addItem(apple1);
        appleBox.addItem(apple2);

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addItem(orange1);

        Box<Orange> orangeBox2 = new Box<>();
        orangeBox2.addItem(orange2);
        orangeBox2.addItem(orange3);

        Cart cart1 = new Cart();
        cart1.addItem(appleBox);
        cart1.addItem(orangeBox);
        Cart cart2 = new Cart();
        cart2.addItem(orangeBox2);

        Counter<Cart> cartCounter = new Counter<>();
        cartCounter.add(cart1);
        cartCounter.add(cart2);

        Counter<Box<?>> cart1BoxCounter = new Counter<>();
        cart1BoxCounter.addContainer(cart1);
        Counter<Box<?>> cart2BoxCounter = new Counter<>();
        cart2BoxCounter.addContainer(cart2);

        System.out.println(String.format("Number of carts: %d", cartCounter.getShallowCount()));
        System.out.println(String.format("Number of boxes in cart 1: %d", cart1BoxCounter.getShallowCount()));
        System.out.println(String.format("Number of items in cart 1: %d", cart1BoxCounter.getCount()));
        System.out.println(String.format("Number of boxes in cart 2: %d", cart2BoxCounter.getShallowCount()));
        System.out.println(String.format("Number of items in cart 2: %d", cart2BoxCounter.getCount()));
        System.out.println(String.format("Number of items in carts: %d", cartCounter.getCount()));

        Caravan caravan = new Caravan();
        caravan.addItem(cart1);
        caravan.addItem(cart2);

        Counter<Countable> generalCounter = new Counter<>();
        generalCounter.add(apple1);
        generalCounter.add(cart2);
//        generalCounter.addContainer(appleBox); Fails because appleBox is of type Box<Apple> not Box<Countable>

    }
}
