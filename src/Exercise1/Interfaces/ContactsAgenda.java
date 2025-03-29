package Exercise1.Interfaces;

import Exeptions.NotFoundException;
import Exercise1.Model.Contact;

public interface ContactsAgenda {
    void addContact(Contact contact);
    Contact searchContactByName(String name) throws NotFoundException;
    void setNumber(String number,String name) throws NotFoundException;
    void deleteContact(Contact contact)throws NotFoundException;
    void viewAll();
}
