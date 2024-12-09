package org.example.utils;

import java.util.function.Function;

public class Sign implements Function<Double, Double> {
    @Override
    public Double apply(Double x) {
        return x < 0 ? -1.0 : 1.0;
    }
}
