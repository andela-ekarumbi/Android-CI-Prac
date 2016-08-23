package com.andela.continuousintegration;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule
             = new ActivityTestRule<>(MainActivity.class);
             
    @Before
    public void setUp() {
        MainActivity activity = mainActivityTestRule.getActivity();
        Runnable wakeUpDevice = new Runnable() {
            public void run() {
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                    WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                    WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        };
        activity.runOnUiThread(wakeUpDevice);
    }

    @Test
    public void testEnterName() {
        String expected = "Hello, Eston";
        onView(withId(R.id.enterName)).perform(typeText("Eston"));
        onView(withId(R.id.nameButton)).perform(click());
        onView(withId(R.id.nameDisplay)).check(matches(withText(expected)));
    }

    @Test
    public void testNotEnterName() {
        String expected = "Please enter your names.";
        onView(withId(R.id.nameButton)).perform(click());
        onView(withId(R.id.nameDisplay)).check(matches(withText(expected)));
    }
}
