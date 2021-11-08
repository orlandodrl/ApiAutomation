package com.home.apiautomation.stepdefinitions;

import com.home.apiautomation.model.Employee;
import com.home.apiautomation.tasks.ConsultEmployeeCreated;
import com.home.apiautomation.tasks.CreationEmployee;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class CreationEmployeesStepDefinition {

    @When("he create an employee with the information")
    public void heCreateAnEmployeeWithTheInformation(Employee employeeInformation) {
        theActorInTheSpotlight().attemptsTo(
            CreationEmployee.withTheInformation(employeeInformation)
        );
    }

    @When("he consults an employee by the id saved")
    public void heConsultsAnEmployeeByTheIdSaved() {
        theActorInTheSpotlight().attemptsTo(
            ConsultEmployeeCreated.byId()
        );
    }

}
