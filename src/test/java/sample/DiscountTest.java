package sample;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.runners.*;
import org.junit.runner.*;
import sample.Item;
import sample.ShoppingCart;

@RunWith(Parameterized.class)
public class DiscountTest {
    private static final int[] Q_VALUES = {1, 9, 10, 19, 99, 100, 900};
    private static final Item.ItemType[] T_VALUES = {
            Item.ItemType.NEW,
            Item.ItemType.REGULAR,
            Item.ItemType.SALE,
            Item.ItemType.SECOND_FREE
    };
    private static final int[][] D_VALUES =
            {
                    {0},
                    {0, 0, 1, 1, 9, 10, 80},
                    {70, 70, 71, 71, 79, 80, 80},
                    {0, 50, 51, 51, 59, 60, 80}
            };

    @Parameterized.Parameters
    @SuppressWarnings("unchecked")
    public static Collection getTypeQuantityPairs() {
        Collection pairs = new ArrayList();
        for (int q = 0; q < Q_VALUES.length; q++)
            for (int t = 0; t < T_VALUES.length; t++)
                pairs.add(new Object[]{
                        T_VALUES[t],
                        Q_VALUES[q],
                        (D_VALUES[t].length > q)
                                ? D_VALUES[t][q]
                                : D_VALUES[t][D_VALUES[t].length - 1]
                });
        return pairs;
    }

    private Item.ItemType _type;
    private int _quantity;
    private int _discount;

    public DiscountTest(Item.ItemType type, int quantity, int discount) {
        _type = type;
        _quantity = quantity;
        _discount = discount;
    }

    @Test
    public void discountTest() {
        assertEquals("type: " + _type + ", quantity: " + _quantity,
                _discount,
                ShoppingCart.calculateDiscount(
                        _type, _quantity));
    }
}