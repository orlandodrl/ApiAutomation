package com.home.apiautomation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/test_cucumber.feature",
        glue = "com.home.apiautomation.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerTest {
}
