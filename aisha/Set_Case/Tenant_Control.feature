Feature: Tenant Control Panel
  As a tenant
  I want to access and manage my account information and bookings
  So that I can have control over my rented accommodation

  Scenario: User updates their personal information in the tenant control panel with valid data
    Given I am logged in as a tenant
    When I navigate to the tenant control panel
    And I update my personal information, such as my contact number or email address to a valid value
    And I save the changes
    Then I should see a success message indicating that my changes have been saved

    Examples:
      | NewInfo             |
      | "newemail@example.com" |
      | "123-456-7890"         |
      | "invalid-email-format" |  # Add this example for unsuccessful update
