package com.home.apiautomation.stepdefinitions;

import com.home.apiautomation.tasks.ConsultEmployeeCreated;
import com.home.apiautomation.tasks.DeletionEmployeeCreated;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeletionEmployeesStepDefinition {

    @When("he delete an employee with the id saved")
    public void heDeleteAnEmployeeWithTheIdSaved() {
        theActorInTheSpotlight().attemptsTo(
            DeletionEmployeeCreated.byId()
        );
    }

}
