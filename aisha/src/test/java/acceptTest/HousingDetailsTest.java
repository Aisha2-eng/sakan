package acceptTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

public class HousingDetailsTest {
    private HousingDetails housingDetails;
    private HousingDetails.HousingUnit selectedHousingUnit;
    private String monthlyRent;
    private String services;
   
    private String location;

    public HousingDetailsTest() {
        housingDetails = new HousingDetails();
    }

    @Given("there are multiple housing units listed in Palestine")
    public void thereAreMultipleHousingUnitsListedInPalestine() {
        // Housing units are already added in the HousingDetails constructor
    }

    @When("I select a specific housing unit with the location {string} from the list")
    public void iSelectASpecificHousingUnitWithTheLocationFromTheList(String location) {
        this.location = location;
        selectedHousingUnit = housingDetails.findHousingUnitByLocation(location);
    }
    
  

    @Then("I  view the details about the housing unit:")
    public void iViewTheDetailsAboutTheHousingUnit(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        //throw new io.cucumber.java.PendingException();
    }




    

    @Then("I should be able to view the following details about the housing unit:")
    public void iShouldBeAbleToViewTheFollowingDetailsAboutTheHousingUnit(io.cucumber.datatable.DataTable dataTable) {
        //assertNotNull("Selected housing unit should not be null", selectedHousingUnit);

        List<Map<String, String>> details = dataTable.asMaps(String.class, String.class);
        String detailType ;
        String expectedValue = null ;

        for (Map<String, String> detail : details) {
        	 detailType = detail.get("Detail");
            expectedValue = detail.get("Value");
 
            switch (detailType) {
                case "MonthlyRent":
                    monthlyRent = selectedHousingUnit.monthlyRent;
                    break;
                case "Location":
                    assertEquals("Location should match", expectedValue, location + " in Palestine");
                    break;
                case "Services":
                    services = selectedHousingUnit.services;
                    break;
                default:
                    fail("Unknown detail type: " + detailType);
                    break;
            }
        }
        assertEquals("Monthly rent should match", expectedValue, monthlyRent);
        assertEquals("Services should match", expectedValue, services);
    }


   
}
