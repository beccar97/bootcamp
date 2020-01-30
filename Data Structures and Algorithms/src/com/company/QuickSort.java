package com.company;

import java.util.List;

public class QuickSort {
    // Sorts the original list in place
    public static List<Integer> sort(List<Integer> list) {
        if (list.size() <= 1) return list;

        int pivot = list.get(list.size() - 1);
        int lessToLeft = 0;
        int unsortedToRight = 0;

        while (unsortedToRight < list.size() - 1) {
            if (list.get(unsortedToRight) <= pivot) {
                swap(list, unsortedToRight, lessToLeft);
                lessToLeft++;
            }
            unsortedToRight++;
        }

        swap(list, list.size() - 1, lessToLeft);

        sort(list.subList(0, lessToLeft));
        if (lessToLeft < list.size() - 1)
            sort(list.subList(lessToLeft + 1, list.size() - 1));

        return list;
    }

    public static double timeSort(List<Integer> list) {
        long startTime = System.nanoTime();
        sort(list);
        long endTime = System.nanoTime();

        return ((double) endTime - startTime) / 1_000_000;
    }

    private static void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get((j)));
        list.set(j, temp);
    }
}

