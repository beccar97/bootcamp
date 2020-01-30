package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        timeForN(5);
        timeForN(10);
        timeForN(100);
        timeForN(1000);
    }

    private static void timeForN(int n) {
        System.out.println("\nN: " + n);
        System.out.println("--------------------");
        List<Integer> list = getRandomList(n);

        System.out.println("S: " + SelectionSort.timeSort(new ArrayList<>(list))+"ms");
        System.out.println("I: " + InsertionSort.timeSort(new ArrayList<>(list))+"ms");
        System.out.println("M: " + MergeSort.timeSort(list)+"ms");
        System.out.println("Q: " + QuickSort.timeSort(list)+"ms");

    }

    private static List<Integer> getRandomList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add((int) Math.floor(Math.random() * 500));
        }
        return list;
    }

    private static List<Integer> getList() {
        List<Integer> list = new ArrayList<>();
        list.add(173);
        list.add(115);
        list.add(247);

        return list;
    }
}
