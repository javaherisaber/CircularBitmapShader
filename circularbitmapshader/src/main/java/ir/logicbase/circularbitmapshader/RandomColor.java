package ir.logicbase.circularbitmapshader;

import android.graphics.Color;

import java.util.Random;

public class RandomColor {
    public static int generateBrightColor() {
        Random random = new Random(System.currentTimeMillis());

        final int red = random.nextInt(256);
        final int green = random.nextInt(256);
        final int blue = random.nextInt(256);

        int variant1 = Color.argb(255, red, 0, 255);
        int variant2 = Color.argb(255, red, 255, 0);
        int variant3 = Color.argb(255, 255, green, 0);
        int variant4 = Color.argb(255, 0, green, 255);
        int variant5 = Color.argb(255, 255, 0, blue);
        int variant6 = Color.argb(255, 0, 255, blue);

        int[] choices = {variant1, variant2, variant3, variant4, variant5, variant6};
        return choices[random.nextInt(6)];
    }
}
