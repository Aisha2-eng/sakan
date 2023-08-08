package sakanat.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import acceptTest.Login;

public class MainApp {
	
    private static List<HousingAdvertisement> acceptedAdvertisements = new ArrayList<>();
    private static List<HousingAdvertisement> rejectedAdvertisements = new ArrayList<>();

	
    private static Login userInfo;
	private static Scanner scanner;
	private static int ff=0;

    public static void main(String[] args) {
    	System.out.println("-------------------------------------------Welcome to Sakan System-------------------------------------------" );
    	int x=1;
        Scanner scanner = new Scanner(System.in);
        userInfo = new Login();
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Read user's name, email, and password
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Check if the user exists and get user info*
        if (userInfo.isUserExists(email, password)) {
            Login.UserInfo user = userInfo.getUserInfoByEmail(email);
           // System.out.println("Welcome to " + user.getName() + ": " + user.getEmail());
            // Call corresponding methods based on the user's role (Admin/Owner/Tenant)
            if (user.getName().equals("Aisha")) {
                admin();
            } else if (user.getName().equals("Arees")) {
                owner();
            } else {
                tenant();
            }
        } 
        else {
            System.out.println("Wrong email or password. Please try again another time.");
           x=0;
        }
    }

   public static void admin() {
    System.out.println("-----------------------------Welcome to Admin Page-----------------------------");
    int flag1 = 1;
    Scanner input = new Scanner(System.in);

    while (flag1 == 1) {
        System.out.println(" *****Menu***** \n");
        System.out.println(" 1. Housing Advertisement \n");
        System.out.println(" 2. View Reservations \n");
        System.out.println(" 3. Add Housing Unit \n");
        System.out.println(" 4. LOGOUT \n");

        int number1 = Integer.parseInt(input.nextLine());

        switch (number1) {
            case 1:
                adminReviewAdvertisements();
                break;
            case 2:
                adminViewReservations();
                break;
            case 3:
                adminAddHousingUnit();
                break;
            case 4:
			
				System.out.println(" Logged out successfully \n" );flag1=0;
			
			

	        Scanner scanner = new Scanner(System.in);
	        userInfo = new Login();
	        System.out.print("Enter your name: ");
	        String name = scanner.nextLine();

	        // Read user's name, email, and password
	        System.out.print("Enter your email: ");
	        String email = scanner.nextLine();

	        System.out.print("Enter your password: ");
	        String password = scanner.nextLine();

	        // Check if the user exists and get user info
	        if (userInfo.isUserExists(email, password)) {
	            Login.UserInfo user = userInfo.getUserInfoByEmail(email);
	           // System.out.println("Welcome to " + user.getName() + ": " + user.getEmail());
	            // Call corresponding methods based on the user's role (Admin/Owner/Tenant)
	            if (user.getName().equals("arees")) {
	                owner();
	            
	            } else if (user.getName().equals("Tala")) {
	                tenant();
	            }
	        } else {
	            System.out.println("Invalid email or password. Please try again another time.");
	       
	        }
			
			
				 break;
            default:
                System.out.println(" Unvalid choice!! \n");
                break;
        }
    }
}

private static void adminAddHousingUnit() {
    System.out.println("Admin - Add Housing Unit Advertisement");

    scanner = new Scanner(System.in);

    System.out.print("Enter housing unit name: ");
    String housingUnit = scanner.nextLine();

    System.out.print("Enter location: ");
    String location = scanner.nextLine();

    System.out.print("Enter services (comma-separated): ");
    String services = scanner.nextLine();

    System.out.print("Enter monthly rent: ");
    String monthlyRent = scanner.nextLine();

    System.out.print("Enter contact information: ");
    String contactInfo = scanner.nextLine();

    List<HousingAdvertisement> advertisements = getAdvertisementsFromFile();
    int newId = advertisements.isEmpty() ? 1 : advertisements.get(advertisements.size() - 1).getId() + 1;

    HousingAdvertisement newAdvertisement = new HousingAdvertisement(newId, housingUnit, location, services, monthlyRent, contactInfo);
    advertisements.add(newAdvertisement);
    writeAdvertisementsToFile(advertisements);

    System.out.println("Housing unit advertisement added successfully!");
}

private static void writeAdvertisementsToFile(List<HousingAdvertisement> advertisements) {
    try (PrintWriter writer = new PrintWriter(new FileWriter("advertisement.txt"))) {
        for (HousingAdvertisement ad : advertisements) {
            writer.println(ad.getId() + "," + ad.getHousingUnit() + "," + ad.getLocation() + "," + ad.getServices() + "," + ad.getMonthlyRent() + "," + ad.getContactInfo());
        }
        System.out.println("Advertisements written to file.");
    } catch (IOException e) {
        System.out.println("Error writing advertisements to file: " + e.getMessage());
    }
}

private static void acceptAdvertisement(HousingAdvertisement ad) {
    //List<HousingAdvertisement> acceptedAdvertisements;
	acceptedAdvertisements.add(ad);
    writeAcceptedAdvertisementsToFile(ad);
}

private static void writeAcceptedAdvertisementsToFile(HousingAdvertisement ad) {
    try (FileWriter writer = new FileWriter("accepted_advertisements.txt", true)) {
        writer.write(ad.getId() + "\t" + ad.getHousingUnit() + "\t" + ad.getLocation() + "\t" + ad.getServices() + "\t" + ad.getMonthlyRent() + "\t" + ad.getContactInfo() + "\n");
    } catch (IOException e) {
        e.printStackTrace();
    }
}









private static void adminReviewAdvertisements() {
    System.out.println("Admin - Review Housing Advertisements");
    Scanner input = new Scanner(System.in);

    List<HousingAdvertisement> advertisements = new ArrayList<>();

    // Add sample housing advertisements (replace with your actual data)
    advertisements.add(new HousingAdvertisement(1, "Apartment 1", "itehad Street, Nablus", "Furnished, Wi-Fi, seventh floor", "150", "+970-597 373 534"));
    advertisements.add(new HousingAdvertisement(2, "Villa 2", "Nasaria", "Unfurnished, Parking, pool", "120", "+970-568 468 298"));

    if (advertisements.isEmpty()) {
        System.out.println("No housing advertisements found.");
    } else {
        System.out.println("List of Housing Advertisements:");
        for (HousingAdvertisement ad : advertisements) {
            System.out.println("Advertisement ID: " + ad.getId());
            System.out.println("Housing Unit: " + ad.getHousingUnit());
            System.out.println("Location: " + ad.getLocation());
            System.out.println("Services: " + ad.getServices());
            System.out.println("Monthly Rent: " + ad.getMonthlyRent());
            System.out.println("Contact Information: " + ad.getContactInfo());
            System.out.println("------------------------------");

            System.out.println(" 1. Accept \n");
            System.out.println(" 2. Reject\n");
            

            int number1 = Integer.parseInt(input.nextLine());

            switch (number1) {
                case 1:
                	System.out.println(" Accepted\n");
                    break;
                case 2:
                	System.out.println(" Rejected\n");
                    break;
                
                default:
                    System.out.println("Unvalid choice!! \n");
                    break;
            }
        }
    }
}

private static void adminViewReservations() {
    System.out.println("Admin - View Reservations");

    List<Reservation> reservations = new ArrayList<>();
    
    
    
    Reservation reservation1 = new Reservation(1, "Alex Smith", "alexsmith@gmail.com", "Apartment 3", "2023-08-15", 7);
    Reservation reservation2 = new Reservation(2, "Roz Malter", "rozmalter@gmail.com", "Villa 2", "2023-09-01", 10);
    Reservation reservation3 = new Reservation(3, "Rachel Green", "rachrach@gmail.com", "Luxury Apartment", "2023-08-09",30);


    reservations.add(reservation1);
    reservations.add(reservation2);


    
    
    
    if (reservations.isEmpty()) {
        System.out.println("No reservations found.");
    } else {
        System.out.println("List of Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println("Reservation ID: " + reservation.getReservationId());
            System.out.println("Tenaaisnt Name: " + reservation.getTenantName());
            System.out.println("Tenaaisnt Email: " + reservation.getTenantEmail());
            System.out.println("Housing Unit: " + reservation.getHousingUnit());
            System.out.println("Check-in Date: " + reservation.getCheckInDate());
            System.out.println("Duration: " + reservation.getDuration());
            System.out.println("------------------------------");
        }
    }
}
 

    
private static List<Reservation> getReservationsFromFile() {
    List<Reservation> reservations = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("advertisement.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 5) { // Assuming there are 5 fields: ID, Tenant Name, Housing Unit, Check-in Date, Duration
                int reservationId = Integer.parseInt(parts[0]);
                String tenantName = parts[1];
                String tenantEmail = parts[2];
                String housingUnit = parts[3];
                String checkInDate = parts[4];
                int duration = Integer.parseInt(parts[5]);

                Reservation reservation = new Reservation(reservationId, tenantName, tenantEmail,  housingUnit, checkInDate, duration);
                reservations.add(reservation);
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading reservations from file: " + e.getMessage());
    }
    return reservations;
}


	
	

	
	
