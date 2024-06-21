import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

	   @Test
	    void testNewContact() throws Exception
	    {
	        ContactService service = new ContactService();
	    	service.newContact("1234", "Larry", "Fine","0123456789", "180 Groove Rd");
	        Contact contact = service.getContactList().get(0);
	        assertEquals("1234", contact.getContactID());
	        assertEquals("Larry", contact.getFirstname());
	        assertEquals("Fine", contact.getLastName());
	        assertEquals("0123456789", contact.getPhoneNum());
	        assertEquals("180 Groove Rd", contact.getAddress());
	    }
	    @Test
	    void testdeleteTast() throws Exception
	    {
	    	ContactService service = new ContactService();
	        service.newContact("1234", "Larry", "Fine","0123456789", "180 Groove Rd");
		service.newContact("5678", "Curly", "Howard", "0123456789","180 Groove Rd");
		service.newContact("1812", "Moe", "Howard", "0123456789","180 Groove Rd");
		
		// exception to delete contact	
	        assertEquals(3, service.getContactList().size());
	        service.deleteContact("1234");
	        assertEquals(2, service.getContactList().size());
	        service.deleteContact("5678");
	        assertEquals(1, service.getContactList().size());
	        service.deleteContact("1812");
	        assertEquals(0, service.getContactList().size());
	    }
	    @Test 
	    void negativeTestforNewContact () throws Exception
	    {
	    	ContactService service = new ContactService();
	       	service.newContact("1234", "Larry", "Fine","0123456789", "180 Groove Rd");
		  	assertThrows(IllegalArgumentException.class, () -> service.newContact("1234", "Larry", "Fine","0123456789", "180 Groove Rd"));
	    }
	    @Test 
	    void negativeTestforDeleteContact () throws Exception
	    {
	      // exception to delete contact
	      ContactService service = new ContactService(); 
	      service.newContact("1234", "Larry", "Fine","0123456789", "180 Groove Rd");
	      assertThrows(IllegalArgumentException.class, () -> service.deleteContact("5678"));
	    }
}
