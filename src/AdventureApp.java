import java.util.Scanner;

public class AdventureApp {
    public static void main(String[] args) {
        startGame();
        createCharacter();
//        Adventurer adventurer = createCharacter();
//        System.out.println(adventurer.getName());
    }

    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        String confirm;
        do {
            System.out.println("Begin a new game? Enter 'yes'.");
            confirm = scanner.next();
        } while (!confirm.equalsIgnoreCase("yes") );
    }

    public static void createCharacter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your character's name: ");
        String name = scanner.next();
        System.out.println("Choose a class by entering 1, 2, or 3:\n");
        printWarriorDetails();
        printRogueDetails();
        printMageDetails();
//        return new Adventurer(name);
    }

    public static void printWarriorDetails() {
        System.out.println("1. Class: WARRIOR");
        System.out.println("Description: A warrior has moderate attack, high defense, and low spell casting.");
        System.out.printf("Health: %d | Mana: %d | Attack %d | Defense %d | Potions %d\n", 200, 50, 5, 8, 3);
    }

    public static void printRogueDetails() {
        System.out.println("2. Class: ROGUE");
        System.out.println("Description: A rogue has high attack, moderate defense, and moderate spell casting");
        System.out.printf("Health: %d | Mana: %d | Attack %d | Defense %d | Potions %d\n", 150, 75, 8, 4, 4);
    }

    public static void printMageDetails() {
        System.out.println("3. Class: MAGE");
        System.out.println("Description: A mage has low attack, low defense, and high spell casting");
        System.out.printf("Health: %d | Mana: %d | Attack %d | Defense %d | Potions %d\n", 100, 150, 3, 3, 3);
    }

}
