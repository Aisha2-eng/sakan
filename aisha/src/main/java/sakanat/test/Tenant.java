package sakanat.test;

public class Tenant {
    private String name;
    private String contactInfo;

    public Tenant(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }


    
    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }
    
}

