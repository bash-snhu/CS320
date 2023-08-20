package contactService;

public class Contact {
	
	private final String ID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String ID, String firstName, String lastName, String phone, String address) {
		// Check that ID is not null and is not longer than 10 characters
		if(ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		// Check that firstName is not null and is not longer than 10 characters
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		// Check that lastName is not null and is not longer than 10 characters
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		// Check that phone is not null and is exactly 10 digits long
		if(phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		// Check that address is not null and is not longer than 30 characters
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// Getters and Setters
	
	// ID
	public String getID() {
		return ID;
	}

	// First Name
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		
		this.firstName = firstName;
	}

	// Last Name
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		this.lastName = lastName;
	}

	
	// Phone Number
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if(phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		
		this.phone = phone;
	}

	// Address
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		this.address = address;
	}	
}
