package com.company.models;

public class Apple implements Countable {
    public AppleColour colour;

    public Apple(AppleColour colour) {
        this.colour = colour;
    }

    @Override
    public int getCount() {
        return 1;
    }

    public AppleColour getColour() {
        return colour;
    }
}
