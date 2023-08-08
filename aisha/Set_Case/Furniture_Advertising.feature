Feature: Furniture Advertising

  Scenario: User advertises their used furniture for sale
    Given I am logged in to the application
    When I navigate to the furniture advertising section
    And I provide the following details about the furniture:
      | Description                      | Condition | Price  |
      | Used Sofa in Good Condition      | Good      | $200   |
    Then I should see a success message

  Scenario: User views their advertised furniture
    Given I am logged in to the application
    When I navigate to the furniture advertising section
    Then I should see a list of my advertised furniture

    
   Scenario: User edits the details of their advertised furniture
    Given I am logged in to the application
    When I navigate to the furniture advertising section
    And I select the furniture item I want to edit
    And I update the price to "$250"
    Then I should see a success message  
    
    
    
  Scenario: User removes their advertised furniture
    Given I am logged in to the application
    When I navigate to the furniture advertising section
    And I select the furniture item I want to remove
    Then I should see a success message
     And the removed furniture should no longer appear in the list of my advertised furniture
    
    