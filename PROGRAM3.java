/**
 * Category C - Practice Problem 3: The Nickname Tag
 * 
 * Scenario:
 * A chat app shows a friendly short nickname instead of your full name.
 * 
 * Problem Statement:
 * Create an immutable NameTag class that takes a full name once and builds a nickname from it - first name plus the last name's initial.
 * 
 * Requirements:
 * - Take one full name string in the constructor (e.g., "Maria Gomez") and split it into first and last name.
 * - Store whatever you keep as final fields - nothing about the name should be changeable after creation.
 * - Provide a method that returns the nickname (e.g., "Maria G."), built from the stored parts.
 * - Assume the full name always has exactly one first name and one last name, separated by a single space.
 */
public class PROGRAM3 {

    static final class NameTag {
        private final String firstName;
        private final String lastNameInitial;

        public NameTag(String fullName) {
            String[] parts = fullName.split(" ");
            this.firstName = parts[0];
            this.lastNameInitial = parts[1].substring(0, 1) + ".";
        }

        public String getNickname() {
            return firstName + " " + lastNameInitial;
        }

        public String getFirstName() {
            return firstName;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Testing NameTag ===");
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("tag.getNickname() -> " + tag.getNickname());

        NameTag tag2 = new NameTag("John Doe");
        System.out.println("tag2.getNickname() -> " + tag2.getNickname());
    }
}
