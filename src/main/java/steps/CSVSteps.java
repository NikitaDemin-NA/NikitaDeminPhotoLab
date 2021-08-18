package steps;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import io.cucumber.java.ru.Если;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CSVSteps {

    @Если("отсортировать CSV")
    public void Test() {
        try {
            CSVReader reader = new CSVReader(new FileReader("src/main/resources/CsvFile.csv"));
            reader.iterator();
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                System.out.println(nextLine[0] + " " + nextLine[1]);
            }
        }catch (Exception e){
            System.out.println("Произошла ошибка во время парсинга CSV\n");
            e.printStackTrace();
        }
    }
}



