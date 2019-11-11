package se.lexicon.tor;

public class Battle {


    public static Player tutorial(Player userCharacter) {
        System.out.print("Now for your first fight!\n\n<====|=() - Hope you don't die - ()=|====>\n\n");
        Player opponent = new Player(Player.getRandomName(), 1, 1, 1);
        tellAboutOpponent(opponent);

        return fightWithDice(userCharacter, opponent);
    }

    public static Player playBattle(Player userCharacter, int round) {
        System.out.print("Another fight lines up, either you die, or you win.\nSimple as that.\n\n");
        userCharacter.printYourStats();
        Player opponent = new Player(round);
        tellAboutOpponent(opponent);
        return fightWithDice(userCharacter, opponent);
    }

    public static void tellAboutOpponent(Player opponent) {
        System.out.print("Your opponent is: " + opponent.getName() + "\n");
        opponent.printStats();
    }

    public static Player fightWithDice(Player userCharacter, Player opponent) {
        System.out.print("\n" + userCharacter.getName() + " versus " + opponent.getName() + "\n\n--- Fight! ---\n\n");
        int userHp = userCharacter.getHp();
        int opponentHp = opponent.getHp();

        while (true) {

            System.out.println("Time to throw!");
            App.sc.nextLine();
            int userDice = Dice.rollDice() + userCharacter.getStrength();
            int opponentDice = Dice.rollDice() + opponent.getStrength();

            System.out.println("You threw a:\t\t" + userDice + "\nWhile your opponent threw a:\t" + opponentDice);

            if (userDice < opponentDice) {
                System.out.println("You took a hit!");
                userHp -= opponent.getStrength();
                if (userHp <= 0) {
                    System.out.println("\n\nYour blood stains the sand....\n\nWell fought, we'll mourn you\n\n");
                    return opponent;
                }
            } else if (userDice > opponentDice) {
                System.out.println("You hit your opponent!");
                opponentHp -= userCharacter.getStrength();
                if (opponentHp <= 0) {
                    System.out.println("Your enemy topples over after a good hit, and thuds unto the ground, gaping gorge of red open at his side....\n\nWell fought....");
                    return userCharacter;
                }
            } else {
                System.out.println("You both hit pretty damn hard, no blood though");
            }
        }
    }
}
