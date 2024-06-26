import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class contactTest {
    @Test
    void testGetters() {
        Contact contact = new Contact("1234", "Larry", "Fine", "0123456789", "180 Groove Rd");

	// assert that data matches contact information
        assertEquals("1234", contact.getContactID());
        assertEquals("Larry", contact.getFirstname());
        assertEquals("Fine", contact.getLastName());
        assertEquals("0123456789", contact.getPhoneNum());
        assertEquals("180 Groove Rd", contact.getAddress());
    }

    @Test
    void testSetters() {
    	Contact contact = new Contact("5678", "Curly", "Howard", "0123456789", "180 Groove Rd");

        // call setters
    	contact.setContactID("5678");
    	contact.setFirstname("Curly");
    	contact.setLastName("Howard");
    	contact.setPhoneNum("0123456789");
    	contact.setAddress("180 Groove Rd");


        // assert that data matches contact information
        assertEquals("5678", contact.getContactID());
        assertEquals("Curly", contact.getFirstname());
        assertEquals("Howard", contact.getLastName());
        assertEquals("0123456789", contact.getPhoneNum());
        assertEquals("180 Groove Rd", contact.getAddress());
    }
    @Test 
    void negativeTestforNull() 
    {
    Contact contact = new Contact("2187","Shemp", "Howard", "0123456789", "180 Groove Rd");
  
    // throw to setters 
    assertThrows(IllegalArgumentException.class, () -> contact.setContactID(null));
    assertThrows(IllegalArgumentException.class, () -> contact.setFirstname(null));
    assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
    assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNum(null));
    assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));

    }
    @Test 
    void negativeTestforInvalidCharacters ()
    {
    	Contact contact = new Contact("2187","Shemp", "Howard", "0123456789", "180 Groove Rd");
    	  
 
        // throw to setters
        assertThrows(IllegalArgumentException.class, () -> contact.setContactID("123449999999563"));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstname("Shempodijsdoifj"));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("Howard"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNum("0123456789"));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("180 Groove Rd, IN Evansville 47923"));
    }
}