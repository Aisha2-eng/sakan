package acceptTest;

import java.util.ArrayList;
import java.util.List;

import sakanat.test.HousingUnits;
import sakanat.test.NoTenant;
import sakanat.test.Tenant;

public class HousingDetails {

    public List<HousingUnit> housingUnits;

    public HousingDetails() {
        housingUnits = new ArrayList<>();
        // Assuming some initial data for housingUnits
        housingUnits.add(new HousingUnit("Apartment 1", "Rafidia Street, Nablus" ,  "$150 " , "Furnished, Wi-Fi, Laundry" ));
        
        
        housingUnits.add(new HousingUnit("Villa 5", "Al-Manara, Ramallah"  ,  " $120 " , "Unfurnished, Parking"   ));
        
        
        housingUnits.add(new HousingUnit("House 2", "Old City, Jerusalem " ,  "$200 ", "Garden, 24/7 Security" ));
        
        
        housingUnits.add(new HousingUnit("Villa 2", "Nasaria", "120", "Unfurnished, Parking, pool"));
	   

        housingUnits.add(new HousingUnit("Studio X", "Downtown Avenue, Hebron", "170", "Furnished, Balcony, city view"));
	    
	    
        housingUnits.add(new HousingUnit("Luxury Apartment", "Downtown", "1500", "Furnished, Wi-Fi, Gym"));

	    
        housingUnits.add(new HousingUnit("Cozy Studio", "Suburb", "80", "Unfurnished, Parking"));

	    
        housingUnits.add(new HousingUnit("Villa 3", "Palestine Street, Ramallah", "120", "Unfurnished, Parking, pool"));	    
	    
        
        housingUnits.add(new HousingUnit("Condo A", "Beach Road, Gaza", "200", "Furnished, Gym, sea view"));

        
        
  
    }

    public HousingUnit findHousingUnitByLocation(String location) {
        for (HousingUnit unit : housingUnits) {
            if (unit.location.equalsIgnoreCase(location)) {
                return unit;
            }
        }
        return null;  
    }

    public static class HousingUnit {
        public String name;
        public String location;
      
        public String monthlyRent;
        public String services;

        public HousingUnit(String name, String location, String monthlyRent, String services) {
            this.name = name;
            this.location = location;
            
            this.monthlyRent = monthlyRent;
            this.services = services;
        }
    }
}
