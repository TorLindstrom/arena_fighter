package se.lexicon.tor;

public class Equipment {

    private int slot;
    private String name;
    private String description;
    private int strength;
    private int speed;
    private String coolness;

    //------------------------------------------------------------------------------------------------------------------

    static Equipment[] availableRarity1 = {new Equipment(6,"Silly dagger","A silly little dagger going 'stabstab'.",1, 1,"Silly"),
            new Equipment(1, "Little hat", "A small little hat sitting on your head.", 1, 1,"Silly"),
            new Equipment(2,"Clumsy cuirass", "This cuirass sure is clumsy", 2, 3, "Big looking"),
            new Equipment(3,"Agile shoes", "A pair of shoes to put on your feet, speedy", 1, 1, "Hard to notice"),
            new Equipment(4, "Tough gloves", "A pair of really darn sturdy gloves", 2, 2, "Tough guy status"),
            new Equipment(5, "Broken sword", "Better than nothing", 1, 1, "Broken"),
            new Equipment(7, "Broken shield", "Almost better than nothing", 1, 2, "Broken"),
            new Equipment(8, "Moth eaten cape", "A cape left to rot", 1, 2, "Not fashionable")
    };

    static Equipment[][] availableEquipment = {availableRarity1};

    //------------------------------------------------------------------------------------------------------------------

    public static Equipment getRandomEquipment(int rarity){
        int lengthOfRarity = availableEquipment[rarity].length;
        int random = Dice.getRandom(lengthOfRarity-1);
        return getAvailableEquipment()[rarity][random];
    }

    public static void getRewards(Player userCharacter, int round){
        int totalMoney = (int) (userCharacter.getMoney() + 2 + round * 1.3);
        userCharacter.setMoney(totalMoney);
    }

    //------------------------------------------------------------------------------------------------------------------

    public Equipment(Equipment toClone){
        this.slot = toClone.slot;
        this.name = toClone.name;
        this.description = toClone.description;
        this.strength = toClone.strength;
        this.speed = toClone.speed;
        this.coolness = toClone.coolness;
    }

    public Equipment(){
    }

    Equipment(int slot, String name, String description){
        this.slot = slot;
        this.name = name;
        this.description = description;
    }

    public Equipment(int slot, String name, String description, int strength) {
        this(slot, name, description);
        this.strength = strength;
    }

    public Equipment(int slot, String name, String description, int strength, int speed) {
        this(slot, name, description, strength);
        this.speed = speed;
    }

    public Equipment(int slot, String name, String description, int strength, int speed, String coolness) {
       this(slot, name, description, strength, speed);
        this.coolness = coolness;
    }

    //------------------------------------------------------------------------------------------------------------------


    public static Equipment[][] getAvailableEquipment() {
        return availableEquipment;
    }

    public static Equipment[] getAvailableRarity1() {
        return availableRarity1;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getCoolness() {
        return coolness;
    }

    public void setCoolness(String coolness) {
        this.coolness = coolness;
    }
}
