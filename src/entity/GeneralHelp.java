package entity;

import java.util.Random;

public class GeneralHelp {


    public static String getRandomUserID () {
        Random randomGenerator = new Random();
        long n = 0;
        do {
            n = randomGenerator.nextLong();
        } while (n < 0);
        String s = String.valueOf(n);
        return s;
    }
}
