package com.BRITE.tests.smoke_tests;

import com.BRITE.pages.Log_In;
import com.BRITE.utilities.Driver;
import com.BRITE.utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.BRITE.utilities.Pages;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class login extends TestBase {

    @Test
    public void login() throws InterruptedException {
       pages.login().LogIn();

        pages.menu().notes.click();
        Thread.sleep(5000);
        assertEquals(pages.menu().header.getText(),"Notes");

    }

    public static void main(String[] args) {


    }
}
