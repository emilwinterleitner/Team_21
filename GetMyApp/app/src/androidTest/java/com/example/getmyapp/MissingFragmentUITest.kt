package com.example.getmyapp

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.getmyapp.ui.missing.MissingFragment
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MissingFragmentUITest {
    @Test
    @Throws(Exception::class)
    fun initMissingOverview() {
        launchFragmentInContainer<MissingFragment>()

        onView(withId(R.id.speciesSpinner)).check(matches(withSpinnerText("Select Species")))
        onView(withId(R.id.colorSpinner)).check(matches(withSpinnerText("Select Colour")))
        onView(withId(R.id.regionSpinner)).check(matches(withSpinnerText("Select Province")))

        onView(RecyclerViewMatcher(R.id.missingPetsRecyclerView).atPosition(0))
                .check(matches(hasDescendant(withText("Waldi"))))

        onView(RecyclerViewMatcher(R.id.missingPetsRecyclerView).atPosition(1))
                .check(matches(hasDescendant(withText("Katzi"))))
    }
}