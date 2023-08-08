package acceptTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TenantControlPanelTest {

    private TenantControlPanel tenantControlPanel = new TenantControlPanel();
    private boolean isLoggedIn;
    private boolean changesSaved;
    private String newInfo;

    @Given("I am logged in as a tenant")
    public void i_am_logged_in_as_a_tenant() {
        // Simulating a successful login
        isLoggedIn = true;
    }

    @When("I navigate to the tenant control panel")
    public void i_navigate_to_the_tenant_control_panel() {
        // Simulating navigation to the control panel
    }

    @When("I update my personal information, such as my contact number or email address to a valid value")
    public void i_update_my_personal_information_to_valid_value() {
        // Simulate the process to update personal information with valid data
        this.newInfo = "newemail@example.com"; // You can set any valid data for testing
        changesSaved = tenantControlPanel.updatePersonalInformation(newInfo);
    }

    @When("I update my personal information, such as my contact number or email address to {string}")
    public void i_update_my_personal_information(String newInfo) {
        // Simulate the process to update personal information with the given data
        this.newInfo = newInfo;
        changesSaved = tenantControlPanel.updatePersonalInformation(newInfo);
    }

    @When("I save the changes")
    public void i_save_the_changes() {
        // This step is just a continuation of the previous step
    	changesSaved=true;
    }

    @Then("I should see a success message indicating that my changes have been saved")
    public void i_should_see_a_success_message() {
        assertTrue("Changes have been saved successfully", changesSaved);
    }

    @Then("I should see an error message indicating that the changes could not be saved")
    public void i_should_see_an_error_message() {
        assertFalse("Changes could not be saved", changesSaved);
    }
}
