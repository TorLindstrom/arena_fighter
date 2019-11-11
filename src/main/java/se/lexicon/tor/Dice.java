package se.lexicon.tor;

import java.util.Random;

public class Dice {

    private static  Random dice = new Random();

    public static int rollDice(){
        return dice.nextInt(5)+1;
    }

    public static int getRandom(int from, int to){
        return dice.nextInt(to - from) + from;
    }

    public static int getRandom(int to){
        return dice.nextInt(to) + 1;
    }

    public static double getRandomDouble(){
        return dice.nextDouble();
    }

    public static int getRandomEquipmentSlot(){
        return dice.nextInt(12) + 1;
    }

}
