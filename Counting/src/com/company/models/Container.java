package com.company.models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class Container<T> implements Countable {
    private Predicate<T> countableFilter = item -> item instanceof Countable;

    private List<T> contents = new ArrayList<>();

    public void addItem(T item) {
        contents.add(item);
    }

    public int getCount() {
        List<Countable> countables = contents.stream().filter(countableFilter).map(item -> (Countable) item).collect(Collectors.toList());
        return countables.stream().mapToInt(Countable::getCount).sum() + (contents.size() - countables.size());
    }

    public List<T> getContents() {
        return contents;
    }

    public long getCountOfType(Class<?> cls) {
        AtomicLong count = new AtomicLong();
        count.addAndGet(contents.stream().filter(item -> item.getClass() == cls).map(cls::cast).count());
        contents.forEach(item -> {
            var itemCount = 0;
            if (item instanceof Container) {
                itemCount += ((Container<?>) item).getCountOfType(cls);
            }
            count.addAndGet(itemCount);
        });
        return count.get();
    }
}
