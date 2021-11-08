package com.home.apiautomation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;
import static com.home.apiautomation.utils.PathEmployee.CONSULT_ALL_EMPLOYEES;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultAllEmployees implements Task {

    @Override
    @Step("{0} search all the employees")
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Get.resource(CONSULT_ALL_EMPLOYEES.getPath())
        );
    }

    public static ConsultAllEmployees registered() {
        return instrumented(ConsultAllEmployees.class);
    }

}
