package com.codingblocks.unittesting

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CalcFareTest {
    @Test
    fun calcFare_isCorrect_for_0km_0min() {
        assertEquals(
                60f,
                calcFare(0f, 0),
                0.005f
        )
    }
    @Test
    fun calcFare_isCorrect_for_6km_0min() {
        assertEquals(
                70f,
                calcFare(6f, 0),
                0.005f
        )
    }
    @Test
    fun calcFare_isCorrect_for_0km_40min() {
        assertEquals(
                80f,
                calcFare(0f, 40),
                0.005f
        )
    }
    @Test
    fun calcFare_isCorrect_for_6km_40min() {
        assertEquals(
                90f,
                calcFare(6f, 40),
                0.005f
        )
    }
    @Test
    fun calcFare_isCorrect_for_minus10km_0min() {
        assertEquals(
                60f,
                calcFare(-10f, 0),
                0.005f
        )
    }
    @Test
    fun calcFare_isCorrect_for_0km_minus10min() {
        assertEquals(
                60f,
                calcFare(0f, -10),
                0.005f
        )
    }
}
