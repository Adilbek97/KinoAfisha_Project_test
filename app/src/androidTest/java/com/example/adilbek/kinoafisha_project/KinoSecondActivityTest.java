package com.example.adilbek.kinoafisha_project;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class KinoSecondActivityTest {
    @Rule
    public ActivityTestRule<KinoSecondActivity> mActivityRule = new ActivityTestRule<>(
            KinoSecondActivity.class);

    @Before
    public void setUp() throws Exception {
    }
  @Test
  public void TestImage(){
      Espresso.onView(withId(R.id.image_f)).check(matches(isDisplayed()));
  }
  @Test
  public void TestName(){
      Espresso.onView(withId(R.id.first)).check(matches(isDisplayed()));
  }
  @Test
  public void TestActors(){
      Espresso.onView(withId(R.id.second)).check(matches(isDisplayed()));
  }
  @Test
  public void TestArej(){
      Espresso.onView(withId(R.id.third)).check(matches(isDisplayed()));
  }
    @After
    public void tearDown() throws Exception {
    }


}