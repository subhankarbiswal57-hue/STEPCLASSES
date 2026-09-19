/**
 * Category C - Assignment Problem 1: The Health Bar
 * 
 * Scenario:
 * A game character has health that changes during battle.
 * 
 * Problem Statement:
 * Design a Character class where health can never drop below 0 or rise above its maximum, and can't be set directly from outside.
 * 
 * Requirements:
 * - Health must be private, changed only through takeDamage(int amount) and heal(int amount).
 * - Health must never go below 0 (extra damage is just wasted) or above the maximum (extra healing is just wasted).
 * - The maximum health must be final, fixed when the character is created.
 * - Provide a read-only way to check current health - no setter for it.
 */
public class PROGRAM1 {

    static class Character {
        private final int maxHealth;
        private int health;

        public Character(int maxHealth) {
            this.maxHealth = maxHealth;
            this.health = maxHealth;
        }

        public int getMaxHealth() {
            return maxHealth;
        }

        public int getHealth() {
            return health;
        }

        public void takeDamage(int amount) {
            if (amount < 0) return;
            health -= amount;
            if (health < 0) {
                health = 0;
            }
        }

        public void heal(int amount) {
            if (amount < 0) return;
            health += amount;
            if (health > maxHealth) {
                health = maxHealth;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Testing Character Health Bar ===");
        Character c = new Character(100);
        System.out.println("Initial health = " + c.getHealth());

        c.takeDamage(30);
        System.out.println("c.takeDamage(30) -> health = " + c.getHealth());

        c.heal(50);
        System.out.println("c.heal(50) -> health = " + c.getHealth() + " (capped)");

        c.takeDamage(150);
        System.out.println("c.takeDamage(150) -> health = " + c.getHealth() + " (floored)");
    }
}