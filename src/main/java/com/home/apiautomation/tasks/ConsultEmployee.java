package com.home.apiautomation.tasks;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultEmployee implements Task {

    EnvironmentVariables environmentVariables;
    private int id;

    ConsultEmployee(int id) {
        this.id = id;
    }

    @Override
    @Step("{0} search the employee with id #id")
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Get.resource(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("restapi.employeePath") + "/{id}")
                    .with(request -> request.pathParam("id", id))
        );
    }

    public static ConsultEmployee byId(int id) {
        return instrumented(ConsultEmployee.class, id);
    }

}
