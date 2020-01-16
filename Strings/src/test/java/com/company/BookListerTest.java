package test.java.com.company;
import main.java.com.company.BookLister;

public class BookListerTest {
    public static void main(String[] args) throws Exception {
        processFile_givesCorrectOutput();
    }
    public static void processFile_givesCorrectOutput() throws Exception {
        String expectedOutput = "| Pub Date    |                         Title | Authors               |\n" +
                "|=====================================================================|\n" +
                "| 29 Jul 1954 |             Lord of the Rings | John Ronald Reuel ... |\n" +
                "| 01 Aug 1996 |             A Game of Thrones | George Raymond Martin |\n" +
                "| 21 Jun 2003 | Harry Potter and the Order... |        Joanne Rowling |";
        String processedOutput = BookLister.processFile("simpleData.csv");
        if (!processedOutput.equals(expectedOutput)) throw new Exception("Output is not equal to expected output");
        else System.out.println("Passed: givesCorrectOutput");
    }
}
