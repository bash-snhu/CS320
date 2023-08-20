package contactService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
	// Testing variables
	private final String specific_id = "1234567";
	private String firstName_good_length = "Balthaczar";
	private String lastName_good_length = "Emperor";
	private String phone_good_length = "1555555555";
	private String address_good_length = "1 Infinite Loop, Cupertino, CA";
	
	private final String specific_id_bad_length = "12345672343423432";
	private String firstName_bad_length = "Balthaczar the Emperor";
	private String lastName_bad_length = "Emperor of the Nile States";
	private String phone_bad_length = "15555552222333555";
	private String address_bad_length = "1123435435 Infinite Loop, Cupertino, CA";
	
	@Test void genIDLength() {
		ContactService cserv = new ContactService();
		cserv.addContact(firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		assertEquals(cserv.getContacts().get(0).getID().length(), 10);
	}
	
	@Test
	void genUniqueIDTest() {
		ContactService cserv = new ContactService();
		
		// Add two contacts with IDs not specified
		cserv.addContact(firstName_good_length, lastName_good_length, phone_good_length, address_good_length); // Contact 0
		cserv.addContact(firstName_good_length, lastName_good_length, phone_good_length, address_good_length); // Contact 1
		cserv.addContact(firstName_good_length, lastName_good_length, phone_good_length, address_good_length); // Contact 2
		
		// Assert that the three IDs are unique
		assertNotEquals(cserv.getContacts().get(0).getID(), cserv.getContacts().get(1).getID());
		assertNotEquals(cserv.getContacts().get(1).getID(), cserv.getContacts().get(2).getID());
		assertNotEquals(cserv.getContacts().get(2).getID(), cserv.getContacts().get(0).getID());
	}
	
	@Test
	void addNewContactTest() {
		ContactService cserv = new ContactService();
		
		// Add contact
		cserv.addContact(specific_id, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		assertEquals(cserv.getContacts().get(0).getID(), specific_id);
		assertEquals(cserv.getContacts().get(0).getFirstName(), firstName_good_length);
		assertEquals(cserv.getContacts().get(0).getLastName(), lastName_good_length);
		assertEquals(cserv.getContacts().get(0).getPhone(), phone_good_length);
		assertEquals(cserv.getContacts().get(0).getAddress(), address_good_length);
	}
	
	@Test
	void findContactTest() {
		// Verify that service is able to add and find single valid contact by ID
		ContactService cserv = new ContactService();
		
		// Add contact
		cserv.addContact(specific_id, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		// Assert that the added contact is the same as the one with given ID
		assertEquals(cserv.findContact(specific_id).getID(), specific_id);
		assertEquals(cserv.findContact(specific_id).getFirstName(), firstName_good_length);
		assertEquals(cserv.getContacts().get(0).getLastName(), lastName_good_length);
		assertEquals(cserv.findContact(specific_id).getPhone(), phone_good_length);
		assertEquals(cserv.getContacts().get(0).getAddress(), address_good_length);
	}
	
	@Test
	void addContactIDAlreadyExists() {
		ContactService cserv = new ContactService();
		
		cserv.addContact(specific_id, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		// Object with same ID cannot be added twice
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Throws exception because same ID is used twice
			cserv.addContact(specific_id, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		});
	}
	
	// Test ID
	@Test
	void addContactBadID() {
		ContactService cserv = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Throws exception ID is bad length
			cserv.addContact(specific_id_bad_length, firstName_bad_length, lastName_good_length, phone_good_length, address_good_length);
		});
	}
	
	// Test FirstName
	@Test
	void addContactBadFirstName() {
		ContactService cserv = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Throws exception name is bad length
			cserv.addContact(specific_id, firstName_bad_length, lastName_good_length, phone_good_length, address_good_length);
		});
	}
	
	@Test
	void addContactNullFirstName() {
		ContactService cserv = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Throws exception name is null
			cserv.addContact(specific_id, null, lastName_good_length, phone_good_length, address_good_length);
		});
	}
	
	// Test lastName
	@Test
	void addContactBadLastName() {
		ContactService cserv = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Throws exception last name is bad length
			cserv.addContact(specific_id, firstName_good_length, lastName_bad_length, phone_good_length, address_good_length);
		});
	}
	
	@Test
	void addContactNullLastName() {
		ContactService cserv = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Throws exception last name is null
			cserv.addContact(specific_id, firstName_good_length, null, phone_good_length, address_good_length);
		});
	}
	
	// Test Phone
	@Test
	void addContactBadPhone() {
		ContactService cserv = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Throws exception phone is too long
			cserv.addContact(specific_id, firstName_good_length, lastName_good_length, phone_bad_length, address_good_length);
		});
	}
	
	@Test
	void addContactNullPhone() {
		ContactService cserv = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Throws exception phone is null
			cserv.addContact(specific_id, firstName_good_length, lastName_good_length, null, address_good_length);
		});
	}
	
	// Test Address
	@Test
	void addContactBadAddress() {
		ContactService cserv = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Throws exception address is too long
			cserv.addContact(specific_id, firstName_good_length, lastName_good_length, phone_good_length, address_bad_length);
		});
	}
	
	@Test
	void addContactNullAddress() {
		ContactService cserv = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Throws exception address is null
			cserv.addContact(specific_id, firstName_good_length, lastName_good_length, phone_good_length, null);
		});
	}
	
	@Test
	void notFoundTest() {
		// FindContact method should return null if that object is not found
		ContactService cserv = new ContactService();
		
		// Returns null because contact with ID does not exist
		assertNull(cserv.findContact(specific_id));
	}
	
	@Test
	void deleteContactTest() {
		ContactService cserv = new ContactService();
		
		// Add Contact
		cserv.addContact(specific_id, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		// Delete Contact
		cserv.deleteContact(specific_id);
		
		// Verify that object no longer exists
		assertNull(cserv.findContact(specific_id));
		assertTrue(cserv.getContactsSize() == 0);
	}
	
	@Test
	void deleteContactDoesNotExistTest() {
		ContactService cserv = new ContactService();
	
		// Try to delete contact that doesn't exist
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cserv.deleteContact(specific_id);
		});
	}
	
	@Test
	void updateContactTest() {
		ContactService cserv = new ContactService();
		Contact contactcompare = new Contact(specific_id, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		// Add initial contact
		cserv.addContact(specific_id, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		// Update contact with altered attributes and same ID
		cserv.updateContact(specific_id, "DiffFName", "DiffLName", "DiffPhone#", "DiffAdd");
		
		// Assert that all attributes are equal to their changed counterparts (though ID is not changeable)
		assertEquals(cserv.findContact(specific_id).getID(), contactcompare.getID());
		assertEquals(cserv.findContact(specific_id).getFirstName(), "DiffFName");
		assertEquals(cserv.findContact(specific_id).getLastName(), "DiffLName");
		assertEquals(cserv.findContact(specific_id).getPhone(), "DiffPhone#");
		assertEquals(cserv.findContact(specific_id).getAddress(), "DiffAdd");
	}
	
	// Test invalid update lengths

	@Test
	void updateContactTooLongFirstNameTest() {
		ContactService cserv = new ContactService();
		// Add initial contact
		cserv.addContact(specific_id, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		// Update with too-long name throws exception
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cserv.updateContact(specific_id, firstName_bad_length, lastName_good_length, phone_good_length, address_good_length); 
		});
	}
	
	@Test
	void updateContactTooLongLastNameTest() {
		ContactService cserv = new ContactService();
		// Add initial contact
		cserv.addContact(specific_id, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		// Update with too-long lastname throws exception
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cserv.updateContact(specific_id, firstName_good_length, lastName_bad_length, phone_good_length, address_good_length); 
		});
	}
		
	@Test
	void updateContactTooLongPhoneTest() {
		ContactService cserv = new ContactService();
		// Add initial contact
		cserv.addContact(specific_id, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		// Update with too-long description throws exception
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cserv.updateContact(specific_id, firstName_good_length, lastName_good_length, phone_bad_length, address_good_length);
		});
	}
	
	@Test
	void updateContactTooLongAddressTest() {
		ContactService cserv = new ContactService();
		// Add initial contact
		cserv.addContact(specific_id, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		// Update with too-long address throws exception
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cserv.updateContact(specific_id, firstName_good_length, lastName_good_length, phone_good_length, address_bad_length);
		});
	}
	
	// Test Null Update
	
	@Test
	void updateContactNullFirstNameTest() {
		ContactService cserv = new ContactService();
		// Add initial contact
		cserv.addContact(specific_id, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		// Update with null name throws exception
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cserv.updateContact(specific_id, null, lastName_good_length, phone_good_length, address_good_length); 
		});
	}
	
	@Test
	void updateContactNullLastNameTest() {
		ContactService cserv = new ContactService();
		// Add initial contact
		cserv.addContact(specific_id, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		// Update with null name throws exception
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cserv.updateContact(specific_id, firstName_good_length, null, phone_good_length, address_good_length); 
		});
	}
		
	@Test
	void updateContactNullPhoneTest() {
		ContactService cserv = new ContactService();
		// Add initial contact
		cserv.addContact(specific_id, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		// Update with null phone throws exception
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cserv.updateContact(specific_id, firstName_good_length, lastName_good_length, null, address_good_length);
		});
	}
	
	@Test
	void updateContactNullAddressTest() {
		ContactService cserv = new ContactService();
		// Add initial contact
		cserv.addContact(specific_id, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		
		// Update with null address throws exception
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cserv.updateContact(specific_id, firstName_good_length, lastName_good_length, phone_good_length, null);
		});
	}
	
	@Test 
	void updateContactDoesNotExistTest() {
		ContactService cserv = new ContactService();
		
		// Update contact that does not exist
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cserv.updateContact(specific_id, firstName_good_length, lastName_good_length, phone_good_length, address_good_length);
		});
	}
}
