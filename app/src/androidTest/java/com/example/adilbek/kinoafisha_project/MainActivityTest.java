package com.example.adilbek.kinoafisha_project;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);
    final int position=10;
    @Test
    public void RecyclerTest(){
        try {
            Thread.sleep(5000);
            Espresso.onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.<RecyclerView.ViewHolder>scrollToPosition(position));
            Thread.sleep(2000);
            Espresso.onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.<RecyclerView.ViewHolder>actionOnItemAtPosition(position,click()));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         }


}