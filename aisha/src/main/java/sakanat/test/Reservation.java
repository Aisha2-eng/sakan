package sakanat.test;

public class Reservation {
    private int reservationId;
    private String tenantName;
    private String tenantEmail;
    private String housingUnit;
    private String checkInDate;
    private int duration;

    public Reservation(int reservationId, String tenantName, String tenantEmail, String housingUnit, String checkInDate, int duration) {
        this.reservationId = reservationId;
        this.tenantName = tenantName;
        this.tenantEmail = tenantEmail;
        this.housingUnit = housingUnit;
        this.checkInDate = checkInDate;
        this.duration = duration;
    }



	public int getReservationId() {
        return reservationId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getTenantEmail() {
        return tenantEmail;
    }
    
    public String getHousingUnit() {
        return housingUnit;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public int getDuration() {
        return duration;
    }
}
