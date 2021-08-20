package steps;


import io.cucumber.java.ru.Если;
import java.io.*;


public class CSVSteps {

    @Если("пропарсить и отсортировать CSV")
    public void Test() {
        try {
            //Order by "weight" DESC
            String filePath = "src/main/resources/files/CsvFile.csv";
            CSVFile csv = new CSVFile(filePath);
            csv.setSortDirection(csv.SortDESC);
            csv.sortByCol(0);

            //Save to newCsvFile.csv
            csv.save();
            csv.printNewCSV();
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }




}



