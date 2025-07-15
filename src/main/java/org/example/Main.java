package org.example;

import org.example.mobile.Contact;
import org.example.mobile.MobilePhone;
import org.example.models.Grocery;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MobilePhone mobilePhone = new MobilePhone("235674567", new ArrayList<>());
        mobilePhone.addNewContact(new Contact("mahmut", "24565432143"));
        mobilePhone.printContact();

    }
}
