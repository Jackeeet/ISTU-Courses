package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/scenarios",
        glue = "steps",
        tags = "@DataTable"
        //tags = "@SingleScenario"
)
public class Runner {
    @Test
    public static void run(String[] args) {
    }
}