package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	System.out.println(SelectionSort.sort(getList()));
    }

    private static List<Integer> getList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(13);
        list.add(36);
        list.add(7);
        list.add(-3);
        list.add(4);
        return list;
    }
}
