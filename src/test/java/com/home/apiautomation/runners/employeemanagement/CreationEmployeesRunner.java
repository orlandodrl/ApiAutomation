package com.home.apiautomation.runners.employeemanagement;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/employee_management/creation_employees.feature",
        glue = "com.home.apiautomation.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CreationEmployeesRunner {
}
