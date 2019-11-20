package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileContent = readFile();

        Pattern emailPattern = Pattern.compile("\\b[\\w.'_%+-]+@(([\\w-]+\\.)+[\\w-]+)\\b");
        Matcher emailMatcher = emailPattern.matcher(fileContent);

        HashMap<String, Integer> emailDomains = new HashMap<String, Integer>();

        while (emailMatcher.find()) {
            String domain = emailMatcher.group(1);
            emailDomains.put(domain, emailDomains.getOrDefault(domain, 0) + 1);
        };

        Map<String, Integer> sorted = emailDomains
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        System.out.println(sorted);


    }

    static String readFile() throws IOException {
        Path filePath = Paths.get("sample.txt");

        String content = Files.readString(filePath);

        return content;
    }

    static int countSwEMails(String fileContent) {
        Pattern swEmailPattern = Pattern.compile("\\b[\\w.'_%+-]+@softwire\\.com\\b");
        Matcher swMatcher = swEmailPattern.matcher(fileContent);

        int counter = 0;

        while (swMatcher.find()) {
            counter++;
        }

        return counter;
    }
}
