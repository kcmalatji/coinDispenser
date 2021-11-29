package com.chris.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
public class CoinDispencerImpl {
    // Assume minimum to be max int value.
    private static final int defaultMin = Integer.MAX_VALUE;
    /**
     * @param denominators
     * @param number
     * @return int
     */
    public static int getMinimum(int denominators[], int number) {
        // If no denominators provided then minimum coins required is zero.
        // If number to decompose is less than 1 then minimum coins required is zero.
        if(denominators.length < 1 || number < 1) {
            return 0;
        }
        // Create a cache to remember minimum values.
        final List<Integer> minimumCache = new ArrayList<>();
        // Initialise the first element, required for first iteration.
        minimumCache.add(0);
        // Loop from 1 to number +1 getting minimums for denominators
        IntStream.range(1, number + 1).forEach(num -> {
            // Assume initial minimum to be max integer.
            int minimum = defaultMin;
           
            for (int denominator : denominators) {
                if (num >= denominator) {
                    minimum = Math.min(minimum, 1 + minimumCache.get(num - denominator));
                }
            }
            minimumCache.add(minimum);
        });
        return minimumCache.get(number);
    }
    public static void main(String[] args) {
        int denominators[] = {1,2, 3};
        System.out.println(getMinimum(denominators, 5));
    }
}