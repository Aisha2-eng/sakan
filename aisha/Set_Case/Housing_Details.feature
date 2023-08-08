Feature: Housing Details

  

  Scenario Outline: User views the details of a specific housing unit
    Given there are multiple housing units listed in Palestine
    When I select a specific housing unit with the location "Location" from the list
    
    Then I  view the details about the housing unit:
   
      | Location                     | Services                              | MonthlyRent |
      | "Rafidia Street, Nablus"     | "Furnished, Wi-Fi, Laundry"           | "$150 "       |
      | "Al-Manara, Ramallah"        | "Unfurnished, Parking"                |" $120 "       |
      | "Old City, Jerusalem "       | "Garden, 24/7 Security"               | "$200 "       |
     