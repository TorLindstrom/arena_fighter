package se.lexicon.tor;

import static se.lexicon.tor.App.sc;

public class Player {

    private int strength = 1;
    private int speed = 1;
    private int precision = 1;
    private int hp = 5;
    private String name;
    private int money = 3;
    private int[] equipment = {0,0,0};
    private Equipment[] worn = new Equipment[11];

    //------------------------------------------------------------------------------------------------------------------

    public static String[] names = {"Julius", "Avernus", "Asskicker", "Petrus", "Julia", "Nocta", "Augustus", "Scipio"};

    //------------------------------------------------------------------------------------------------------------------

    public void printYourStats(){
        System.out.println("You have these stats:\n-Strength:\t" + strength + "-\n-Speed:\t\t" + speed + "-\n-Precision:\t" + precision + "-\n-Health points:\t" + hp + "-");
    }

    public void printStats(){
        System.out.println("Your opponent have these stats:\n-Strength:\t" + strength + "-\n-Speed:\t\t" + speed + "-\n-Precision:\t" + precision + "-\n-Health points:\t" + hp + "-");
    }

    //------------------------------------------------------------------------------------------------------------------

    public void askForCreation() {
        System.out.print("We'll start by giving your character a name: ");
        name = sc.nextLine();
        System.out.print("\nProbably a good name, I can't read. Now then...\nDo you wish to get a starting equipment piece or some well needed Denarius?\n\nEquipment piece or money: ");
        boolean invalidStart;
        String choice;
        do {
            choice = sc.nextLine().trim().toLowerCase();
            invalidStart = false;
            switch (choice) {
                case "money":
                    int randomMoney = Dice.getRandom(2, 7);
                    money += 5;
                    System.out.println("Alrighty, I got....uh....hur..sh...uh, " + randomMoney + " coins! Man, I sure am helpful.\n");
                    break;
                case "equipment":
                case "equipment piece":
                case "piece":
                    Equipment starter = Equipment.getRandomEquipment(0);
                    worn[starter.getSlot()] = new Equipment(starter);
                    System.out.println("Alrighty, hope you'll like this.....\n\n" + worn[starter.getSlot()].getName() + " and it's " + worn[starter.getSlot()].getCoolness() + " but hey, it's something!\n");
                    break;
                default:
                    System.out.println("\nSpeak up, dummy\n");
                    invalidStart = true;
            }
        } while (invalidStart);
        System.out.print("Probably should tell you, I got magical powers!\nProbably shouldn't tell you that I am not good with using them!\nBut I can try and give you a stat boost, so, what would you like to maybe get better at?\n\nStrength, speed, or precision: ");
        do {
            choice = sc.nextLine().trim().toLowerCase();
            invalidStart = false;
            switch (choice){
                case "strength":
                    strength += (int) Dice.getRandomDouble()+1.5;
                    break;
                case "speed":
                    speed += (int) Dice.getRandomDouble()+1.5;
                    break;
                case "precision":
                    precision += (int) Dice.getRandomDouble()+1.5;
                    break;
                default:
                    invalidStart = true;
            }
        } while (invalidStart);
        System.out.println("Great! Maybe, let's see your starting stats....\n");
        this.printYourStats();
        System.out.println("Nice, almost as strong as...uh...something weak, but that's fine, you'll grow!");
    }

    public static String getRandomName(){
        int number = Dice.getRandom(names.length-1);
        return names[number];
    }

    public void levelUp(int round){
        this.strength += (int) Dice.getRandomDouble() + Dice.getRandom(round)*1.1 + 0.5;
        this.speed += (int) Dice.getRandomDouble() + Dice.getRandom(round)*1.1 + 0.5;
        this.precision += (int) Dice.getRandomDouble() + Dice.getRandom(round)*1.1 + 0.5;
        this.hp += (int) Dice.getRandomDouble() + Dice.getRandom(round)*1.1 + 0.5;
    }

    public Player(int round){
        this.name = getRandomName();

        this.strength += (int) Dice.getRandomDouble() + Dice.getRandom(round)*1.1 + 0.5;
        this.speed += (int) Dice.getRandomDouble() + Dice.getRandom(round)*1.1 + 0.5;
        this.precision += (int) Dice.getRandomDouble() + Dice.getRandom(round)*1.1 + 0.5;
        this.hp += (int) Dice.getRandomDouble() + Dice.getRandom(round)*1.1 + 0.5;
    }

    Player() {
        //askForCreation();
    }

    Player(String name) {
        this.name = name;
    }

    Player(String name, int strength, int speed, int precision) {
        this(name);
        this.strength = strength;
        this.precision = precision;
        this.speed = speed;
    }

    Player(String name, int strength, int speed, int precision, int money) {
        this(name, strength, speed, precision);
        this.money = money;
    }

    //------------------------------------------------------------------------------------------------------------------


    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Equipment[] getWorn() {
        return worn;
    }

    public void setWorn(Equipment[] worn) {
        this.worn = worn;
    }

    public static String[] getNames() {
        return names;
    }

    public static void setNames(String[] names) {
        Player.names = names;
    }

    public int getArmor(){
        return equipment[0];
    }
    public int getWeapon(){
        return equipment[1];
    }
    public int getShield(){
        return equipment[2];
    }
}
