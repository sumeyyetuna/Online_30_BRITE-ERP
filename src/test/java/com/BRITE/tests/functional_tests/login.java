package com.BRITE.tests.functional_tests;

import com.BRITE.pages.Sign_In_Page;
import com.BRITE.pages.Log_In;
import org.testng.annotations.Test;

public class login extends Sign_In_Page {
    @Test
    public void test1() {
        open();

       Log_In log_in = new Log_In();
       log_in.LogIn();
    }

}
