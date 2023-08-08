package sakanat.test;

import java.util.ArrayList;
import java.util.List;

public class HousingUnits {
    private String name;
    private String location;
    private String services;
    private String monthlyRent;
    private String contactInfo;
    private List<Tenant> tenants;
    private List<NoTenant> notenants;

    private List<Furniture> advertisedFurniture;

    public HousingUnits(String name, String location, String services, String monthlyRent, String contactInfo) {
        this.name = name;
        this.location = location;
        this.services = services;
        this.monthlyRent = monthlyRent;
        this.contactInfo = contactInfo;
        this.tenants = new ArrayList<>();
        this.notenants = new ArrayList<>();
        this.advertisedFurniture = new ArrayList<>();
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

    public List<Tenant> getTenants() {
        return tenants;
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

    public void setTenants(List<Tenant> tenants) {
        this.tenants = tenants;
    }
    
    public void addTenant(Tenant tenant) {
        tenants.add(tenant);
    }
    
    public void NOTenant(NoTenant tenant) {
        notenants.add(tenant);
    }

    public void advertiseFurniture(String name, String description) {
        Furniture furniture = new Furniture(name, description);
        advertisedFurniture.add(furniture);
    }

    public List<Furniture> getAdvertisedFurniture() {
        return advertisedFurniture;
    }

}

