package com.home.apiautomation.stepdefinitions;

import com.home.apiautomation.model.Employee;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.Map;

public class CommonStepsDefinition {

    private static final String ORLANDO = "Orlando";
    private EnvironmentVariables environmentVariables;

    @DataTableType
    public Employee employee(Map<String, String> employeeInformation) {
        return Employee.builder().name(employeeInformation.get("name")).salary(Integer.valueOf(employeeInformation.get("salary"))).age(Integer.valueOf(employeeInformation.get("age"))).build();
    }

    @Before
    public void prepareStage() {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled(ORLANDO).whoCan(CallAnApi.at(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("restapi.baseurl")));
        RestAssured.filters(new RequestLoggingFilter(),new ResponseLoggingFilter()); //TODO: "Eliminar este comentario"
    }

}
