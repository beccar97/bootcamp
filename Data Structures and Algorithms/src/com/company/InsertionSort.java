package com.company;

import java.util.List;

public class InsertionSort {
    // Note this sorts the original list in place
    public static List<Integer> sort(List<Integer> list) {
        int sortedTo = 0;

        while (sortedTo < list.size() - 1 ){
            sortBelow(list, sortedTo + 1);
            sortedTo++;
        }

        return list;
    }

    public static double timeSort(List<Integer> list) {
        long startTime = System.nanoTime();
        sort(list);
        long endTime = System.nanoTime();

        return ((double)endTime - startTime) / 1_000_000;
    }

    private static void sortBelow(List<Integer> list, int index) {
        while (index > 0 && list.get(index) < list.get(index - 1)) {
            swap(list, index, index - 1);
            index--;
        }
    }

    private static void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get((j)));
        list.set(j, temp);
    }
}
