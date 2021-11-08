package com.home.apiautomation.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Employee {

    private String name;
    private String salary;
    private String age;

}
