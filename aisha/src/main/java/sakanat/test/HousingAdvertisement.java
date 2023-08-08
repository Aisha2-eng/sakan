package sakanat.test;

public class HousingAdvertisement {
    private int id;
    private String housingUnit;
    private String location;
    private String services;
    private String monthlyRent;
    private String contactInfo;

    public HousingAdvertisement(int id, String housingUnit, String location, String services, String monthlyRent, String contactInfo) {
        this.id = id;
        this.housingUnit = housingUnit;
        this.location = location;
        this.services = services;
        this.monthlyRent = monthlyRent;
        this.contactInfo = contactInfo;
    }

    public int getId() {
        return id;
    }

    public String getHousingUnit() {
        return housingUnit;
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

}

