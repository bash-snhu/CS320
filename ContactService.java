package contactService;

import java.util.ArrayList;
import java.util.UUID;

public class ContactService {
	
	// Contact Container
	private ArrayList<Contact> Contacts;
	
	// Instantiate container when service is initialized
	public ContactService() {
		this.Contacts = new ArrayList<>();
	}
	
	// Generate unique ID of length 10
	private String genID() {
	    return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
	
	// Generate ID and add new contact to array list
	public void addContact(String firstName, String lastName, String phone, String address) {		
		// Create new contact object with supplied parameters and unique ID
		Contact contact = new Contact(genID(), firstName, lastName, phone, address);
		
		// Throw exception if ID exists
		if(findContact(contact.getID()) != null) {
			throw new IllegalArgumentException("Contact with ID already exists.");
		}
		else {
			// If ID doesn't exist in Contacts add contact
			Contacts.add(contact);
		}
	}
	
	// Add contact to array list with specified ID
	public void addContact(String ID, String firstName, String lastName, String phone, String address) {
		Contact contact = new Contact(ID, firstName, lastName, phone, address);
		
		// Throw exception if ID exists
		if(findContact(contact.getID()) != null) {
			throw new IllegalArgumentException("Contact with ID already exists.");
		}
		
		// If ID doesn't exist in Contacts add contact
		Contacts.add(contact);
	}
	
	// Find contact in Contacts arraylist by ID
	public Contact findContact(String ID) {
		// Search Contacts for ID
		for (int i = 0; i < Contacts.size(); i++) {
			if(Contacts.get(i).getID().equals(ID)) {
				return Contacts.get(i);
			}
		}
		// If not found, return null
		return null;
	}
	
	// Delete contact in Contacts by ID
	public void deleteContact(String ID) {
		Contact tempContact = findContact(ID);
		
		// If appointment was found
		if(tempContact != null) {
			Contacts.remove(tempContact);
		}
		else {
			throw new IllegalArgumentException("Contact cannot be deleted because it doesn't exist.");
		}
	}
	
	// Update contact by ID
	public void updateContact(String ID, String firstName, String lastName, String number, String address) {
		// Search Contacts for requested ID
		for (int i = 0; i < Contacts.size(); i++) {
			if(Contacts.get(i).getID().equals(ID)) {
				// If ID is found, update four mutable attributes
				Contacts.get(i).setFirstName(firstName);
				Contacts.get(i).setLastName(lastName);
				Contacts.get(i).setPhone(number);
				Contacts.get(i).setAddress(address);
				return;
			}
		}
		throw new IllegalArgumentException("Contact does not exist.");
	}
	
	public int getContactsSize() {
		// Return length of Contacts list
		return Contacts.size();
	}
	
	// Return Appointments
	public ArrayList<Contact> getContacts() {
		return Contacts;
	}
}
