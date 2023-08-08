package acceptTest;

//import com.google.common.base.MoreObjects;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HousingOwner {

    private List<HousingUnit> housingUnits;
    private boolean isLoggedIn;

    public HousingOwner() {
        housingUnits = new ArrayList<>();

    }

    public void login() {
        // Implement login logic
        isLoggedIn = true; // Placeholder logic
    }

    public void navigateToDashboard() {
        // Implement navigation logic to the housing owner dashboard
    }

    public boolean addNewHousingUnit(String location, String services, String monthlyRent) {
        HousingUnit newUnit = new HousingUnit(location, services, monthlyRent);
        housingUnits.add(newUnit);
        return false;
    }

    /*public boolean verifySuccessMessage() {
        String expectedSuccessMessage = "Housing unit added successfully!";
        String actualSuccessMessage = getDisplayedSuccessMessage(); // Replace with your method
        return expectedSuccessMessage.equals(actualSuccessMessage);
    }

    public String getDisplayedSuccessMessage() {
        WebElement driver = null;
        WebElement successMessageElement = driver.findElement(By.id("successMessage")); // Replace with actual locator
        return successMessageElement.getText();
    }*/


   

    public boolean findHousingUnitByLocation(String location) {
        // Assuming you have a list of housing units
        List<HousingUnit> housingUnits = getHousingUnits(); // Replace with your actual method to get housing units

        for (HousingUnit unit : housingUnits) {
            if (unit.getLocation().equalsIgnoreCase(location)) {
                return true; // Housing unit found
            }
        }

        return false; // Housing unit not found
    }

    public List<HousingUnit> getHousingUnits() {
        List<HousingUnit> housingUnits = new ArrayList<>();

        // Assuming you have some housing units stored in a database or data source
        // You would retrieve them and populate the list here
        // For example:
        housingUnits.add(new HousingUnit("rafidia street, Nablus", "Furnished, Wi-Fi, Laundry", "150"));
        housingUnits.add(new HousingUnit("Al-Manara, Ramallah", "Unfurnished, Parking", "120"));

        return housingUnits;
    }

    public boolean isHousingUnitListUpdated(String location, String services, String monthlyRent) {
        HousingOwner housingOwner = new HousingOwner();

        HousingUnit[] housingUnitList = new HousingUnit[0];
        for (HousingUnit unit : housingUnitList) {
            if (unit.getLocation().equals(location) &&
                    unit.getServices().equals(services) &&
                    unit.getMonthlyRent().equals(monthlyRent)) {
                return true; // same details
            }
        }
        return false; //  not found in the list
    }




    private class HousingUnit {
        private String location;
        private String services;
        private String monthlyRent;

        public HousingUnit(String location, String services, String monthlyRent) {
            this.location = location;
            this.services = services;
            this.monthlyRent = monthlyRent;
        }

        public String getLocation() {
            return location;
        }

        public Object getServices() {
            return services;
        }

        public String getMonthlyRent() {
            return monthlyRent;
        }
    }
}