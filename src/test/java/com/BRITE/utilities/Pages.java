package com.BRITE.utilities;

import com.BRITE.pages.*;

public class Pages {
    private Manafacturing_Page manufacturingPage;
    private ContactsPage contactsPage;
    private Menu menu;


    private Log_In logInPage;

    public Log_In login() {
        if (logInPage == null) {
            logInPage = new Log_In();
        }
        return logInPage;
    }

    public Manafacturing_Page manufacturing() {
        if (manufacturingPage == null) {
            manufacturingPage = new Manafacturing_Page();
        }
        return manufacturingPage;
    }

    public ContactsPage contactsPage() {
        if (contactsPage == null) {
            contactsPage = new ContactsPage();
        }
        return contactsPage;
    }

    public Menu menu() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

}
