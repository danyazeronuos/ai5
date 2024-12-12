package org.example.utils;

import java.util.Arrays;

public class Net {
    private final double[][] weight;
    private final Sign sign = new Sign();

    public Net(double[][] input) {
        int size = input[0].length;
        this.weight = new double[size][size];

        for (var current : input) {
            calculateWeight(current, size);
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.weight[i][j] /= size;
            }
        }
    }

    public double[] predict(double[] input, int maxIterations) {
        boolean isStable = false;
        int iteration = 0;

        while (!isStable && iteration < maxIterations) {
            double[] result = new double[input.length];

            for (int i = 0; i < input.length; i++) {
                double sum = 0;

                for (int j = 0; j < input.length; j++) {
                    sum += input[j] * weight[j][i];
                    result[i] = sign.apply(sum, result[i]);
                }

            }

            isStable = java.util.Arrays.equals(input, result);

            input = result;
            iteration++;
        }

        return input;
    }


    private void calculateWeight(double[] current, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row != col) {
                    this.weight[row][col] += current[row] * current[col];
                }
            }
        }
    }
}