	private static List<HousingAdvertisement> getAdvertisementsFromFile() {
	    // Placeholder for retrieving housing advertisements from the File
	    // You should replace this with your actual File retrieval logic
	    // Return a list of HousingAdvertisement objects
	    List<HousingAdvertisement> advertisements = new ArrayList<>();

	    // Add the list
	    advertisements.add(new HousingAdvertisement(1, "Apartment 1", "itehad Street, Nablus", "Furnished, Wi-Fi, seventh floor", "150", "+970-597 373 534"));
	    advertisements.add(new HousingAdvertisement(2, "Villa 2", "Nasaria", "Unfurnished, Parking, pool", "120", "+970-568 468 298"));

	    return advertisements;
	}

	
	private static List<HousingUnits> getHousingUnitsFromFile1() {
	    
	    List<HousingUnits> housingUnits = new ArrayList<>();

	    HousingUnits unit1 = new HousingUnits( "Apartment 1", "itehad Street, Nablus", "Furnished, Wi-Fi, seventh floor", "150", "+970-597 373 534");
	    unit1.addTenant(new Tenant("Alex Smith", "alexsmith@gmail.com"));
	    housingUnits.add(unit1);
	    
	    
	    
	    

	    HousingUnits unit2 = new HousingUnits("Villa 2", "Nasaria", "Unfurnished, Parking, pool", "120", "+970-568 468 298");
	    unit2.addTenant(new Tenant("Roz Malter", "rozmalter@gmail.com"));
	    housingUnits.add(unit2);

	    HousingUnits unit3 = new HousingUnits("Studio X", "Downtown Avenue, Hebron", "Furnished, Balcony, city view", "170", "+970-599 246 802");
	    unit3.NOTenant(new NoTenant("No Tenants"));
	    housingUnits.add(unit3);
	    
	    HousingUnits unit4 = new HousingUnits("Luxury Apartment", "Downtown", "Furnished, Wi-Fi, Gym", "1500", "+970594568523");
	    unit4.addTenant(new Tenant("Rachel Green", "rachrach@gmail.com"));
	    housingUnits.add(unit4);
	    
	    HousingUnits unit5 = new HousingUnits("Cozy Studio", "Suburb", "Unfurnished, Parking", "80", "+970596874231");
	    unit5.addTenant(new Tenant("joey Tribbiani", "howyoudoin@gmail.com"));
	    housingUnits.add(unit5);
	    
	    HousingUnits unit6 = new HousingUnits("Villa 3", "Palestine Street, Ramallah", "Unfurnished, Parking, pool", "120", "+970-568 468 298");
	    unit6.addTenant(new Tenant("Chandler M Bing", "chandlermonica@gmail.com"));
	    housingUnits.add(unit6);
	    
	    
	    
	    HousingUnits unit7 = new HousingUnits("Condo A", "Beach Road, Gaza", "Furnished, Gym, sea view", "200", "+970-555 123 456");
	    unit7.NOTenant(new NoTenant("No Tenants"));
	    housingUnits.add(unit7);
	    

	    return housingUnits;
	}

	

