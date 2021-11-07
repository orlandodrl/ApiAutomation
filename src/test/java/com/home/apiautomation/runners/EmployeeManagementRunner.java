package com.home.apiautomation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/employee_management",
        glue = "com.home.apiautomation.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class EmployeeManagementRunner {
}
