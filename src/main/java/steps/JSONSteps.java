package steps;

import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.dsl.runner.TestRunner;
import com.consol.citrus.dsl.runner.DefaultTestRunner;
import com.consol.citrus.validation.json.JsonPathVariableExtractor;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Если;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.LoggerFactory;


public class JSONSteps {

    @CitrusResource
    TestRunner runner;

    ResourceUtils resourcesUtils;
    private SizedMessageStore messages;

    @Before
    public void init(){
        this.resourcesUtils = new ResourceUtils(this.runner);
        this.messages = OrderedMessageStore.createOrderedMessageStore(this.runner);
    }


    @Если("добавить JSON в переменную \"([^\"]*)\"$")
    public void addJSON(String variable) {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/resources/files/JSONFile.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            String sobj = String.valueOf(obj);
            System.out.println(sobj);

            JsonPathVariableExtractor variableExtractor = new JsonPathVariableExtractor();
            variableExtractor.getJsonPathExpressions().put(sobj, variable);

            runner.variable(variable, sobj);
            System.out.println(variable);

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

            runner.variable(variable, sobj);
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
