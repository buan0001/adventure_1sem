package kea.exercise;

import java.util.ArrayList;
import java.util.List;

public interface ItemCarrier {
    List<Item> items = new ArrayList<>();

    default Item findItem(String itemName) {
        for (Item item : items) {
            if (item.getShortName().equals(itemName) || item.getLongName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    default List<Item> getItems( ){
        return items;
    }

}
