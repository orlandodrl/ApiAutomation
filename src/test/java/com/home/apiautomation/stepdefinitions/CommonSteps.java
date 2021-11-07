package com.home.apiautomation.stepdefinitions;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class CommonSteps {

    private static final String ORLANDO = "Orlando";
    private EnvironmentVariables environmentVariables;

    @Before
    public void prepareStage() {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled(ORLANDO).whoCan(CallAnApi.at(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("restapi.baseurl")));
        RestAssured.filters(new RequestLoggingFilter(),new ResponseLoggingFilter()); //TODO: "Eliminar este comentario"
    }

}
