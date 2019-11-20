package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileContent = readFile();
        int counter = 0;
        for (int i = 0; i <= fileContent.length() - 13; i++) {
            String substring = fileContent.substring(i, i + 13);
            if (substring.equals("@softwire.com")) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    static String readFile() throws IOException {
        Path filePath = Paths.get("C:/", "Work", "Training", "Email Extraction", "sample.txt");

        String content = Files.readString(filePath);

        return content;
    }
}
