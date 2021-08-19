package steps;


import com.consol.citrus.validation.json.JsonPathVariableExtractor;
import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.ru.Если;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import net.minidev.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JSONSteps {

    @Если("извлечь JSON значения")
    public void addJSON() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/resources/files/JSONFile.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            String sobj = String.valueOf(obj);
            System.out.println(sobj);

            //Find number of content
            JSONArray jsonArray = JsonPath.read(sobj, "$.categories..content");
            int numberContent = jsonArray.size();
            System.out.println(numberContent);

            //Extract JSON values
            Object invalid = JsonPath.read(sobj, "$.categories..content");
            System.out.println(invalid);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }





}