	public static void owner() {
        // Your owner code here
    	System.out.println("-----------------------------Welcome to Owner Page-----------------------------" );
    	int flag1=1;
   	    Scanner input = new Scanner(System.in);
   	    
   	 while(flag1==1) {
		 System.out.println(" *****Menu***** \n" );
		 System.out.println(" 1.Furniture Advertised\n" );
		 System.out.println(" 2.Housing Details \n" );
		 System.out.println(" 3.LOGOUT \n" );

		 
		int number=Integer.parseInt(input.nextLine());
			switch(number) {
			
			case 1:
			    List<HousingUnits> housingUnits = new ArrayList<>(); // Initialize the list

			    HousingUnits unit1 = new HousingUnits("Luxury Apartment", "Downtown", "Furnished, Wi-Fi, Gym", "1500", "+970594568523");
			    HousingUnits unit2 = new HousingUnits("Cozy Studio", "Suburb", "Unfurnished, Parking", "80", "+970596874231");
			    HousingUnits unit3 = new HousingUnits("Villa 3", "Palestine Street, Ramallah", "Unfurnished, Parking, pool", "120", "+970-568 468 298");


			    housingUnits.add(unit1);
			    housingUnits.add(unit2);
			    housingUnits.add(unit3);

			    ownerAdvertiseFurniture(housingUnits);
			    break;

			
			case 2:
				ownerManageHousingUnits();
                break;
			
			case 3:{
				System.out.println(" Logged out successfully \n" );flag1=0;
			
			

	        Scanner scanner = new Scanner(System.in);
	        userInfo = new Login();
	        System.out.print("Enter your name: ");
	        String name = scanner.nextLine();

	        // Read user's name, email, and password
	        System.out.print("Enter your email: ");
	        String email = scanner.nextLine();

	        System.out.print("Enter your password: ");
	        String password = scanner.nextLine();

	        // Check if the user exists and get user info
	        if (userInfo.isUserExists(email, password)) {
	            Login.UserInfo user = userInfo.getUserInfoByEmail(email);
	           // System.out.println("Welcome to " + user.getName() + ": " + user.getEmail());
	            // Call corresponding methods based on the user's role (Admin/Owner/Tenant)
	            if (user.getName().equals("Aisha")) {
	                admin();
	            
	            } else if (user.getName().equals("Tala")) {
	                tenant();
	            }
	        } else {
	            System.out.println("Invalid email or password. Please try again another time.");
	       
	        }
			
			
				 break;}//end case3 (logout) owner
			
			default:{System.out.println(" unvalid choice!! \n" );break;}
			
			}
	 }
   	    
    }
    

