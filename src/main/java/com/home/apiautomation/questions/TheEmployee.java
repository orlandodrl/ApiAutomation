package com.home.apiautomation.questions;

import com.home.apiautomation.model.Employee;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheEmployee implements Question<Employee> {

    @Override
    public Employee answeredBy(Actor actor) {
        JsonPath jsonPath = SerenityRest.lastResponse().jsonPath();
        return Employee.builder().name(jsonPath.getString("data.employee_name"))
                .age(jsonPath.getString("data.employee_age"))
                .salary(jsonPath.getString("data.employee_salary"))
                .build();
    }

    public static TheEmployee consulted() {
        return new TheEmployee();
    }

}
