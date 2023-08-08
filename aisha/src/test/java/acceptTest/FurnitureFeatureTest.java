package acceptTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;

public class FurnitureFeatureTest {
    private Login userInfo;
    private FurnitureAdvertised furnitureAdvertised;
    private String description;
    private String condition;
    private String price;
    private boolean successMessageDisplayed;
    private boolean furnitureListDisplayed;
    
    

    @Given("I am logged in to the application")
    public void i_am_logged_in_to_the_application() {
        userInfo = new Login();
        furnitureAdvertised = new FurnitureAdvertised();
        // Login to the application using userInfo
        // loginModule.UserInfo(userInfo.getUseremail(), userInfo.getPassword());
    }

    @When("I navigate to the furniture advertising section")
    public void i_navigate_to_the_furniture_advertising_section() {
        // Navigate to the furniture advertising section
        furnitureAdvertised = new FurnitureAdvertised();
    }

    @When("I provide the following details about the furniture:")
    public void i_provide_the_following_details_about_the_furniture(List<Map<String, String>> dataTable) {
        Map<String, String> furnitureDetails = dataTable.get(0);
        description = furnitureDetails.get("Description");
        condition = furnitureDetails.get("Condition");
        price = furnitureDetails.get("Price");

        furnitureAdvertised.fillFurnitureDetails(description, condition, price);
    }

    @Then("I should see a success message")
    public void i_should_see_a_success_message() {
        // Verify that the success message is displayed
        successMessageDisplayed = furnitureAdvertised.isSuccessMessageDisplayed();
        assertTrue(successMessageDisplayed);
    }
    
    @Then("I should see a list of my advertised furniture")
    public void iShouldSeeAListOfMyAdvertisedFurniture() {
        // Verify that the list of advertised furniture is displayed
        furnitureListDisplayed = furnitureAdvertised.isFurnitureListDisplayed();
        furnitureAdvertised.verifyAdvertisedFurnitureList() ;
      //  assertTrue(furnitureListDisplayed);
    }
    
    @When("I select the furniture item I want to edit")
    public void iSelectTheFurnitureItemIWantToEdit() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        furnitureAdvertised.selectFurnitureItemToEdit(description);

    }
    @When("I update the price to {string}")
    public void iUpdateThePriceTo(String newPrice) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
        furnitureAdvertised.updateFurniturePrice(description, newPrice);

    }
   
    
    @When("I select the furniture item I want to remove")
    public void iSelectTheFurnitureItemIWantToRemove() {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();
        furnitureAdvertised.selectFurnitureItemToRemove(description);

    }
    @When("I click  the {string} button")
    public void iClickTheButton(String string) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }
    
    
    @Then("the removed furniture should no longer appear in the list of my advertised furniture")
    public void the_removed_furniture_should_no_longer_appear_in_the_list_of_my_advertised_furniture() {
        // Verify that the removed furniture is no longer displayed in the list
        assertFalse(furnitureAdvertised.isFurnitureItemDisplayed(description));
    }



}
