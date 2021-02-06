package com.example.cst438_wk01hw02;

import android.content.Context;
import android.content.Intent;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class IntentFactoryTest {
    @Test
    public void factoryCreatesIntent() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Intent intent = ListPostsActivity.getIntent(appContext);
        assertEquals(".ListPostsActivity", intent.getStringExtra("activity_name"));
    }
}