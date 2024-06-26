import java.util.ArrayList;
import java.util.List;

public class ContactService 
{
	public List<Contact> contactList = new ArrayList<Contact>();

	public void newContact(String contactID, String firstName, String lastName, String phoneNum, String address)  throws Exception 
	{
      for(int i = 0; i< contactList.size(); i++) {
        if (contactID.equals(contactList.get(i).getContactID())) 
        {
        	 throw new IllegalArgumentException("Contact already exists");       
        }
      }
      
      contactList.add(new Contact(contactID, firstName, lastName, phoneNum, address));
	}

	public void deleteContact(String id)
    {
      for(int i = 0; i< contactList.size();) {
        if (id.equals(contactList.get(i).getContactID())) 
        {
        	contactList.remove(i);
        	return;
        }
        throw new IllegalArgumentException("Contact already deleted or does not exist");
      }
	}

	  public List<Contact> getContactList() 
	  { 
		  return contactList; 
	  }

}