	private static List<HousingUnits> getHousingUnitsFromFile() {
	    // Placeholder for retrieving housing units from the File
	    // You should replace this with your actual File retrieval logic
	    // Return a list of HousingUnit objects
	    List<HousingUnits> housingUnits = new ArrayList<>();

	    // Add sample housing units (you should replace these with actual data)
	    HousingUnits unit1 = new HousingUnits("Apartment 3", "Rafidia Street, Nablus", "Furnished, Wi-Fi, Laundry", "$150", "Contact info");
	    unit1.addTenant(new Tenant("Alex Smith", "alexsmith@gmail.com"));
	    housingUnits.add(unit1);

	    HousingUnits unit2 = new HousingUnits("Villa 7", "Al-Manara, Ramallah", "Unfurnished, Parking", "$120", "Contact info");
	    unit2.addTenant(new Tenant("Roz Malter", "rozmalter@gmail.com"));
	    housingUnits.add(unit2);

	    return housingUnits;
	}


	private static void ownerAdvertiseFurniture(List<HousingUnits> housingUnits) {
	    System.out.println("Owner - Advertise Furniture");

	    Scanner scanner = new Scanner(System.in);
	    System.out.print("Enter housing unit name: ");
	    String housingUnitName = scanner.nextLine();

	    // Find the housing unit by name
	    HousingUnits housingUnit = findHousingUnitByName(housingUnitName, housingUnits);

	    if (housingUnit != null) {
	        System.out.print("Enter furniture name: ");
	        String furnitureName = scanner.nextLine();
	        
	        System.out.print("Enter furniture description: ");
	        String furnitureDescription = scanner.nextLine();

	        // Advertise furniture for the housing unit
	        housingUnit.advertiseFurniture(furnitureName, furnitureDescription);
	        System.out.println("Furniture advertised successfully!");
	    } else {
	        System.out.println("Housing unit not found.");
	    }
	}


