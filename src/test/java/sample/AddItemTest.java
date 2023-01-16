package sample;

import org.junit.Before;
import org.junit.Test;

public class AddItemTest {
    private ShoppingCart cart;

    @Before
    public void createCart(){
        cart = new ShoppingCart();
    }


    @Test(expected = IllegalArgumentException.class)
    public void emptyTitle(){
        cart.addItem("", 10, 10, Item.ItemType.REGULAR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void moreThenMaxTitle(){
        cart.addItem("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy", 10, 10, Item.ItemType.REGULAR);
    }

    @Test()
    public void correctTitle(){
        cart.addItem("Test", 10, 10, Item.ItemType.REGULAR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativePrice(){
        cart.addItem("Test", -1, 10, Item.ItemType.REGULAR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroPrice(){
        cart.addItem("Test", 0, 10, Item.ItemType.REGULAR);
    }

    @Test()
    public void correctPrice(){
        cart.addItem("Test", 500, 10, Item.ItemType.REGULAR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeQuantity(){
        cart.addItem("Test", 500, -1, Item.ItemType.REGULAR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroQuantity(){
        cart.addItem("Test", 500, 0, Item.ItemType.REGULAR);
    }

    @Test()
    public void thousandQuantity(){
        cart.addItem("Test", 500, 1000, Item.ItemType.REGULAR);
    }

    @Test()
    public void correctType(){
        cart.addItem("Test", 500, 500, Item.ItemType.REGULAR);
    }

    @Test()
    public void lessThanHundredItems(){
        for(int i = 1; i < 100; i++){
            cart.addItem("Test", 500, 10, Item.ItemType.REGULAR);
        }
    }

}
