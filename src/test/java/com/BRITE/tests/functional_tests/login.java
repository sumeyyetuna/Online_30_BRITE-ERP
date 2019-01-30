package com.BRITE.tests.functional_tests;

import com.BRITE.pages.Menu;
import com.BRITE.pages.Sign_In_Page;
import com.BRITE.pages.Log_In;
import com.BRITE.utilities.Driver;
import com.BRITE.utilities.TestBase;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class login extends TestBase {
    @Test
    public void test1() {
       Log_In log_in = new Log_In();
       log_in.LogIn();

        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Menu menu = new Menu();
        menu.leaves.click();
    }

}
