package stepRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/features/Features.feature", tags = "@ValidLogin or @InvalidLogin", glue = "stepDefinitions")
public class Runner {

}
