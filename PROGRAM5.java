/**
 * Category C - Assignment Problem 5: The Shopping Cart
 * 
 * Scenario:
 * An online store's cart holds the prices of items you're about to buy.
 * 
 * Problem Statement:
 * Design a Cart class that stores item prices internally but only exposes the total and item count - never direct access to the prices themselves.
 * 
 * Requirements:
 * - Store item prices in a private array (assume a fixed maximum number of items).
 * - Provide a method to add an item's price to the cart.
 * - Provide a read-only total (sum of all prices) and a read-only item count - computed on request, not stored separately.
 * - Give the cart a final cart ID, fixed when it's created.
 */
public class PROGRAM5 {

    static class Cart {
        private final String cartId;
        private final double[] itemPrices;
        private int itemCount;

        public Cart(String cartId, int maxItems) {
            this.cartId = cartId;
            this.itemPrices = new double[maxItems];
            this.itemCount = 0;
        }

        public String getCartId() {
            return cartId;
        }

        public void addItem(double price) {
            if (itemCount < itemPrices.length) {
                itemPrices[itemCount] = price;
                itemCount++;
            } else {
                System.out.println("Cart is full.");
            }
        }

        public double getTotal() {
            // Computed on request, not stored separately
            double total = 0;
            for (int i = 0; i < itemCount; i++) {
                total += itemPrices[i];
            }
            return total;
        }

        public int getItemCount() {
            // Read-only item count
            return itemCount;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Testing Shopping Cart ===");
        Cart cart = new Cart("CART-5", 20);
        System.out.println("Cart ID: " + cart.getCartId());

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("cart.getTotal() -> " + (cart.getTotal() % 1 == 0 ? (int)cart.getTotal() : cart.getTotal()));
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());
    }
}