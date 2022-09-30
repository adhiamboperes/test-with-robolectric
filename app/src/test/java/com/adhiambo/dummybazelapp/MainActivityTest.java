package com.adhiambo.dummybazelapp;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule rule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void launchingActivityDisplaysCardWithTitleAndSubtitleText() {
        String expected_title = "This is title text";
        String expected_subtitle = "Some supporting text. Much longer than the title.";

        ActivityScenario scenario = rule.getScenario();

        scenario.onActivity(activity -> {
            Espresso.onView(withId(R.id.card)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
            Espresso.onView(withId(R.id.cardTitle)).check(matches(withText(expected_title)));
            Espresso.onView(withId(R.id.cardSubTitle)).check(matches(withText(expected_subtitle)));
        });
    }
}