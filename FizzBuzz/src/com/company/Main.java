package com.company;

public class Main {

    public static void main(String[] args) {
        for( int i = 0; i <= 100; i++) {
            String output = "";
            if (i % 3 == 0) output += "Fizz";
            if (i % 5 == 0) output += "Buzz";
            if (i % 7 == 0) output += "Bang";

            if(!output.equals("")) System.out.println(output);
            else System.out.println(i);
        }
    }
}
