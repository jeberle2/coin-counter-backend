package com.exercise.coincounter;

import java.util.ArrayList;
import java.util.List;


public class Counter {

    private static final List<Integer> currencyValuesInCent = List.of(20000, 10000, 5000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1);

    public static List<CounterResult> count(int priceInCents) {

        var currentPriceInCents = priceInCents;
        List<CounterResult> result = new ArrayList<>();

        for (Integer currencyType : currencyValuesInCent) {
            var currencyCount = currentPriceInCents / currencyType;
            if (currencyCount > 0) {
                currentPriceInCents = currentPriceInCents - currencyCount * currencyType;
                result.add(new CounterResult(currencyType, currencyCount));
            }
        }
        return result;
    }
}
