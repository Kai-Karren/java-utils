package de.kaikarren.utils;

import java.util.Random;

public class RandomGenerator {

    private final Random random;

    public RandomGenerator() {
        random = new Random();
    }

    public RandomGenerator(long seed) {
        this.random = new Random(seed);
    }

    public RandomGenerator(Random random) {
        this.random = random;
    }

    public int randomNumber(int bound) {

        return this.random.nextInt(bound);

    }

    public int randomNumberBetween(int start, int end) {

        var temp = random.nextInt(end);

        return temp + start;

    }

}
