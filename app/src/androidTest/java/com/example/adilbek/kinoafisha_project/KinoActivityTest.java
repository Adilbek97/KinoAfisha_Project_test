package com.example.adilbek.kinoafisha_project;

import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;

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

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.v4.content.ContextCompat.startActivity;
import static org.junit.Assert.*;

public class KinoActivityTest {

    @Rule
    public ActivityTestRule<KinoActivity> mActivityRule = new ActivityTestRule<>(
            KinoActivity.class);
     ArrayList<Result> mKino;
     final int position=6;
    @Before
    public void setUp() throws Exception {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ApiKino.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiKino apiKino=retrofit.create(ApiKino.class);
        Call<Kino> call = apiKino.getKino();
        call.enqueue(new Callback<Kino>() {
            @Override
            public void onResponse(Call<Kino> call, Response<Kino> response) {
                mKino = response.body().getResult();
            }
            @Override
            public void onFailure(Call<Kino> call, Throwable t) {
            }
        });
    }
     @Test
     public void TestKinoRecycle(){
         try {
             Thread.sleep(5000);
             Espresso.onView(withId(R.id.recyclerView2)).perform(RecyclerViewActions.<RecyclerView.ViewHolder>scrollToPosition(position));
             Thread.sleep(2000);
             Espresso.onView(withId(R.id.recyclerView2)).perform(RecyclerViewActions.<RecyclerView.ViewHolder>actionOnItemAtPosition(position,click()));
             Espresso.onView(withId(R.id.image_f)).check(matches(isDisplayed()));
             Espresso.onView(withId(R.id.first)).check(matches(isDisplayed()));
             Espresso.onView(withId(R.id.first)).check(matches(withText(mKino.get(position).name)));
             Espresso.onView(withId(R.id.second)).check(matches(isDisplayed()));
             Espresso.onView(withId(R.id.third)).check(matches(isDisplayed()));
            // Espresso.onView(withId(R.id.third)).check(matches(withText(mKino.get(position).getCountries())));
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
          /*Intent intent=new Intent(KinoActivity.this,KinoSecondActivity.class);
         startActivity(intent);*/
     }

/*
    @Test
    public void TestImage(){
        Espresso.onView(withId(R.id.image_f)).check(matches(isDisplayed()));
    }

    @Test
    public void TestName(){
        Espresso.onView(withId(R.id.first)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.first)).check(matches(withText(mKino.get(1).name)));
    }
    @Test
    public void TestActors(){
        Espresso.onView(withId(R.id.second)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.first)).check(matches(withText(mKino.get(1).actors)));
    }
    @Test
    public void TestRej(){
        Espresso.onView(withId(R.id.third)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.first)).check(matches(withText(mKino.get(1).rejisser)));
    }
    @After
    public void tearDown() throws Exception {
    }*/
}