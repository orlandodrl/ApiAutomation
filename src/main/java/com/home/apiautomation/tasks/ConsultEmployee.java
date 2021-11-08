package com.home.apiautomation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;
import static com.home.apiautomation.utils.PathEmployee.CONSULT_EMPLOYEE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultEmployee implements Task {

    private int id;

    ConsultEmployee(int id) {
        this.id = id;
    }

    @Override
    @Step("{0} search the employee with id #id")
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Get.resource(CONSULT_EMPLOYEE.getPath() + "/{id}")
                    .with(request -> request.pathParam("id", id))
        );
    }

    public static ConsultEmployee byId(int id) {
        return instrumented(ConsultEmployee.class, id);
    }

}
