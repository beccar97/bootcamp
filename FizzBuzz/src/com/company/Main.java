package com.company;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        for( int i = 1; i <= 260; i++) {
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

            StringBuilder output = new StringBuilder();
            ListIterator outputIterator = outputWords.listIterator();
            if (i % 17 == 0) {
                while (outputIterator.hasNext()){
                    output.insert(0, outputIterator.next());
                }
            } else {
                while (outputIterator.hasNext()) {
                    output.append(outputIterator.next());
                }
            }

            if (output.toString().isEmpty()) {
                System.out.println(i);
            }
            else {
                System.out.println(output);
            }
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
}
