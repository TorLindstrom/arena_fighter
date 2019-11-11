package se.lexicon.tor;

import static org.junit.Assert.*;
import static se.lexicon.tor.Dice.getRandom;
import static se.lexicon.tor.Dice.rollDice;

import org.junit.Test;

public class DiceTest {

    @Test
    public void test6Dice(){
        int rolled = rollDice();
        assertTrue(rolled < 7 && rolled > 0);
    }

    @Test
    public void testGetRandom(){
        int random = getRandom(10,20);
        assertTrue(random < 20 && random > 10);
    }


}
