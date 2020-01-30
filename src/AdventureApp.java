import java.util.Scanner;

public class AdventureApp {
    public static void main(String[] args) {
        startGame();
        Adventurer adventurer = createCharacter();
        adventurer.displayStats();

        // Create Monsters
        Monster dragon = new Monster("Dragon", 220, 13, 3);
        Monster bear = new Monster("Bear", 100, 10, 2);
        Monster gnoll = new Monster("Gnoll", 40, 7, 1);
        Monster goblin = new Monster("Goblin", 30, 5, 0);

        startBattle(adventurer, goblin);
        startBattle(adventurer, gnoll);
        startBattle(adventurer, bear);
        startBattle(adventurer, dragon);

        System.out.println("Congrats you Finished!");
    }

    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        String confirm;
        do {
            System.out.println("Begin a new game? Enter 'yes'.");
            confirm = scanner.next();
        } while (!confirm.equalsIgnoreCase("yes"));
    }

    public static Adventurer createCharacter() {
        Scanner scanner = new Scanner(System.in);
        int charClass;
        Adventurer adventurer;
        System.out.print("\nEnter your character's name: ");
        String name = scanner.next();
        printWarriorDetails();
        printRogueDetails();
        printMageDetails();
        System.out.print("\nChoose a class by entering 1, 2, or 3 (default is 1. Warrior): ");
        charClass = scanner.nextInt();
        switch (charClass) {
            default:
            case 1:
                adventurer = new Adventurer(name, "Warrior", 175, 50, 5, 10, 6, 3);
                System.out.println("\nYou chose the WARRIOR.");
                break;
            case 2:
                adventurer = new Adventurer(name, "Rogue", 125, 75, 8, 10, 4, 3);
                System.out.println("\nYou chose the ROGUE.");
                break;
            case 3:
                adventurer = new Adventurer(name, "Mage", 100, 175, 3, 10, 3, 3);
                System.out.println("\nYou chose the MAGE.");
                break;
        }
        return adventurer;
    }

    public static void printWarriorDetails() {
        System.out.println("\n1. Class: WARRIOR");
        System.out.println("Description: A warrior has moderate attack, high defense, and low spell casting.");
        System.out.printf("Health: %d | Mana: %d | Attack %d | Spell Power %d | Defense %d | Potions %d\n", 200, 50, 5, 10, 6, 3);
    }

    public static void printRogueDetails() {
        System.out.println("\n2. Class: ROGUE");
        System.out.println("Description: A rogue has high attack, moderate defense, and moderate spell casting");
        System.out.printf("Health: %d | Mana: %d | Attack %d | Spell Power %d | Defense %d | Potions %d\n", 150, 75, 8, 10, 4, 3);
    }

    public static void printMageDetails() {
        System.out.println("\n3. Class: MAGE");
        System.out.println("Description: A mage has low attack, low defense, and high spell casting");
        System.out.printf("Health: %d | Mana: %d | Attack %d | Spell Power %d | Defense %d | Potions %d\n", 100, 150, 3, 12, 3, 3);
    }

    public static void startBattle(Adventurer adventurer, Monster monster) {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        System.out.printf("\nBATTLE!! A wild %s (HEALTH: %d) appears!\n\n", monster.getName(), monster.getHealth());
        while (monster.getHealth() > 0) {
            // Take player turn
            do {
                promptMenu();
                userInput = scanner.nextInt();
                takeAction(adventurer, monster, userInput);
            } while (userInput == 4 || userInput == 3);
            if (monster.getHealth() <= 0) {
                System.out.printf("You killed %s!", monster.getName());
                break;
            }
            // take monster turn
            monsterAction(adventurer, monster);
            if (adventurer.getCurrentHealth() <= 0) {
                System.out.printf("You died from %s!\n", monster.getName());
                System.out.println("GAME OVER!");
                break;
            }
        }
    }

    public static void promptMenu() {
        System.out.printf("%10s Menu %10s\n", "", "");
        System.out.println("--------------------------");
        System.out.printf("1. %s\n", "Attack");
        System.out.printf("2. %s\n", "Cast Fireball/Recharge Mana");
        System.out.printf("3. %s\n", "Potion");
        System.out.printf("4. %s\n", "Display Stats");
        System.out.print("Your action (1-4)(default: 1): ");
    }

    public static void monsterAction(Adventurer adventurer, Monster monster) {
        int damage = monster.getAttack() - adventurer.getDefense();
        if (damage > 0) {
            adventurer.takeDamage(damage);
            System.out.printf("OUCH! %s dealt %d damage to you!\n", monster.getName(), damage);
        } else {
            System.out.println("You took no damage due to high defense!");
        }
    }

    public static void takeAction(Adventurer adventurer, Monster monster, int action) {
        switch (action) {
            default:
            case 1:
                int damage = adventurer.getAttack() - monster.getDefense();
                if (damage <= 0) {
                    System.out.println("\nYour attack is too low. 0 damage done!");
                } else {
                    monster.takeDamage(damage);
                    System.out.printf("\nYou dealt %d damage!\n", damage);
                    System.out.printf("%s has %d HEALTH.\n\n", monster.getName(), monster.getHealth());
                }
                break;
            case 2:
                if (adventurer.getMana() < 25) {
                    adventurer.rechargeMana(35);
                    System.out.printf("\nNot enough Mana to cast. Current Mana: %d\n", adventurer.getMana());
                    System.out.print("\nRecharging mana.\n...\n...\nRecovered 35 mana!\n");
                    System.out.printf("Current Mana: %d\n", adventurer.getMana());
                } else {
                    adventurer.removeMana(25);
                    monster.takeDamage(adventurer.getSpellPower());
                    System.out.printf("\nYou dealt %d damage with Fireball!\n", adventurer.getSpellPower());
                    System.out.printf("%s has %d HEALTH.\n\n", monster.getName(), monster.getHealth());
                }
                break;
            case 3:
                if (adventurer.getPotions() >= 1) {
                    System.out.println("\nYou used a potion and fully recovered!\n");
                    adventurer.usePotion();
                } else {
                    System.out.println("You do not have enough potions!");
                }
                break;
            case 4:
                adventurer.displayStats();
                break;
        }
    }

}
