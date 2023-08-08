Feature: Housing Owner
  As a housing owner
  I want to manage my housing units and communicate with tenants
  So that I can provide a smooth renting experience

  Scenario Outline: Housing owner adds a new housing unit
    Given I am logged in as a housing owner
    When I navigate to the housing owner dashboard
    And I provide the necessary details, such as location "Location", services "Services", and monthly rent "MonthlyRent"
    Then I should see a success message indicating that the housing unit has been added
    And the new housing unit should appear in the housing unit list
    Examples:
      | Location               | Services                    | MonthlyRent |
      | rafidia street, Nablus  | Furnished, Wi-Fi, Laundry  | 150         |
      | Al-Manara, Ramallah     | Unfurnished, Parking       | 120         |
