package com.example.adilbek.kinoafisha_project;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import com.example.adilbek.kinoafisha_project.adapterler.Adapter_Kino;
import com.example.adilbek.kinoafisha_project.apiler.ApiKino;
import com.example.adilbek.kinoafisha_project.modelder.kino_modelder.Kino;
import com.example.adilbek.kinoafisha_project.modelder.kino_modelder.Result;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
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
     // Espresso.onView(withId(R.id.first)).check(matches(withText(mKino.get(1).name)));
  }
  @Test
  public void TestActors(){
      Espresso.onView(withId(R.id.second)).check(matches(isDisplayed()));
     // Espresso.onView(withId(R.id.first)).check(matches(withText(mKino.get(1).actors)));
  }
  @Test
  public void TestRej(){
      Espresso.onView(withId(R.id.third)).check(matches(isDisplayed()));
     // Espresso.onView(withId(R.id.first)).check(matches(withText(mKino.get(1).rejisser)));
  }
    @After
    public void tearDown() throws Exception {
    }


}