package acceptTest;

import java.util.List;


	
public class HotelRoom {
	        private String hotelName;
	        private String destination;
	        private String checkInDate;
	        private String checkOutDate;
	        private int price;
	        private List<String> amenities;

	        public HotelRoom(String hotelName, String destination, String checkInDate, String checkOutDate, int price, String selectedAmenities) {
	            this.hotelName = hotelName;
	            this.destination = destination;
	            this.checkInDate = checkInDate;
	            this.checkOutDate = checkOutDate;
	            this.price = price;
	            this.amenities = amenities;
	        }

	        // Getters and setters for the attributes
	        public String getHotelName() {
	            return hotelName;
	        }

	        public void setHotelName(String hotelName) {
	            this.hotelName = hotelName;
	        }

	        public String getDestination() {
	            return destination;
	        }

	        public void setDestination(String destination) {
	            this.destination = destination;
	        }

	        public String getCheckInDate() {
	            return checkInDate;
	        }

	        public void setCheckInDate(String checkInDate) {
	            this.checkInDate = checkInDate;
	        }

	        public String getCheckOutDate() {
	            return checkOutDate;
	        }

	        public void setCheckOutDate(String checkOutDate) {
	            this.checkOutDate = checkOutDate;
	        }

	        public int getPrice() {
	            return price;
	        }

	        public void setPrice(int price) {
	            this.price = price;
	        }

	        public List<String> getAmenities() {
	            return amenities;
	        }

	        public void setAmenities(List<String> amenities) {
	            this.amenities = amenities;
	        }
	    }



