package com.company.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Container<T extends Countable> implements Countable {
    List<T> contents = new ArrayList<>();

    public void addItem(T item) {
        contents.add(item);
    }

    public int getCount() {
        return contents.stream().mapToInt(T::getCount).sum();
    }
}
