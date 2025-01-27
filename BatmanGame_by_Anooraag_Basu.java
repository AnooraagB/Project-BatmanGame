import java.util.Random;
import java.util.Scanner;

public class BatmanGame_by_Anooraag_Basu {
    // Game variables
    static int health = 100;
    static int attackDamage = 30;
    static int numHealthPotions = 3;
    static int healthPotionHealAmount = 30;
    static int healthPotionDropChance = 50; // Percentage

    static String[] enemies = {"Joker", "Bane", "Riddler", "Penguin"};
    static int maxEnemyHealth = 75;
    static int enemyAttackDamage = 25;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        boolean running = true;
        System.out.println("Welcome to Gotham City!");

        GAME:
        while (running) {
            System.out.println("------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth) + 1;
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! #\n");

            while (enemyHealth > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\nWhat will you do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Use Health Potion");
                System.out.println("\t3. Run!");
                System.out.println("\t4. Quit (Press 'q')");

                String input = in.nextLine();

                if (input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage) + 1;
                    int damageTaken = rand.nextInt(enemyAttackDamage) + 1;

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You dealt " + damageDealt + " damage to " + enemy + ".");
                    System.out.println("\t> You took " + damageTaken + " damage in retaliation!");

                    if (health <= 0) {
                        System.out.println("\t> You have been defeated by " + enemy + "!");
                        break GAME;
                    }
                } else if (input.equals("2")) {
                    if (numHealthPotions > 0) {
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You used a health potion, healing for " + healthPotionHealAmount + " HP.");
                        System.out.println("\t> You now have " + health + " HP.");
                        System.out.println("\t> You have " + numHealthPotions + " health potions left.\n");
                    } else {
                        System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one.\n");
                    }
                } else if (input.equals("3")) {
                    System.out.println("\tYou ran away from " + enemy + "!");
                    continue GAME;
                } else if (input.equals("q")) {
                    System.out.println("You have exited Gotham City.");
                    break GAME;
                } else {
                    System.out.println("\tInvalid command!");
                }
            }

            if (health > 0) {
                System.out.println("------------------------------");
                System.out.println(" # " + enemy + " was defeated! # ");
                System.out.println(" # You have " + health + " HP left. #");

                if (rand.nextInt(100) < healthPotionDropChance) {
                    numHealthPotions++;
                    System.out.println(" # The " + enemy + " dropped a health potion! # ");
                    System.out.println(" # You now have " + numHealthPotions + " health potion(s). # \n");
                }

                System.out.println("What would you like to do now?");
                System.out.println("1. Continue fighting");
                System.out.println("2. Exit Gotham City");
                System.out.println("3. Quit (Press 'q')");

                String input = in.nextLine();

                while (!input.equals("1") && !input.equals("2") && !input.equals("q")) {
                    System.out.println("Invalid command! Please enter 1, 2, or 'q'.");
                    input = in.nextLine();
                }

                if (input.equals("2")) {
                    System.out.println("You exit Gotham City, victorious and alive!");
                    break;
                } else if (input.equals("q")) {
                    System.out.println("You have exited Gotham City.");
                    break;
                }
            } else {
                System.out.println("You limp out of Gotham City, defeated and broken.");
                break;
            }
        }

        System.out.println("##############################");
        System.out.println("# THANKS FOR PLAYING! #");
        System.out.println("##############################");
        in.close();
    }
}

