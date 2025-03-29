package Exercise1.Repository;

import Exeptions.NotFoundException;
import Exercise1.Interfaces.ContactsAgenda;
import Exercise1.Model.Contact;

import java.util.HashSet;
import java.util.Set;

public class ContactsList <T extends Contact> implements ContactsAgenda {

    private Set<T> contactsList;

    public ContactsList() {
        this.contactsList=new HashSet<>();
    }

    @Override
    public void addContact(Contact contact) {
        if (!(contactsList.contains(contact))){

            contactsList.add((T)contact);
            System.out.println("The contact has been added.");
        }
        else {
            System.out.println("Something failed...");
        }

    }

    @Override
    public Contact searchContactByName(String name) throws NotFoundException {
        Contact result=null;
        for(T contact:contactsList){
            if(contact.getName().equals(name))
            {
                result=contact;
            }
        }
        if(result==null)
            throw new NotFoundException("The contact isn't on the list");
        else
            return result;
    }

    @Override
    public void setNumber(String number,String name) throws NotFoundException {
        boolean found=false;
        for(T contact:contactsList){
            if(contact.getName().equals(name)){
                contact.setNumber(number);
                found=true;
                break;
            }
        }
        if(!found){
            throw new NotFoundException("The contact isn't on the list");
        }
    }

    @Override
    public void deleteContact(Contact contact) throws NotFoundException {
            if(contactsList.contains(contact))
                contactsList.remove(contact);
            else
                throw new NotFoundException("The contact isn't on the list");
    }


    @Override
    public void viewAll() {
        contactsList.forEach(System.out::println);
    }
}
