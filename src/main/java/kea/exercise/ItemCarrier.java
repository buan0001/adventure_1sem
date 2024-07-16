package kea.exercise;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

abstract class ItemCarrier {
    List<Item> items = new ArrayList<>();

    protected Item findItem(String itemName) {
        for (Item item : items) {
            if (item.getShortName().equalsIgnoreCase(itemName) || item.getLongName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    protected List<Item> getItems() {
        return this.items;
    }

    protected void removeItem(Item item) {
        items.remove(item);
    }

    protected void addItem(Item item) {
        this.items.add(item);
    }

    void addItem(String itemName, String itemDescription) {
        addItem(new Item(itemName, itemDescription));
    }

    protected String getItemNames() {
        return getItemNames("l");
    }

    protected String getItemNames(String shortOrLong) {
        StringBuilder str = new StringBuilder();
        for (Item item : items) {
            if (items.isEmpty()) {
                return null;
            }
            String string = shortOrLong.equalsIgnoreCase("s") ? item.getShortName() : item.getLongName();

            int index = items.indexOf(item);
            if (index == 0 && items.size() > 2) {
                str.append(string).append(", ");
            } else if (index == 0 && items.size() == 2) {
                str.append(string).append(" and ");
            } else if (items.getLast() == items.getFirst()) {
                str.append(string);
            } else if (items.indexOf(item) == items.size() - 1) {
                str.append(string.toLowerCase());
                break;
            } else if (items.indexOf(item) == items.size() - 2) {
                str.append(string.toLowerCase()).append(" and ");
            } else {
                str.append(string.toLowerCase()).append(", ");
            }

        }
        return str.toString();
    }

}
