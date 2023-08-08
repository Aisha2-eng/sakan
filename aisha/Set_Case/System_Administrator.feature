Feature: System Administrator
  As a system administrator
  I want to manage housing advertisements, reservations, and housing units
  So that I can ensure smooth operation of the system

  Scenario: Administrator reviews and accepts a housing advertisement
    Given I am logged in as a system administrator
    When I navigate to the administrator dashboard
    And I see a housing advertisement and the details of the advertisement
    And I click on the "Accept" button
    Then the advertisement should be approved and displayed in the housing listings
    And the housing owner should receive a notification of the approval

  Scenario: Administrator reviews and rejects a housing advertisement
    Given I am logged in as a system administrator
    When I navigate to the administrator dashboard
    And I see a housing advertisement and the details of the advertisement
    And I click on the "Reject" button
    Then the advertisement should be rejected and removed from the system
    And the housing owner should receive a notification of the rejection



