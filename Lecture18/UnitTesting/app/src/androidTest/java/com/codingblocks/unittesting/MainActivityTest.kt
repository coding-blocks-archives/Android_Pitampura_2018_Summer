package com.codingblocks.unittesting

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import kotlinx.android.synthetic.main.activity_main.*

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    lateinit var mainActivity: MainActivity

    @Rule @JvmField
    val mainActivityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun setup () {
        mainActivity = mainActivityTestRule.activity
    }

    @Test
    fun calcfare_works_0km_0min () {
        mainActivity.runOnUiThread {
            mainActivity.apply {
                etKm.setText("0")
                etMin.setText("0")
                btnCalcFare.performClick()
                val fare = tvResult.text
                assertEquals("60.0", fare)
            }
        }
    }

    @Test
    fun shows_result_from_intent () {
        val i = Intent(mainActivity, MainActivity::class.java)
        i.putExtra("RESULT", "10")
        mainActivityTestRule.launchActivity(i).apply {
            runOnUiThread {
                assertEquals("10", tvResult.text)
            }
        }
    }
}
