package acceptTest;

import java.util.ArrayList;
import java.util.List;

public class FurnitureAdvertised {
    private List<FurnitureItem> advertisedFurnitureList;
    private String successMessage="success!!";
    private String errorMessage="error!!";
    private String removeConfirmationPrompt;
    private FurnitureItem selectedFurnitureItem;
    private boolean furnitureListDisplayed;
    public FurnitureAdvertised() {
        advertisedFurnitureList = new ArrayList<>(); 
        furnitureListDisplayed = false;
    }

    
    public void fillFurnitureDetails(String description, String condition, String price) {
        // Check if the price is not null and is not empty
        if (price != null && !price.isEmpty()) {
            // Parse the price to an integer
        	
        	String parsedPrice = price;
            try {
                parsedPrice = price;
            } catch (NumberFormatException e) {
                System.out.println("Invalid price format. Please enter a valid number.");
                return;
            }
            
            // Create a new FurnitureItem object with the provided details
            FurnitureItem furnitureItem = new FurnitureItem(description, condition, parsedPrice);
            
            // Add the new furniture item to the list of advertised furniture
            advertisedFurnitureList.add(furnitureItem);
            
            System.out.println("Furniture details added successfully.");
        } else {
            System.out.println("Price cannot be empty. Please provide a valid price.");
        }
    }

    
    // ... rest of the class code ...
    public void setupTestData() {
        // Add some test data to the advertisedFurnitureList
        FurnitureItem furnitureItem1 = new FurnitureItem("Used Sofa in Good Condition", "Good", "$200");
        FurnitureItem furnitureItem2 = new FurnitureItem("New Table", "Excellent", "$150");
        FurnitureAdvertised furnitureAdvertised = null;
		furnitureAdvertised.fillFurnitureDetails(furnitureItem1.getDescription(), furnitureItem1.getCondition(), furnitureItem1.getPrice());
        furnitureAdvertised.fillFurnitureDetails(furnitureItem2.getDescription(), furnitureItem2.getCondition(), furnitureItem2.getPrice());
    }

    public void verifyAdvertisedFurnitureList() {
        if (advertisedFurnitureList.isEmpty()) {
            System.out.println("No furniture items have been advertised.");
        } else {
            System.out.println("List of Advertised Furniture:");
            for (int i = 0; i < advertisedFurnitureList.size(); i++) {
                FurnitureItem furnitureItem = advertisedFurnitureList.get(i);
                System.out.println("Item " + (i + 1) + ":");
                System.out.println("Description: " + furnitureItem.getDescription());
                System.out.println("Condition: " + furnitureItem.getCondition());
                System.out.println("Price: " + furnitureItem.getPrice());
                System.out.println("------------------------");
            }
        }
        furnitureListDisplayed = true;
    }


    public boolean isFurnitureListDisplayed() {
        return furnitureListDisplayed;
    }

    
    
    public boolean isSuccessMessageDisplayed() {
        return successMessage != null && !successMessage.isEmpty();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

   
    public void selectFurnitureItemToEdit(String furnitureName) {
        for (FurnitureItem item : advertisedFurnitureList) {
            if (item.getDescription().equals(furnitureName)) {
                selectedFurnitureItem = item;
                break;
            }
        }
    }

    public void updateFurniturePrice(String description, String newPrice) {
        if (selectedFurnitureItem != null) {
            selectedFurnitureItem.setPrice(newPrice);
            successMessage = "Furniture price updated successfully!";
        }
    }

    public void selectFurnitureItemToRemove(String furnitureName) {
        for (FurnitureItem item : advertisedFurnitureList) {
            if (item.getDescription().equals(furnitureName)) {
                selectedFurnitureItem = item;
                break;
            }
        }

        if (selectedFurnitureItem != null) {
            removeConfirmationPrompt = "Are you sure you want to remove this furniture?";
        }
    }

    public boolean isRemoveConfirmationPromptDisplayed() {
        return removeConfirmationPrompt != null && !removeConfirmationPrompt.isEmpty();
    }

    public boolean isFurnitureItemDisplayed(String furnitureName) {
        for (FurnitureItem item : advertisedFurnitureList) {
            if (item.getDescription().equals(furnitureName)) {
                return true;
            }
        }
        return false;
    }
    
   


    public class FurnitureItem {
    	
        private String description;
        private String condition;
        private String price;

        public FurnitureItem(String description, String condition, String price) {
            this.description = description;
            this.condition = condition;
            this.price =price;
        }

        public String getDescription() {
        	
            return description;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
        
        public void setDescription(String description) {
            this.description = description;
        }
        
        public void setCondition(String condition) {
            this.condition = condition;
        }
        
        public String getCondition() {
        	return condition;
        }
        
    }

	}