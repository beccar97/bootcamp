package com.company.models;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Counter<T> {
    private Predicate<T> countableFilter = item -> item instanceof Countable;
    private Predicate<T> filter = countableFilter;

    private List<T> items = new ArrayList<>();

    public Counter() {
    }

    public Counter(Predicate<T> filter) {
        this.filter = countableFilter.and(filter);
    }

    public void add(T item){
        items.add(item);
    };

    public void addContainer(Container<T> container) {
        container.getContents().forEach(this::add);
    }

    public int getCount() {
        return items.stream().filter(filter).map(item -> (Countable) item).mapToInt(Countable::getCount).sum();
    }

    public int getShallowCount() {
        return items.size();
    }

    public void addFilter(Predicate<T> newFilter) {
        this.filter = this.filter.and(newFilter);
    }
}
