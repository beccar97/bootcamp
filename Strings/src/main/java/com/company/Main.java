package main.java.com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(BookLister.processFile("simpleData.csv"));
    }
}

