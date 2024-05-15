package kea.exercise;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Room currentRoom;

    private List<Item> carriedItems = new ArrayList<>();

    public Player (Room initialRoom) {
        currentRoom = initialRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public String toString() {
        return carriedItems.toString();
    }

    public List<Item> getCarriedItems() {
        return carriedItems;
    }

    public void setCarriedItems(List<Item> carriedItems) {
        this.carriedItems = carriedItems;
    }

    public String takeItem(String itemName) {
        Item item = currentRoom.findItem(itemName);
        if (item != null) {
            carriedItems.add(item);
            currentRoom.removeItem(item);
            return "You picked up the " + item.getLongName();
        } else {
            return "There is no " + itemName + " here.";
        }
    }

    public String dropItem(String itemName) {
        Item item = findItem(itemName);
        if (item != null) {
            carriedItems.remove(item);
            currentRoom.addItem(item);
            return "You dropped the " + item.getLongName();
        } else {
            return "You are not carrying any item called " + itemName;
        }
    }

    private Item findItem(String itemName) {
        for (Item item : carriedItems) {
            if (item.getShortName().equals(itemName) || item.getLongName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void removeItem(Item item) {
        carriedItems.remove(item);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public String moveNorth() {
        if(currentRoom.getNorthRoom() != null){
            currentRoom = currentRoom.getNorthRoom();
            return "You moved north.";
        } else {
            return null;
        }
    }

    public String moveSouth() {
        if(currentRoom.getSouthRoom() != null){
            currentRoom = currentRoom.getSouthRoom();
            return "You moved south.";
        } else {
            return null;
        }
    }

    public String moveEast() {
        if(currentRoom.getEastRoom() != null){
            currentRoom = currentRoom.getEastRoom();
            return "You moved east.";
        } else {
            return null;
        }
    }

    public String moveWest() {
        if(currentRoom.getWestRoom() != null){
            currentRoom = currentRoom.getWestRoom();
            return "You moved west.";
        } else {
            return null;
        }
    }
}
