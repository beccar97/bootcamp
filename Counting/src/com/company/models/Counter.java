package com.company.models;

import java.util.ArrayList;
import java.util.List;

public class Counter<T extends Countable> {
    private List<T> items = new ArrayList<>();

    public void add(T item){
        items.add(item);
    };

    public int getCount() {
        return items.stream().mapToInt(Countable::getCount).sum();
    }
}
