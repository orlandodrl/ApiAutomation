package com.home.apiautomation.tasks;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultAllEmployees implements Task {

    EnvironmentVariables environmentVariables;

    ConsultAllEmployees() {}

    @Override
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Get.resource(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("restapi.employeesPath"))
        );
    }

    public static ConsultAllEmployees registered() {
        return instrumented(ConsultAllEmployees.class);
    }

}
