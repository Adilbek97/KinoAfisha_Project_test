package com.example.adilbek.kinoafisha_project;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class KinoActivityTest {

    @Rule
    public ActivityTestRule<KinoActivity> mActivityRule = new ActivityTestRule<>(
            KinoActivity.class);

    @Before
    public void setUp() throws Exception {
    }
     @Test
     public void TestKinoRecycle(){
         Espresso.onView(withId(R.id.recyclerView2)).perform(RecyclerViewActions.<RecyclerView.ViewHolder>actionOnItemAtPosition(1,click()));

     }
    @After
    public void tearDown() throws Exception {
    }
}