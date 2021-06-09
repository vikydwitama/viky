package com.example.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.home.HomeActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by root on 3/1/18.
 */
@RunWith(AndroidJUnit4::class)
class HomeActivityTest {
    @Rule
    @JvmField var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun testAppBehaviour() {
        onView(withId(R.id.spinner))
                .check(matches(isDisplayed()))
        onView(withId(R.id.spinner)).perform(click())
        onView(withText("Spanish La Liga")).perform(click())

        onView(withText("Barcelona"))
                .check(matches(isDisplayed()))
        onView(withText("Barcelona")).perform(click())

        onView(withId(R.id.add_to_favorite))
                .check(matches(isDisplayed()))
        onView(withId(R.id.add_to_favorite)).perform(click())
        onView(withText("Added to favorite"))
                .check(matches(isDisplayed()))
        pressBack()

        onView(withId(R.id.bottom_navigation))
                .check(matches(isDisplayed()))
        onView(withId(R.id.favorites)).perform(click())
    }
}
