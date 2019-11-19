package com.company;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int maximumInt = getMaxInt();
        for( int i = 1; i <= maximumInt; i++) {
            LinkedList<String> outputWords = new LinkedList<String>();

            if (i % 11 == 0) {
                outputWords.add("Bong");
            } else {
                if (i % 3 == 0){
                    outputWords.add("Fizz");
                }
                if (i % 5 == 0){
                    outputWords.add("Buzz");
                }
                if (i % 7 == 0) {
                    outputWords.add("Bang");
                }
            }

            if (i % 13 == 0) {
                int index = findFezzIndex(outputWords);
                outputWords.add(index, "Fezz");
            }

            System.out.println(buildOutputString(i, outputWords));

        }
    }

    static int findFezzIndex(LinkedList<String> words) {
        ListIterator wordIterator = words.listIterator();
        int index = 0;
        while (wordIterator.hasNext()) {
            String word = wordIterator.next().toString();
            if (word.charAt(0) == 'B') {
                return index;
            } else index++;
        }
        return index;
    }

    static String buildOutputString(int i, LinkedList<String> outputWords) {
        StringBuilder output = new StringBuilder();
        Iterator outputIterator;
        if (i % 17 == 0) {
            outputIterator = outputWords.descendingIterator();
        } else {
            outputIterator = outputWords.listIterator();
        }

        while (outputIterator.hasNext()){
            output.append(outputIterator.next());
        }

        if (output.toString().isEmpty()) {
            return String.format("%d", i);
        }
        else {
            return output.toString();
        }
    }

    static int getMaxInt() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter maximum number to process up to:");
        int max = userInput.nextInt();

        return max;
    }
}
