package entity;

import java.util.Random;

public class GeneralHelp {

//TODO  需要检测生成的ID是否已经在表中
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
