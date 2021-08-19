package steps;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import io.cucumber.java.ru.Если;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CSVSteps {

    @Если("пропарсить CSV")
    public void Test() {
        try {
            CSVReader reader = new CSVReader(new FileReader("src/main/resources/files/CsvFile.csv"));
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

    @Если("отсортировать CSV2")
    public void Test2() throws IOException, CsvException {
            CSVReader reader = new CSVReader(new FileReader("src/main/resources/CsvFile.csv"));
            List<String[]> myEntries = reader.readAll();
            myEntries.sort(Collections.reverseOrder());

            }


}



