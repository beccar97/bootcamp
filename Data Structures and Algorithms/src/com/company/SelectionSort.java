package com.company;

import java.util.List;

public class SelectionSort{
    // Note this actually sorts the original list in place

    public static List<Integer> sort(List<Integer> list) {
        if (list.size() > 1) {
            int indexOfSmallest = findSmallest(list);
            Integer temp = list.get(indexOfSmallest);
            list.set(indexOfSmallest, list.get(0));
            list.set(0, temp);

            sort(list.subList(1, list.size()));

        }
        return list;
    };

    private static int findSmallest(List<Integer> list) {
        return list.stream().reduce(0, (index, item) -> {
            if (item < list.get(index)) return list.indexOf(item);
            return index;
        });
    }
}
