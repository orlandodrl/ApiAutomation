#encoding:utf-8
#Author: orlandodavid9512@gmail.com

Feature: Consult employees
  As a user I want to consult employees to know their information

  Scenario: Consult all the employees
    When he consults all employees
    Then the response code should be 200
    And the message in the response should be "Successfully! All records has been fetched."
    And the structure of the response is correct with "data/employees/ConsultAllEmployeesSchema.json"

  Scenario Outline: Consult an employee by id
    When he consults an employee by the id <id>
    Then the response code should be 200
    And the message in the response should be "Successfully! Record has been fetched."
    And and see that the data queried is correct
      | employee_name    | <employee_name>   |
      | employee_salary  | <employee_salary> |
      | employee_age     | <employee_age>    |
    And the structure of the response is correct with "data/employees/ConsultAnEmployeeSchema.json"

    Examples:
    | id | employee_name | employee_salary | employee_age |
    | 1  | Tiger Nixon   | 320800          | 61           |

