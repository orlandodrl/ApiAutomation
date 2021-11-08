#Author: orlandodavid9512@gmail.com

Feature: Delete employees
  As a user I want to delete employees to clean their information

  Background:
    When he create an employee with the information
      |      name       |       salary      |       age      |
      |     Luciana     |       20000       |       56       |
    Then the response code should be 200

  Scenario: Delete an employee
    When he delete an employee with the id saved
    Then the response code should be 200
    And the message in the response should be "Successfully! Record has been deleted"
#    When he consults an employee by the id saved
#    Then the response code should be 404

#PENDING: FAILED SCENARIOS

    