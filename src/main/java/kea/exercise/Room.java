package kea.exercise;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private Room northRoom = null;
    private Room southRoom = null;
    private Room eastRoom = null;
    private Room westRoom = null;
    private String longDescription;
    private String shortDescription;
    private boolean visited = false;

    private List<Item> items = new ArrayList<>();


    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void addItem(String itemName, String itemDescription) {
        addItem(new Item(itemName, itemDescription));
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getShortDescriptio() {
        return shortDescription;
    }

    public void setShortDescriptio(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Room(String name) {
        this.name = name;
    }

    public Room(String name, Item item, String longDescription, String shortDescription) {
        this.name = name;
        this.items.add(item);
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getNorthRoom() {
        return northRoom;
    }

    public void setNorthRoom(Room northRoom) {

        this.northRoom = northRoom;
        if (northRoom.getSouthRoom() == null) {
            northRoom.setSouthRoom(this);
        }
    }

    public Room getSouthRoom() {
        return southRoom;
    }

    public void setSouthRoom(Room southRoom) {
        this.southRoom = southRoom;
        if (southRoom.getNorthRoom() == null) {
            southRoom.setNorthRoom(this);
        }
    }

    public Room getEastRoom() {
        return eastRoom;
    }

    public void setEastRoom(Room eastRoom) {
        this.eastRoom = eastRoom;
        if (eastRoom.getWestRoom() == null) {
        eastRoom.setWestRoom(this);}
    }

    public Room getWestRoom() {
        return westRoom;
    }

    public void setWestRoom(Room westRoom) {
        this.westRoom = westRoom;
        if (westRoom.getEastRoom() == null) {
        westRoom.setEastRoom(this);}
    }

    public Item findItem(String itemName) {
        for (Item item : items) {
            if (item.getShortName().equals(itemName) || item.getLongName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}
