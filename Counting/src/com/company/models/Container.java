package com.company.models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Container<T extends Countable> implements Countable {
    private List<T> contents = new ArrayList<>();

    public void addItem(T item) {
        contents.add(item);
    }

    public int getCount() {
        return contents.stream().mapToInt(T::getCount).sum();
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
