import java.util.ArrayList;

public class Adventurer {
    private String name;
    private String charClass;
    private int health;
    private int mana;
    private int attack;
    private int defense;
    private int potions;

    public Adventurer (String name, String charClass, int health, int mana, int attack, int defense, int potions) {
        this.name = name;
        this.charClass = charClass;
        this.health = health;
        this.mana = mana;
        this.attack = attack;
        this.defense = defense;
        this.potions = potions;
    }

    public String getName() {
        return this.name;
    }
    public static void displayStats() {

    }
}
