package steps;


import com.consol.citrus.validation.json.JsonPathVariableExtractor;
import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.bs.A;
import io.cucumber.java.ru.Если;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minidev.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JSONSteps {

    @Если("извлечь значения id из JSON файла")
    public void addJSON() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/resources/files/JSONFile.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            String sobj = String.valueOf(obj);

            //Find number of content
            JSONArray jsonArray = JsonPath.read(sobj, "$.categories..content");
            int numberContent = jsonArray.size();

            //Find all id from content
            for(int i=0; i<numberContent; i++) {
                //Extract JSON values
                JSONArray invalid = JsonPath.read(sobj, "$.categories[" + i + "]..content..id");
                System.out.println(invalid);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    @Если("testTest")
    public void testTest(){
        List<String> listDesc = new ArrayList<>();
        listDesc.add("0");
        listDesc.add("12");
        listDesc.add("123");

        List<String> listDesc2 = new ArrayList<>();
        listDesc2.add("123");
        listDesc2.add("12");
        listDesc2.add("1");
        listDesc2.add("123");

        int integer = -1;
        boolean checkAvailable = false;

        for (int j = 0; j < listDesc.size(); j++) {
            for (int k = 0; k < listDesc2.size(); k++) {
                //Check sort of index
                if((listDesc2.get(k).equals(listDesc.get(j)))){
                    checkAvailable = true;
                    if (k>integer){
                        integer = k;
                    } else {
                        System.out.println("Элемент "+listDesc.get(j)+" не соответствует порядку");
                    }
                }
            }
            if(!checkAvailable){
                System.out.println("Элемент "+listDesc.get(j)+" не найден");
            }
            checkAvailable=false;
        }
    }




}
