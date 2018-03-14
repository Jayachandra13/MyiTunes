package com.jc.myitunes

import android.app.Activity
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.SmallTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.widget.EditText
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by jayachandra on 14/3/18.
 */

@RunWith(AndroidJUnit4::class)
@SmallTest
public class MainActivityTest {
    @Rule
    val mActivityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)
    private var mActivity: Activity? = null

    private val activityMonitor = InstrumentationRegistry.getInstrumentation().addMonitor(DetailsActivity::class.java.name, null, false)

    @Before
    fun setUp() {
        mActivity = mActivityTestRule.activity
    }

    @Test
    fun testSearchStringNotNull() {
        assertNotNull(mActivity?.findViewById(R.id.etEnterSearchText))
        assertNotNull(mActivity?.findViewById(R.id.ivFetch))
        onView(withId(R.id.ivFetch)).perform(click())
        val searchString = mActivity?.findViewById<EditText>(R.id.etEnterSearchText)?.text.toString().trim()
        assertTrue(searchString.isNotEmpty())

        val isNetWorkAvailable = Utils.Companion.isNetworkConnection(mActivity?.applicationContext!!)
        assertTrue(isNetWorkAvailable)
        val isValidSearchString = Utils.Companion.isValidString("SearchKey")
        assertTrue(isValidSearchString)

        //TODO Interface callback response should be test

        assertNotNull(mActivity?.findViewById(R.id.rcv))


        //TODO Test cases for to check adapter , AdapterOnClickInterfaceListener and intent data

        val mDetailsActivity = InstrumentationRegistry.getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000)

        assertNotNull(mDetailsActivity)

        // TODO Test Parcelable Data
    }

    @After
    fun tearDown() {
        mActivity = null

    }
}