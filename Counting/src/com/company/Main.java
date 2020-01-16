package com.company;

import com.company.models.*;

public class Main {

    public static void main(String[] args) {
        Counter<Apple> appleCounter = new Counter<>();
        appleCounter.add(new Apple());
        appleCounter.add(new Apple());
        System.out.println(String.format("Number of apples: %d", appleCounter.getCount()));

        Counter<Box<?>> boxCounter = new Counter<>();
        Box<Apple> appleBox = new Box<>();
        appleBox.addItem(new Apple());
        appleBox.addItem(new Apple());
        Box<Orange> orangeBox = new Box<>();
        orangeBox.addItem(new Orange());
        boxCounter.add(appleBox);
        boxCounter.add(orangeBox);
        System.out.println(String.format("Number of items in boxes: %d", boxCounter.getCount()));

        Cart cart = new Cart();
        cart.addItem(orangeBox);
        cart.addItem(appleBox);
        Counter<Cart> cartCounter = new Counter<>();
        cartCounter.add(cart);
        cartCounter.add(cart);
        System.out.println(String.format("Number of items in cart : %d", cartCounter.getCount()));

    }
}
