package se.lexicon.tor;

import java.util.Scanner;

public class App
{

    static public Scanner sc;

    public static void main( String[] args )
    {
        run();
    }

    static private void run(){
        System.out.println("<====|=() ----- Welcome! ----- ()=|====>\n\n\t\t\t  Now....Fight!\n\n<====|=() -------------------- ()=|====>\n\t(After you've made your character)\n\n");
        sc = new Scanner(System.in);

        Coordinator handler = new Coordinator();

        //Equipment equipment = new Equipment();
        Player userCharacter = new Player();

        playTheGame(userCharacter);

    }

    static private void playTheGame(Player userCharacter){
        int round = 0;
        Player winner = Battle.tutorial(userCharacter);
        round++;
        Equipment.getRewards(userCharacter, round);
        userCharacter.levelUp(round);
        System.out.println("Pretty good, next time, it's for real....\n");
        boolean notRetired = true;
        do {
            winner = Battle.playBattle(userCharacter, round);

            if (winner != userCharacter){
                System.out.print("You're dead.");
                break;
            }

            System.out.println("Another win under your belt, good job! I sure hope you don't die....hehehehehe....hehe....");
            Equipment.getRewards(userCharacter, round);
            userCharacter.levelUp(round);

            notRetired = askIfRetire(userCharacter);

        } while (notRetired);
    }

    public static boolean askIfRetire(Player userCharacter){
        System.out.println("Do you wish to retire at this point?\nYou've got " + userCharacter.getMoney() + " coins as of now\n\nRetire, yes or no: ");
        while (true) {
            String choice = sc.nextLine();
            switch (choice) {
                case "yes":
                    return false;
                case "no":
                    return true;
                default:
                    System.out.println("\n\nPlease answer my question, I am being very much serious\n\n");
            }
        }
    }

}
