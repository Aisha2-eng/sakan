package sakanat.test;

import java.util.ArrayList;
import java.util.List;

public class HouseUnit {
	
    private String name;
    private String location;
    private String services;
    private String monthlyRent;
    private String contactInfo;
    private List<NoTenant> notenants;
	
    public HouseUnit(String name, String location, String services, String monthlyRent, String contactInfo) {
        this.name = name;
        this.location = location;
        this.services = services;
        this.monthlyRent = monthlyRent;
        this.contactInfo = contactInfo;
        this.notenants = new ArrayList<>();
    }

    
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getServices() {
        return services;
    }

    public String getMonthlyRent() {
        return monthlyRent;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public List<NoTenant> getTenants() {
        return notenants;
    }

    // Setter methods for attributes

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public void setMonthlyRent(String monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setTenants(List<NoTenant> tenants) {
        this.notenants = notenants;
    }
    
    public void addTenant(NoTenant tenant) {
        notenants.add(tenant);
    }
    
    
    
}
