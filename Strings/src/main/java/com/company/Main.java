package main.java.com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

public class Main {
    private static int dateWidth = 11;
    private static int titleWidth = 29;
    private static int authorWidth = 21;
    private static String formatString = ("| %-" + dateWidth + "s | %" + titleWidth + "s | %-" + authorWidth + "s |");
    private static String bodyFormatString = ("| %-" + dateWidth + "s | %" + titleWidth + "s | %" + authorWidth + "s |");

    public static void main(String[] args) throws IOException {
        System.out.println(processFile("simpleData.csv"));
    }

    public static String processFile(String fileName) throws IOException {
        Path filePath = Paths.get(String.format("src/main/resources/%s", fileName));
        BufferedReader fileBufferedReader = new BufferedReader(new FileReader(String.valueOf(filePath)));
        StringBuilder output = new StringBuilder();

        fileBufferedReader.readLine();
        output.append(getTableHeader());

        String line;
        while ((line = fileBufferedReader.readLine()) != null) {
            output.append("\n");
            output.append(processEntry(line));
        }
        return output.toString();
    }

    private static String getTableHeader () {
        String headers = String.format(formatString, "Pub Date", "Title", "Authors");
        String divider = "\n|"
                + String.join("", Collections.nCopies(headers.length() -2, "="))
                + "|";
        return headers + divider;
    }

    private static String processEntry(String line) {
        String[] lineContents = line.split(",");
        String dateString = processDate(lineContents[0]);
        String titleString = processTitle(lineContents[1]);
        String authorString = processAuthors(lineContents[2]);

        return String.format(bodyFormatString, dateString, titleString, authorString);
    }

    private static String processDate(String dateInput) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDate publishDate = LocalDate.parse(dateInput, inputFormatter);

        return publishDate.format(outputFormatter);
    }

    private static String processTitle(String titleInput) {
        return shorten(titleInput, 29);
    }

    private static String processAuthors(String authorInput) {
        return shorten(authorInput, 21);
    }

    private static String shorten(String string, int length) {
        return string.length() <= length ? string
                : string.substring(0,length - 3) + "...";
    }
}

