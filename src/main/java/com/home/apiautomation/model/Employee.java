package com.home.apiautomation.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Employee {

    private String name;
    private Integer salary;
    private Integer age;

}