	private static HousingUnits findHousingUnitByName(String housingUnitName, List<HousingUnits> housingUnits) {
	    for (HousingUnits unit : housingUnits) {
	        if (unit.getName().equalsIgnoreCase(housingUnitName)) {
	            return unit;
	        }
	    }
	    return null; // Return null if housing unit is not found
	}

    
	private static void ownerManageHousingUnits() {
	    System.out.println("Housing Owner - Manage Housing Units");

	    // Placeholder for owner's code to manage housing units
	    // Implement your logic here

	    // Sample list of housing units
	    List<HousingUnits> housingUnits = getHousingUnitsFromFile1();

	    if (housingUnits.isEmpty()) {
	        System.out.println("No housing units found.");
	    } else {
	        System.out.println("List of Housing Units:");
	        for (HousingUnits unit : housingUnits) {
	            System.out.println("Housing Unit: " + unit.getName());
	            System.out.println("Location: " + unit.getLocation());
	            System.out.println("Services: " + unit.getServices());
	            System.out.println("Monthly Rent: " + unit.getMonthlyRent());
	            System.out.println("Contact Information: " + unit.getContactInfo());

	            List<Tenant> tenants = unit.getTenants();
	            System.out.println("Tenants:");
	            if (tenants.isEmpty()) {
	                System.out.println("No tenants for this housing unit.");
	            } else {
	                for (Tenant tenant : tenants) {
	                    System.out.println("Tenant Name: " + tenant.getName());
	                    System.out.println("Contact Information: " + tenant.getContactInfo());
	                }
	            }

	            System.out.println("------------------------------");
	        }
	    }
	}


    public static void tenant() {
        // Your tenant code here
    	System.out.println("-----------------------------Welcome to Tenant Page-----------------------------" );
    	int flag1=1;
   	     Scanner input = new Scanner(System.in);
   	     
   	  while(flag1==1) {
 		 System.out.println(" *****Menu***** \n" );
 		 System.out.println(" 1.Booking Accommodation\n" );
 		 System.out.println(" 2.Housing Details \n" );
 		 System.out.println(" 3.Control Panel \n" );
		 System.out.println(" 4.LOGOUT \n" );

 		 
 		int number=Integer.parseInt(input.nextLine());
			switch(number) {
			
            case 1:		
            	tenantBookAccommodation();

                break;
			
			case 2:
				tenantViewAvailableHousing();

                break;
			
			case 3:
				
				tenantViewControlPanel();
                break;
			
			case 4:{System.out.println(" logout successfully \n" );
				flag1=0; 
				
				

		        Scanner scanner = new Scanner(System.in);
		        userInfo = new Login();
		        System.out.print("Enter your name: ");
		        String name = scanner.nextLine();

		        // Read user's name, email, and password
		        System.out.print("Enter your email: ");
		        String email = scanner.nextLine();

		        System.out.print("Enter your password: ");
		        String password = scanner.nextLine();

		        // Check if the user exists and get user info
		        if (userInfo.isUserExists(email, password)) {
		            Login.UserInfo user = userInfo.getUserInfoByEmail(email);
		           // System.out.println("Welcome to " + user.getName() + ": " + user.getEmail());
		            // Call corresponding methods based on the user's role (Admin/Owner/Tenant)
		            if (user.getName().equals("Aisha")) {
		                admin();
		            
		            } else if (user.getName().equals("Arees")) {
		            	owner();
		            }
		        } else {
		            System.out.println("Invalid email or password. Please try again.");
		        }
				
				
				
				
				break;}//end case4 (logout) tenant
			
			default:{System.out.println(" unvalid!! \n" );break;}
			
			}
 	 }
   	     
    }

	private static void tenantViewControlPanel() {
		
		    System.out.println("Tenant - Control Panel");

		    Scanner scanner = new Scanner(System.in);
		    System.out.println("1. View My Housing Unit Details");
		    System.out.println("2. Back to Main Menu");
		    System.out.print("Enter your choice: ");
		    int choice = scanner.nextInt();
		    scanner.nextLine(); // Consume the newline character
		    List<HousingUnits> housingUnits = getHousingUnitsFromFile(); 

		    switch (choice) {
		        case 1:
		            tenantViewHousingUnitDetails(housingUnits);
		            break;
		        
		        case 2:
		            System.out.println("Returning to Main Menu.\n");
		            break;
		        default:
		            System.out.println("Invalid choice.\n");
		            break;
		    }
		}
		
	

