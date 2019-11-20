package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileContent = readFile();

        int swEmailCount = countSwEMails(fileContent);
        System.out.println(swEmailCount);

        Pattern emailPattern = Pattern.compile("\\b[\\w.'_%+-]+@(([\\w-]+\\.)+[\\w-]+)\\b");
        Matcher emailMatcher = emailPattern.matcher(fileContent);

        HashMap<String, Integer> emailDomains = new HashMap<String, Integer>();

        while (emailMatcher.find()) {
            String domain = emailMatcher.group(1);
            emailDomains.put(domain, emailDomains.getOrDefault(domain, 0) + 1);
        };

        System.out.println(emailDomains);


    }

    static String readFile() throws IOException {
        Path filePath = Paths.get("sample.txt");

        String content = Files.readString(filePath);

        return content;
    }

    static int countSwEMails(String fileContent) {
        Pattern swEmailPattern = Pattern.compile("\\s[\\w.'_%+-]+@softwire\\.com\\s");
        Matcher swMatcher = swEmailPattern.matcher(fileContent);

        int counter = 0;

        while (swMatcher.find()) {
            counter++;
        }

        return counter;
    }
}
