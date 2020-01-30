import java.util.ArrayList;

public class Adventurer {
    private String name;
    private String charClass;
    private int maxHealth;
    private int maxMana;
    private int currentHealth;
    private int currentMana;
    private int attack;
    private int spellPower;
    private int defense;
    private int potions;

    public Adventurer(String name, String charClass, int maxHealth, int maxMana, int attack, int spellPower, int defense, int potions) {
        this.name = name;
        this.charClass = charClass;
        this.maxHealth = maxHealth;
        this.maxMana = maxMana;
        this.currentHealth = maxHealth;
        this.currentMana = maxMana;
        this.attack = attack;
        this.spellPower = spellPower;
        this.defense = defense;
        this.potions = potions;
    }

    public String getName() {
        return this.name;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getMana() {
        return this.currentMana;
    }

    public int getSpellPower() {
        return this.spellPower;
    }

    public int getDefense() {
        return this.defense;
    }

    public void usePotion() {
        this.currentHealth = this.maxHealth;
        this.currentMana = this.maxMana;
        this.potions--;
    }

    public void rechargeMana(int mana) {
        this.currentMana += mana;
    }

    public void removeMana(int mana) {
        this.currentMana -= mana;
    }

    public int getPotions() {
        return this.potions;
    }

    public void takeDamage(int damage) {
        this.currentHealth -= damage;
    }

    public void displayStats() {
        System.out.printf("\n\nMy Stats | %s\n", this.charClass);
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("Max Health: %4d | Current Health: %4d | Max Mana: %4d | Current Mana: %4d | Attack %3d | Spell Power %3d | Defense %3d | Potions %2d\n\n\n", this.maxHealth, this.currentHealth, this.maxMana, this.currentMana, this.attack, this.spellPower, this.defense, this.potions);
    }
}
