package com.home.apiautomation.stepdefinitions;

import com.home.apiautomation.exceptions.CommonException;
import com.home.apiautomation.model.Employee;
import com.home.apiautomation.questions.TheEmployee;
import com.home.apiautomation.tasks.ConsultAllEmployees;
import com.home.apiautomation.tasks.ConsultEmployee;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static com.home.apiautomation.exceptions.ExceptionMessages.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class ConsultEmployeesStepDefinition {

    @When("he consults all employees")
    public void consultingTheSecondGroupOfThreeUsers() {
        theActorInTheSpotlight().attemptsTo(
            ConsultAllEmployees.registered()
        );
    }

    @Then("the response code should be {int}")
    public void theResponseCodeShouldBe(int responseCode) {
        theActorInTheSpotlight().should(
                seeThatResponse("The response code should be: " + responseCode,
                        response -> response.statusCode(responseCode))
                        .orComplainWith(CommonException.class, UNEXPECTED_RESPONSE_CODE.getMessage()));
    }

    @And("the message in the response should be {string}")
    public void theMessageInTheResponseShouldBe(String message) {
        theActorInTheSpotlight().should(
                seeThatResponse("The message in the response should be: " + message,
                        response -> response.body("message", equalTo(message)))
                        .orComplainWith(CommonException.class, UNEXPECTED_MESSAGE.getMessage()));
    }

    @And("the structure of the response is correct with {string}")
    public void theStructureOfTheResponseIsCorrectWith(String jsonSchema) {
        theActorInTheSpotlight().should(
                seeThatResponse("The response obtained must comply with the defined structure",
                        response -> response.assertThat().body(matchesJsonSchemaInClasspath(jsonSchema)))
                        .orComplainWith(CommonException.class, UNEXPECTED_STRUCTURE.getMessage()));
    }

    @When("he consults an employee by the id {int}")
    public void heConsultsAnEmployeeByTheId(int id) {
        theActorInTheSpotlight().attemptsTo(
            ConsultEmployee.byId(id)
        );
    }

    @And("and see that the data queried is correct")
    public void andSeeThatTheDataQueriedIsCorrect(Employee employeeExpected) {
        System.out.println("Estoy aqui");
        System.out.println(employeeExpected.toString());
        theActorInTheSpotlight().should(
                seeThat(TheEmployee.consulted(), equalTo(employeeExpected))
                        .orComplainWith(CommonException.class, INCORRECT_VALUES.getMessage())
        );
    }

}
