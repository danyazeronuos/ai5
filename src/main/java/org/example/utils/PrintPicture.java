package org.example.utils;

import java.util.function.BiConsumer;

public class PrintPicture implements BiConsumer<double[], Integer> {
    @Override
    public void accept(double[] images, Integer size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(images[i * size + j] > 0 ? "%" : " ");
            }
            System.out.println();
        }
    }
}
