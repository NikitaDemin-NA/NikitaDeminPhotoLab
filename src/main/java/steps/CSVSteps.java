package steps;

import io.cucumber.java.ru.Если;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CSVSteps {

    @Если("test")
        public void Test() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/resources/CsvFile.csv"));
        sc.useDelimiter(", ");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            System.out.print(sc.next());  //find and returns the next complete token from this scanner
        }
        sc.close();  //closes the scanner
    }
}



