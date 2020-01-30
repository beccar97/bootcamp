package com.company;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    // Does not effect the original array

    public static List<Integer> sort(List<Integer> list) {
        if (list.size() <= 1) return list;

        int midPoint = list.size() % 2 == 0
                ? list.size() / 2 : (list.size() - 1) / 2;

        return mergeLists( sort(list.subList(0, midPoint)), sort(list.subList(midPoint, list.size())));

    }


    public static double timeSort(List<Integer> list) {
        long startTime = System.nanoTime();
        sort(list);
        long endTime = System.nanoTime();

        return ((double)endTime - startTime) / 1_000_000;
    }

    private static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        if (i < list1.size()) mergedList.addAll(list1.subList(i, list1.size()));
        if (j < list2.size()) mergedList.addAll(list2.subList(j, list2.size()));

        return mergedList;
    }
}
