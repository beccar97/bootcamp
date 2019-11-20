package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByValue;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(countSwEMails());

        Map<String, Integer> domains = countDomains();
        logCommonDomains(10, domains);
        logFrequentDomains(domains);
    }

    private static Map<String, Integer> countDomains() throws IOException {
        Pattern emailPattern = Pattern.compile("(?<=^|\\s)[\\w.'_%+-]+@(([\\w-]+\\.)+[\\w-]+)(?=\\s|$)");
        HashMap<String, Integer> emailDomains = new HashMap<String, Integer>();

        Path filePath = Paths.get("sample.txt");
        BufferedReader fileBufferedReader = new BufferedReader(new FileReader(String.valueOf(filePath)));
        Stream<String> fileLines = fileBufferedReader.lines();

        fileLines.forEach(line -> {
            Matcher emailMatcher = emailPattern.matcher(line);
            while (emailMatcher.find()) {
                String domain = emailMatcher.group(1);
                emailDomains.put(domain, emailDomains.getOrDefault(domain, 0) + 1);
            }
        });

        return emailDomains
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

    }

    private static int countSwEMails() throws IOException {
        Path filePath = Paths.get("sample.txt");
        String fileContent = Files.readString(filePath);

        Pattern swEmailPattern = Pattern.compile("(?<=^|\\s)[\\w.'_%+-]+@softwire\\.com(?=$|\\s)");
        Matcher swMatcher = swEmailPattern.matcher(fileContent);

        int counter = 0;
        while (swMatcher.find()) counter++;

        return counter;
    }

    private static void logCommonDomains(int n, Map<String, Integer> domains) {
        String[] domainArray = domains.keySet().toArray(new String[0]);

        System.out.println(String.format("The %d most common domains are:", n));

        for (int i = 0; i < n && i < domainArray.length; i++) {
            System.out.println(String.format("%s: %d occurrences", domainArray[i], domains.get(domainArray[i])));
        }
    }

    private static void logFrequentDomains(Map<String, Integer> domains) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter minimum frequency:");
        int freq = userInput.nextInt();

        System.out.println(String.format("Domains occurring with frequency greater than %d", freq));

        domains.forEach((domain,frequency) -> {
            if (frequency >= freq) System.out.println(String.format("%s: %d occurrences", domain, frequency));
        });
    }
}
