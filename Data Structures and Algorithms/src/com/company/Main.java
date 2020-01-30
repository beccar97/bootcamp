package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = getList();

        List<Integer> selectionSorted = SelectionSort.sort(new ArrayList<>(list));
        List<Integer> mergeSorted = MergeSort.sort(list);
        List<Integer> insertionSorted = InsertionSort.sort(new ArrayList<>(list));

        System.out.println(selectionSorted.toString() + '\n' + mergeSorted.toString() + '\n' + insertionSorted.toString());

    }

    private static List<Integer> getList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            list.add((int) Math.floor(Math.random() * 500));
        }
        return list;
    }
}
