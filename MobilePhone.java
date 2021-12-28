package com.company;

import javax.swing.text.DefaultEditorKit;
import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();//initialize constructor with a new array lsit within the constructor
    }



    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if(position >= 0) {
           myContacts.set(position, newContact);
//            System.out.println("Contact was updated sucessfully");
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact) {
        int position = findContact(contact);
        if(position >= 0) {
            myContacts.remove(position);
            return true;
        }
        return false;
    }

    private int findContact(Contact val) {
        return myContacts.indexOf(val);
    }
    private int findContact(String val) {
        for(int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(val)) {
                return i;
            }
        }
        return -1;
    }
    public Contact queryContact(String name) {
        int position = findContact(name);
        if(position >= 0) {
            return myContacts.get(position);
        }
        return null;
    }
    public void printContacts() {
        System.out.println("Contacts List: ");
        for(int i = 0; i < myContacts.size(); i++) {
            System.out.println((i+1) + ". " + (myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber() ));
        }
    }
}
