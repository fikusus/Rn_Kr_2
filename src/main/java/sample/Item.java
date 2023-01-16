package sample;

public   class Item{
    public enum ItemType { NEW, REGULAR, SECOND_FREE, SALE };

    String title;
    double price;
    int quantity;
    ItemType type;
}
