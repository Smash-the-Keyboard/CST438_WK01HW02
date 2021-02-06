package com.example.cst438_wk01hw02;

import org.junit.Test;

import static org.junit.Assert.*;

public class VerifyCredentialsTest {

    @Test
    public void correctUsernamePasses() {
        MainActivity mainActivity = new MainActivity();
        assertTrue(mainActivity.verifyUsername("din_djarin"));
    }

    @Test
    public void correctPasswordPasses() {
        MainActivity mainActivity = new MainActivity();
        assertTrue(mainActivity.verifyPassword("baby_yoda_ftw"));
    }

    @Test
    public void incorrectUsernameFails() {
        MainActivity mainActivity = new MainActivity();
        assertFalse(mainActivity.verifyUsername("eddie"));
    }

    @Test
    public void incorrectPasswordFails() {
        MainActivity mainActivity = new MainActivity();
        assertFalse(mainActivity.verifyPassword("beskar_4_ever"));
    }
}