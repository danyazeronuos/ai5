package org.example;

import org.example.utils.Net;

public class Main {

    public static void main(String[] args) {

        double[][] trainingData = {
                {1, 1, 1, 1, -1, 1, 1, -1, 1},
                {1, 1, 1, 1, -1, -1, 1, -1, -1},
                {1, -1, -1, 1, -1, -1, 1, 1, 1}
        };

        double[] test = {1, 1, 1, 1, -1, -1, 1, -1, -1};

        var ai = new Net(trainingData);

        System.out.println();
        printImage(test);
        System.out.println();
        double[] predict = ai.predict(test, 5);

        printImage(predict);

    }

    private static void printImage(double[] image) {
        for (int i = 0; i < image.length; i++) {
            if (i % 3 == 0) System.out.println();
            System.out.print(image[i] > 0 ? "#" : " ");
        }
    }
}