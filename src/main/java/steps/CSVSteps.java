package steps;


import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.ru.Если;
import net.minidev.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;


public class CSVSteps {



    List<String> listID;
    List<String> listIDJSON;

    private Map<String, String> records;

    //constants for sortDirection
    final public int SortASC = 1;
    final public int SortDESC = -1;
    private int sortDirection = SortASC; //1 for ASC, -1 for DESC
    String fileName;
    String newFileName;
    int numberOfListID = 1;


    private int colsCount;

   /* class CSVFile(String fileName) throws IOException {
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

    @Если("извлечь значения id из JSON файла")
    public void addJSON() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/resources/files/JSONFile.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            String sobj = String.valueOf(obj);

            //Find quantity of content
            JSONArray jsonArray = JsonPath.read(sobj, "$.categories..content");
            int numberContent = jsonArray.size();

            //Find all id from content
            for (int i = 0; i < numberContent; i++) {
                //Extract JSON values
                JSONArray jsonArray2 = JsonPath.read(sobj, "$.categories[" + i + "]..content..id");
                listIDJSON = new ArrayList<>();
                if (jsonArray2 != null) {
                    for (Object o : jsonArray2) {
                        listIDJSON.add(o.toString());
                    }
                    System.out.println(listIDJSON);
                    System.out.println("Список id № "+numberOfListID++);
                    testTest();
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    @Если("testTest")
    public void testTest() {
        int integer = -1;
        boolean checkAvailable = false;

        for (int j = 0; j < listIDJSON.size(); j++) {
            for (int k = 0; k < listID.size(); k++) {
                //Check sort of index
                if ((listID.get(k).equals(listIDJSON.get(j)))) {
                    checkAvailable = true;
                    if (k > integer) {
                        integer = k;
                    } else {
                        System.out.println("Элемент " + listIDJSON.get(j) + " не соответствует порядку");
                    }
                }
            }
            if (!checkAvailable) {
                System.out.println("Элемент " + listIDJSON.get(j) + " не найден");
            }
            checkAvailable = false;
        }
    }

   /* @Если("пропарсить и отсортировать CSV")
    public void Test() {
        try {
            //Order by "weight" DESC
            String filePath = "src/main/resources/files/CsvFile.csv";
            CSVFile csv = new CSVFile(filePath);
            csv.setSortDirection(csv.SortDESC);
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }*/

    @Если("пропарсить и отсортировать CSV")
    public void CSVFile() throws IOException {
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
    }


}



