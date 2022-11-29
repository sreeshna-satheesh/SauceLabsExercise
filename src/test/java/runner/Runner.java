package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "./Feature/SauceDemo.feature",
		glue="stepDefs",
		monochrome = true,
		//dryRun = true,
		plugin = {"pretty","html: test-output"},
		tags= "@Exercise"
		
		
		
		
		)

public class Runner {

}
