package test.java.com.company;
import main.java.com.company.Main;

public class Test {
    public static void main(String[] args) throws Exception {
        givesCorrectOutput();
    }
    public static void givesCorrectOutput() throws Exception {
        String expectedOutput = "| Pub Date    |                         Title | Authors               |\n" +
                "|=====================================================================|\n" +
                "| 29 Jul 1954 |             Lord of the Rings | John Ronald Reuel ... |\n" +
                "| 01 Aug 1996 |             A Game of Thrones | George Raymond Martin |\n" +
                "| 21 Jun 2003 | Harry Potter and the Order... |        Joanne Rowling |";
        String processedOutput = Main.processFile("simpleData.csv");
        if (!processedOutput.equals(expectedOutput)) throw new Exception("Output is not equal to expected output");
        else System.out.println("Passed: givesCorrectOutput");
    }
}
