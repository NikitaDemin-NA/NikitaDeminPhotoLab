package steps;


import com.consol.citrus.validation.json.JsonPathVariableExtractor;
import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Если;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import net.minidev.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.LoggerFactory;
import org.json.JSONException;
import org.json.JSONObject;


public class JSONSteps {

    @Если("добавить JSON в переменную \"([^\"]*)\"$")
    public void addJSON(String variable) {
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


    @Если("извлечь из JSON значение \"([^\"]*)\" в переменную \"([^\"]*)\"$")
    public void extraxt(String path, String variable) {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/resources/JSONFile.json")) {
            //Read JSON file
            String sobj = (String) jsonParser.parse(reader);
            //String sobj = obj.toString();
            System.out.println(sobj);

            JsonPathVariableExtractor variableExtractor = new JsonPathVariableExtractor();
            variableExtractor.getJsonPathExpressions().put(path, variable);

            //TestContext testContext = ((DefaultTestRunner) this.runner).getTestContext();


           // Message message = new DefaultMessage();
            //message.setPayload(testContext.replaceDynamicContentInString(testContext.getVariable(sobj)));
            //variableExtractor.extractVariables(message, testContext);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Если("добавить сообщению \"([^\"]*)\" тело \"([^\"]*)\"$")
    public void addPayloadToMessage(String messageName, String payload) {
   //     this.messages
        this.addPayloadToMessage(messageName,payload);
    }


}
