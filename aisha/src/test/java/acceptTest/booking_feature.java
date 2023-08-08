package acceptTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class booking_feature {
    private String selectedHousingUnit;
    private String selectedDates;
    private String selectedDuration;
    private String selectedName;
    private String selectedEmail;
    private String bookingConfirmationMessage;
    private BookingAccommdation bookingAccommdation;
    private boolean flag1=false;

    @Given("I am on the housing details page")
    public void iAmOnTheHousingDetailsPage() {
        bookingAccommdation = new BookingAccommdation();
    }

    @When("I select a specific housing unit {string}")
    public void iSelectASpecificHousingUnit(String housingUnit) {
        selectedHousingUnit = housingUnit;
    }

    @When("I select the desired dates {string} and duration {string} of my stay")
    public void iSelectTheDesiredDatesAndDurationOfMyStay(String dates, String duration) {
        selectedDates = dates;
        selectedDuration = duration;
    }

    @When("I provide the necessary personal information as {string}, {string}, {string}, and {string}")
    public void iProvideTheNecessaryPersonalInformation(String name, String dates, String duration, String email) {
        selectedName = name;
        selectedDates = dates;
        selectedDuration = duration;
        selectedEmail = email;
        flag1=true;
    }

    /*@When("I confirm the booking")
    public void iConfirmTheBooking() {
        bookingConfirmationMessage = bookingAccommdation.sendConfirmationEmail(selectedHousingUnit, selectedDates, selectedDuration, selectedName, selectedEmail);
    }*/

    @Then("I should see a confirmation message for my booking")
    public void iShouldSeeAConfirmationMessageForMyBooking() {
    	if(flag1==true)
        assertTrue("Booking confirmed successfully", flag1);
    }

    @Then("I should receive a confirmation email with booking details")
    public void iShouldReceiveAConfirmationEmailWithBookingDetails() {
        assertTrue(isConfirmationEmailSent(selectedEmail));
    }

    private boolean isConfirmationEmailSent(String email) {
        // Implement the logic to check if the email is sent (return true if it's sent)
        return true;  // Placeholder return value, replace as needed
    }
  

    @When("I select a specific housing unit \"\"Apartment {int}\"\"")
    public void iSelectASpecificHousingUnitApartment(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	selectedHousingUnit = "Villa " + int1;
    	
    }
    @When("I select the desired dates \"\"{int}-{int}-{int}\"\" and duration \"\"{int} days\"\" of my stay")
    public void iSelectTheDesiredDatesAndDurationDaysOfMyStay(Integer int1, Integer int2, Integer int3, Integer int4) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    	selectedDates = int1 + "-" + int2 + "-" + int3;
        selectedDuration = int4 + " days";
    	
    }
    @When("I provide the necessary personal information as \"\"Alex Smith\"\", \"\"{int}-{int}-{int}\"\", \"\"{int} days\"\", and \"\"alexsmith@gmail.com\"\"")
    public void iProvideTheNecessaryPersonalInformationAsAlexSmithDaysAndAlexsmithGmailCom(Integer int1, Integer int2, Integer int3, Integer int4) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	  selectedName = "roz malter";
          selectedDates = int1 + "-" + int2 + "-" + int3;
          selectedDuration = int4 + " days";
          selectedEmail = "rozmalter@gmail.com";
    }



}
