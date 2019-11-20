package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileContent = readFile();
        int swEmailCount = countSwEMails(fileContent);

        System.out.println(swEmailCount);

    }

    static String readFile() throws IOException {
        Path filePath = Paths.get("sample.txt");

        String content = Files.readString(filePath);

        return content;
    }

    static int countSwEMails(String fileContent) {
        Pattern swEmailPattern = Pattern.compile("[\\w.'_%+-]+@softwire\\.com");
        Matcher swMatcher = swEmailPattern.matcher(fileContent);

        int counter = 0;

        while (swMatcher.find()) {
            counter++;
        }

        return counter;
    }
}
