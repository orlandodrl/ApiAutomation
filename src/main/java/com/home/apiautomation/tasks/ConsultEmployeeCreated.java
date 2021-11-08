package com.home.apiautomation.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;
import static com.home.apiautomation.utils.PathEmployee.CONSULT_EMPLOYEE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultEmployeeCreated implements Task {

    @Override
    @Step("{0} search the employee with id #id")
    public <T extends Actor> void performAs(T theActor) {

        Integer idEmployeeCreated = SerenityRest.lastResponse().jsonPath().get("data.id");

        theActor.attemptsTo(
                Get.resource(CONSULT_EMPLOYEE.getPath() + "/{id}")
                    .with(request -> request.pathParam("id", idEmployeeCreated))
        );
    }

    public static ConsultEmployeeCreated byId() {
        return instrumented(ConsultEmployeeCreated.class);
    }

}
