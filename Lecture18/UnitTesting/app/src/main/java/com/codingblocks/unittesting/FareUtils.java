package com.codingblocks.unittesting;

public class FareUtils {
    static float calcFare (float km, int min) {
        float fare = 60f;
        if (km > 5) {
            fare += (km - 5) * 10;
        }
        if (min > 30) {
            fare += (min - 30) * 2;
        }
        return fare;
    }
}
