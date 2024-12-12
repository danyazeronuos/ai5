package org.example.utils;

import java.util.function.BiFunction;

public class Sign implements BiFunction<Double, Double, Double> {
    private static final double EPSILON = 1e-9;

    @Override
    public Double apply(Double x, Double y) {
        if (x < -EPSILON) {
            return -1.0;
        } else if (x > EPSILON) {
            return 1.0;
        } else {
            return y;
        }
    }
}