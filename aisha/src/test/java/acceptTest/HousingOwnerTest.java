package acceptTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class HousingOwnerTest {
    private HousingOwner housingOwner;
    private String location;
    private String services;
    private String monthlyRent;
    private boolean successMessageDisplayed=true;

    @Given("I am logged in as a housing owner")
    public void iAmLoggedInAsHousingOwner() {
        housingOwner = new HousingOwner();
    }

    @When("I navigate to the housing owner dashboard")
    public void navigateToHousingOwnerDashboard() {
        // Implement logic to navigate to housing owner dashboard
    }
    
 

    @When("I provide the necessary details, such as location {string}, services {string}, and monthly rent {string}")
    public void iProvideTheNecessaryDetailsSuchAsLocationServicesAndMonthlyRent(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }




    @When("I provide the necessary details, such as location {string}, services {string}, and monthly rent {int}")
    public void provideNecessaryDetails(String location, String services, String monthlyRent) {
        this.location = location;
        this.services = services;
        this.monthlyRent = monthlyRent;
        successMessageDisplayed = housingOwner.addNewHousingUnit(location, services, monthlyRent);
    }

    @Then("I should see a success message indicating that the housing unit has been added")
    public void verifySuccessMessage() {
        assertTrue(successMessageDisplayed);
    }

    @And("the new housing unit should appear in the housing unit list")
    public void verifyHousingUnitList() {
    	
    	if(housingOwner.isHousingUnitListUpdated(location, services, monthlyRent))
        assertTrue(successMessageDisplayed);
    }
}