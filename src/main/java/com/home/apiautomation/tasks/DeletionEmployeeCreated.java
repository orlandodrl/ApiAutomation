package com.home.apiautomation.tasks;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeletionEmployeeCreated implements Task {

    EnvironmentVariables environmentVariables;

    @Override
    @Step("{0} delete the employee with id #id")
    public <T extends Actor> void performAs(T theActor) {

        Integer idEmployeeCreated = SerenityRest.lastResponse().jsonPath().get("data.id");

        theActor.attemptsTo(
                Delete.from(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("restapi.deleteEmployeePath") + "/{id}")
                    .with(request -> request.pathParam("id", idEmployeeCreated))
        );
    }

    public static DeletionEmployeeCreated byId() {
        return instrumented(DeletionEmployeeCreated.class);
    }

}
