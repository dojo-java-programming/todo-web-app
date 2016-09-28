package org.organisation.todolist;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
			plugin = { "html:target/cucumber/report.html", "json:target/cucumber-report.json" } 
			, features = { "src/test/resources/todo.feature" }
//			, tags = { "@run" }
		)
public class RunCucumberTests {
	// Nothing needed
}
