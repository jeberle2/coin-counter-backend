package com.exercise.coincounter;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.exercise.coincounter.Counter.currencyValuesInCent;
import static org.assertj.core.api.Assertions.assertThat;

class CounterTest {

    @Test
    void shouldReturnEmptyResultForZero() {
        var result = Counter.count(0);

        assertThat(result).isEmpty();
    }

    @Test
    void shouldCountWithAllAvailableCurrencyTypes() {
        double priceInEuro = 388.88;
        var result = Counter.count((int) (priceInEuro * 100));

        assertThat(result).extracting(CounterResult::type).containsExactly(currencyValuesInCent.toArray(Integer[]::new));
        assertThat(result).extracting(CounterResult::value).allMatch(i -> i == 1);
    }

    @Test
    void shouldCount() {
        int priceInEuro = 140;
        var result = Counter.count(priceInEuro * 100);

        CounterResult oneHundredEuro = CounterResult.builder().type(10000).value(1).build();
        CounterResult twoTwentyEuro = CounterResult.builder().type(2000).value(2).build();
        assertThat(result).usingRecursiveComparison().isEqualTo(List.of(oneHundredEuro, twoTwentyEuro));
    }

}