package contactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest { 
	
	// Predefined good and bad input sets for testing
	private final String iD_good_length = "1234567";
	private final String firstName_good_length = "HappyName";
	private final String lastName_good_length = "HappyName";
	private final String phone_good_length = "1111111111";
	private final String address_good_length = "1 Infinite Loop Cupertino CA";
	
	private final String iD_bad_length = "12341234123412341234";
	private final String firstName_bad_length = "BadNameIsTooLongIfYouReallyConsiderIt";
	private final String lastName_bad_length = "BadNameIsTooLongIfYouReallyConsiderIt";
	private final String phone_bad_length = "111";
	private final String address_bad_length = "123 Pensylvania Ave Washington District Columbia";
	

	@Test
	void testNewContact() {
		Contact contact = new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		// Test initialization of Contact object
		assertEquals(contact.getID(), iD_good_length);
		assertEquals(contact.getFirstName(), firstName_good_length);
		assertEquals(contact.getLastName(), lastName_good_length);
		assertEquals(contact.getPhone(), phone_good_length);
		assertEquals(contact.getAddress(), address_good_length);
	}
	
	// Test ID
	@Test
	void testNewContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// ID Too Long
			new Contact(iD_bad_length, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		});
	}
	
	@Test 
	void testNewContactIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// ID Null
			new Contact(null, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		});
	} 
	
	// Test FirstName
	@Test 
	void testNewContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Name too long
			new Contact(iD_good_length, firstName_bad_length, lastName_good_length, phone_good_length, address_good_length);
		});
	}
	
	@Test 
	void testNewContactFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Name Null
			new Contact(iD_good_length, null, lastName_good_length, phone_good_length, address_good_length);
		});
	}
	
	// Test LastName
	@Test 
	void testNewContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Name too long
			new Contact(iD_good_length, firstName_good_length, lastName_bad_length, phone_good_length, address_good_length);
		});
	}
	
	@Test 
	void testNewContactLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Name Null
			new Contact(iD_good_length, firstName_good_length, null, phone_good_length, address_good_length);
		});
	}
	
	// Test Phone
	@Test 
	void testNewContactPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Phone too long
			new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_bad_length, address_good_length);
		});
	}
	
	@Test 
	void testNewContactPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Phone Null
			new Contact(iD_good_length, firstName_good_length, lastName_good_length, null, address_good_length);
		});
	}
	
	// Test Address
	@Test 
	void testNewContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Phone too long
			new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_good_length, address_bad_length);
		});
	}
	
	@Test 
	void testNewContactAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Phone Null
			new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_good_length, null);
		});
	}
	
	@Test
	void getIDTest() {
		Contact contact = new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		assertEquals(contact.getID(), iD_good_length);
	}

	@Test
	void getFirstNameTest() {
		Contact contact = new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		assertEquals(contact.getFirstName(), firstName_good_length);
	}
	
	@Test
	void getLastNameTest() {
		Contact contact = new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		assertEquals(contact.getLastName(), lastName_good_length);
	}
	
	@Test
	void getPhoneTest() {
		Contact contact = new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		assertEquals(contact.getPhone(), phone_good_length);
	}
	
	@Test
	void getAddressTest() {
		Contact contact = new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		assertEquals(contact.getAddress(), address_good_length);
	}
	
	// Test Setters
	
	// First Name
	@Test
	void setFirstNameTest() {
		Contact contact = new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		contact.setFirstName("Different");
		assertEquals(contact.getFirstName(), "Different");
	}
	
	@Test
	void setBadFirstNameTest() {
		Contact contact = new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// FirstName Too Long
			contact.setFirstName(firstName_bad_length);
		});
	}
	
	@Test
	void setNullFirstNameTest() {
		Contact contact = new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// FirstName Too Long
			contact.setFirstName(null);
		});
	}
	
	// Last Name
	@Test
	void setLastNameTest() {
		Contact contact = new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		contact.setLastName("Different");
		assertEquals(contact.getLastName(), "Different");
	}
	
	@Test
	void setBadLastNameTest() {
		Contact contact = new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// LN Too Long
			contact.setLastName(lastName_bad_length);
		});
	}
	
	@Test
	void setNullLastNameTest() {
		Contact contact = new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// LN Too Long
			contact.setLastName(null);
		});
	}
	
	// Set Phone
	
	@Test
	void setPhoneTest() {
		Contact contact = new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		contact.setPhone("2222222222");
		assertEquals(contact.getPhone(), "2222222222");
	}
	
	@Test
	void setBadPhoneTest() {
		Contact contact = new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Phone too long
			contact.setPhone(phone_bad_length);
		});
	}
	
	@Test
	void setNullPhoneTest() {
		Contact contact = new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Phone null
			contact.setPhone(null);
		});
	}
	
	// Set Address
	
	@Test
	void setAddressTest() {
		Contact contact = new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		contact.setAddress("NewAddress");
		assertEquals(contact.getAddress(), "NewAddress");
	}
	
	@Test
	void setBadAddressTest() {
		Contact contact = new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Address too long
			contact.setAddress(address_bad_length);
		});
	}
	
	@Test
	void setNullAddressTest() {
		Contact contact = new Contact(iD_good_length, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Phone null
			contact.setAddress(null);
		});
	}
}
