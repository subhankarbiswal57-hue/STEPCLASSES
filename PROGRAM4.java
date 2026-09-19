/**
 * Category C - Assignment Problem 4: The Traffic Light
 * 
 * Scenario:
 * A traffic light cycles through red, green, and yellow, in order.
 * 
 * Problem Statement:
 * Design a TrafficLight class where the color can only move forward through its cycle, never be set to an arbitrary color directly.
 * 
 * Requirements:
 * - The current color must be private, changed only by a next() method that moves red -> green -> yellow -> red, in that order.
 * - There must be no method that sets the color directly to any value.
 * - Provide a read-only way to check the current color.
 * - Give the light a final ID, fixed when it's created.
 */
public class PROGRAM4 {

    static class TrafficLight {
        private final String id;
        private String color;

        public TrafficLight(String id) {
            this.id = id;
            this.color = "RED"; // A new light starts on red
        }

        public String getId() {
            return id;
        }

        public String getColor() {
            return color;
        }

        public String next() {
            if ("RED".equals(color)) {
                color = "GREEN";
            } else if ("GREEN".equals(color)) {
                color = "YELLOW";
            } else if ("YELLOW".equals(color)) {
                color = "RED";
            }
            return color;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Testing TrafficLight ===");
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("t.getColor() -> \"" + t.getColor() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
    }
}
