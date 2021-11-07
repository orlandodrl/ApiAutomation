package com.home.apiautomation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepTest {

    @Given("Sergey is on the DuckDuckGo home page")
    public void pruebaGiven() {
        System.out.println("GIVEN");
    }

    @When("he searches for {string}")
    public void pruebaWhen(String text) {
        System.out.println("WHEN " + text);
    }

    @Then("all the result titles should contain the word {string}")
    public void pruebaThen(String text) {
        System.out.println("THEN " + text);
    }

}



