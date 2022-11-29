#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Title of your scenario
    Given I want to write a step with precondition
    And some other precondition
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes

@Exercise
Scenario: Sauce Demo Validation
Given I launch SauceDemo website "https://www.saucedemo.com/"
And verify the title as Swag Labs
And verify the login button is capitalized
And login with "standard_user" and "secret_sauce"
When logined, validate the default filter is A-Z
And verify the first product added
And verify the cart badge has 1 product
And verify the last product added
And verify the cart badge value is increased
And remove the first product and validate the cart
Then click on the cart
And verify the added product is available
And click on the Continue Shopping
And change the price filter from low to high
And verify the price sorted properly

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