	private static void tenantViewHousingUnitDetails(List<HousingUnits> housingUnits) {
	    System.out.println("Tenant - View Housing Unit Details");

	        System.out.println("Housing Unit Details:");
	        System.out.println("Name: " + "Luxury Apartment");
	        System.out.println("Location: " + "Downtown");
	        System.out.println("Services: " + "Furnished, Wi-Fi, Gym");
	        System.out.println("Monthly Rent: " + "1500");
	        System.out.println("Contact Information: " + "+970594568523");

	}

	private static void tenantRequestMaintenance() {
	    System.out.println("Tenant - Request Maintenance");

	    Scanner scanner = new Scanner(System.in);
	    System.out.print("Enter maintenance request description: ");
	    String description = scanner.nextLine();

	    // Create a maintenance request object (you might have a MaintenanceRequest class)
	    MaintenanceRequest request = new MaintenanceRequest(description, LocalDate.now());

	    // Process the maintenance request 
	    // ...

	    System.out.println("Maintenance request submitted successfully.");
	}



	private static void tenantBookAccommodation() {
		//choose one 
		
		 Scanner scanner = new Scanner(System.in);
			System.out.println("Choose available house unit:");
		    String house = scanner.nextLine();
		
			System.out.println("House Unit booked just contact the number to pay!");
			ff=1;
		}
		
		
	

	private static void tenantViewAvailableHousing() {
		
			if(ff==0) {
	    
	    List<HousingAdvertisement> advertisements = new ArrayList<>();

	    // Add sample housing advertisements (replace with your actual data)
	    advertisements.add(new HousingAdvertisement(1, "Studio X", "Downtown Avenue, Hebron", "Furnished, Balcony, city view", "170", "+970-599 246 802"));
	    advertisements.add(new HousingAdvertisement(2, "Condo A", "Beach Road, Gaza", "Furnished, Gym, sea view", "200", "+970-555 123 456"));
	    advertisements.add(new HousingAdvertisement(3, "Luxury Apartment", "Downtown", "Furnished, Wi-Fi, Gym", "1500", "+970594568523"));

	    if (advertisements.isEmpty()) {
	        System.out.println("No housing advertisements found.");
	    } 
	    else {
	        System.out.println("List of Housing Advertisements:");
	        for (HousingAdvertisement ad : advertisements) {
	            System.out.println("Advertisement ID: " + ad.getId());
	            System.out.println("Housing Unit: " + ad.getHousingUnit());
	            System.out.println("Location: " + ad.getLocation());
	            System.out.println("Services: " + ad.getServices());
	            System.out.println("Monthly Rent: " + ad.getMonthlyRent());
	            System.out.println("Contact Information: " + ad.getContactInfo());
	            System.out.println("------------------------------");

	        }
	        }
	    }
			else {
			    List<HousingAdvertisement> advertisements = new ArrayList<>();

			    // Add sample housing advertisements (replace with your actual data)
			    advertisements.add(new HousingAdvertisement(1, "Studio X", "Downtown Avenue, Hebron", "Furnished, Balcony, city view", "170", "+970-599 246 802"));
			    advertisements.add(new HousingAdvertisement(2, "Condo A", "Beach Road, Gaza", "Furnished, Gym, sea view", "200", "+970-555 123 456"));

			    if (advertisements.isEmpty()) {
			        System.out.println("No housing advertisements found.");
			    } 
			    else {
			        System.out.println("List of Housing Advertisements:");
			        for (HousingAdvertisement ad : advertisements) {
			            System.out.println("Advertisement ID: " + ad.getId());
			            System.out.println("Housing Unit: " + ad.getHousingUnit());
			            System.out.println("Location: " + ad.getLocation());
			            System.out.println("Services: " + ad.getServices());
			            System.out.println("Monthly Rent: " + ad.getMonthlyRent());
			            System.out.println("Contact Information: " + ad.getContactInfo());
			            System.out.println("------------------------------");

			        }
			        }
				
			}
			
		

			
	    


	
		
	}



}
