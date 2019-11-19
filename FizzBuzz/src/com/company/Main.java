package com.company;

public class Main {

    public static void main(String[] args) {
        for( int i = 0; i <= 200; i++) {
            String output = "";

            if (i % 11 == 0) {
                // Don't need to check division by 3, 5, 7
                if (i % 13 == 0) output = "FezzBong";
                else output = "Fezz";
            } else {
                if (i % 3 == 0) output += "Fizz";
                if (i % 13 == 0) output += "Fezz";
                if (i % 5 == 0) output += "Buzz";
                if (i % 7 == 0) output += "Bang";
            }

            if(!output.equals("")) System.out.println(output);
            else System.out.println(i);
        }
    }
}
