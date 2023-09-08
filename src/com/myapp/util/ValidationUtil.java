package com.myapp.util;

public class ValidationUtil {
    public static boolean isInputValid(int num) {
        return num >= -2_000_000_000 && num <= 2_000_000_000;
    }

    // Helper method to check if result is not bigger than 2 billion
    public static boolean isResultValid(double result) {
        return result >= -2_000_000_000 && result <= 2_000_000_000;
    }
}
