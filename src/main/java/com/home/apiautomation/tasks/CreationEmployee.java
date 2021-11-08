package com.home.apiautomation.tasks;

import com.home.apiautomation.model.Employee;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreationEmployee implements Task {

    EnvironmentVariables environmentVariables;
    private Employee employee;

    CreationEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    @Step("{0} create the employee")
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Post.to(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("restapi.createEmployeePath"))
                        .with(request -> request.header("Content-Type", "application/json")
                                .body(employee)
                        )
        );
    }

    public static CreationEmployee withTheInformation(Employee employee){
        return instrumented(CreationEmployee.class, employee);
    }

}
