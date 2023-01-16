package sample;

public class Main {
    public static void main(String[] args){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 0.99, 5, Item.ItemType.NEW);
        cart.addItem("Banana", 20.00, 4, Item.ItemType.SECOND_FREE);
        cart.addItem("A long piece of toilet paper", 17.20, 1, Item.ItemType.SALE);
        cart.addItem("Nails", 2.00, 500, Item.ItemType.REGULAR);
        System.out.println(cart.formatTicket());
    }
}
