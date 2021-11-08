#Author: orlandodavid9512@gmail.com

Feature: Create employees
  As a user I want to create employees to save their information

  Scenario Outline: Create an employee
    When he create an employee with the information
      |      name       |       salary      |       age      |
      | <employee_name> | <employee_salary> | <employee_age> |
    Then the response code should be 200
    And the message in the response should be "Successfully! Record has been added."
    When he consults an employee by the id saved
    Then the response code should be 200
#    And and see that the data queried is correct
#      |      name       |       salary      |       age      |
#      | <employee_name> | <employee_salary> | <employee_age> |

    Examples:
    | employee_name  | employee_salary | employee_age |
    | Orlando        | 2000            | 27           |

#PENDING: FAILED SCENARIOS