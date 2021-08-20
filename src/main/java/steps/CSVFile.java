package steps;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.ru.Если;
import net.minidev.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

class CSVFile {

    private Map<String, String> records;

    //constants for sortDirection
    final public int SortASC = 1;
    final public int SortDESC = -1;
    private int sortDirection = SortASC; //1 for ASC, -1 for DESC
    String fileName;
    String newFileName;

    List<String> listID;


    private int colsCount;

  /*  @Если("пропарсить и отсортировать CSV")
    public void CSVFile(String fileName) throws IOException {
        //Parsing CSV to Map
        records = new HashMap<>();
        this.fileName = "src/main/resources/files/CsvFile.csv";
        this.newFileName = "src/main/resources/files/newCsvFile.csv";
        try (BufferedReader in = new BufferedReader(new FileReader(this.fileName))) {
            String ln;
            while ((ln = in.readLine()) != null) {
                records.put(ln.split(",")[1], ln.split(",")[0]);
            }
        }

        //Set clm weight to List
        List<String> listValuesWeight = new ArrayList<>(records.values());
        Collections.sort(listValuesWeight);
        Collections.reverse(listValuesWeight);

        //Create List for list of ID
        listID = new ArrayList<>();
        for (int i = 0; i < listValuesWeight.size(); i++) {
            for (Map.Entry<String, String> valueMap : records.entrySet()) {
                if (valueMap.getValue().equals(listValuesWeight.get(i))) {
                    //Check dublicate id
                    if (!listID.contains(valueMap.getKey())) {
                        listID.add(valueMap.getKey());
                    }
                }
            }
        }
        System.out.println(listID);

    }





    public void setSortDirection(int direction) {
        sortDirection = direction;
    }*/






}



