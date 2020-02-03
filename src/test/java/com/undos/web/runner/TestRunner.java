package com.undos.web.runner;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(  features = "src/test/resources/"
        , glue = {"com.undos.web.steps"}
        , plugin = {"json:target/cucumber-report/cucumber.json"}
)
public class TestRunner {
}
