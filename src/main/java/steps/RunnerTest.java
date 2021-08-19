package steps;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:Report1"},
        features = "src/main/resources/features",
        glue = {"steps"},
        tags = "@Test"
)
public class RunnerTest {
}
