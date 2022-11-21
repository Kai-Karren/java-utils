package de.kaikarren.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorTests {

    @Test
    void shouldGenerateRandomNumberBetweenZeroAnd5_GivenBoundaryFive() {

        var seed = 424242;

        var randomGenerator = new RandomGenerator(seed);

        var boundary = 5;

        var result = randomGenerator.randomNumber(boundary);

        assertTrue(result >= 0 && result < boundary);

    }

    @Test
    void shouldGenerateRandomNumberBetween10IncludingAnd20Excluding() {

        var seed = 424242;

        var randomGenerator = new RandomGenerator(seed);

        int result = randomGenerator.randomNumberBetween(10, 20);

        assertTrue(result >= 10 && result < 20);

    }

}