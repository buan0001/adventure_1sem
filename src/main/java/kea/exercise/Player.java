package kea.exercise;

import kea.exercise.exceptions.ItemNotFoodException;
import kea.exercise.exceptions.ItemNotFoundException;

public class Player extends ItemCarrier {
    private Room currentRoom;

    private int health = 100;
    public Player (Room initialRoom) {
        setCurrentRoom(initialRoom);
    }


    public Item takeItem(String itemName) {
        Item item = currentRoom.findItem(itemName);
        if (item != null) {
            items.add(item);
            currentRoom.removeItem(item);
            return item;
            //return "You picked up " + item.getLongName();
        } else {
            return null;
            //return "There is no " + itemName + " here.";
        }
    }

    public Item dropItem(String itemName) {
        Item item = findItem(itemName);
        if (item != null) {
            items.remove(item);
            currentRoom.addItem(item);
            return item;
            //return "You dropped the " + item.getLongName();
        } else {
            return null;
            //return "You are not carrying any item called " + itemName;
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room newRoom){
        this.currentRoom = newRoom;
        newRoom.setVisited(true);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean moveNorth() {
        if(currentRoom.getNorthRoom() != null){
            setCurrentRoom(currentRoom.getNorthRoom());
            return true;
            //return "You moved north.";
        } else {
            return false;
        }
    }

    public boolean moveSouth() {
        if(currentRoom.getSouthRoom() != null){
            setCurrentRoom(currentRoom.getSouthRoom());
            return true;
            //return "You moved south.";
        } else {
            return false;
        }
    }

    public boolean moveEast() {
        if(currentRoom.getEastRoom() != null){
            setCurrentRoom(currentRoom.getEastRoom());
            return true;
            //return "You moved east.";
        } else {
            return false;
        }
    }

    public boolean moveWest() {
        if(currentRoom.getWestRoom() != null){
            setCurrentRoom(currentRoom.getWestRoom());
            return true;
            //return "You moved west.";
        } else {
            return false;
        }
    }

    public Integer attemptToEatItem(String itemToEat) {
        Item item = findItem(itemToEat);
        if (item == null) {
            throw new ItemNotFoundException();
        }
        else if (!(item instanceof Food food)) {
            throw new ItemNotFoodException();
        }
        else {
            if (food.getHealing() < 0) {
                return null;
            }
            else {
                return reallyEat(food);
            }

        }
    }

    private void calculateHealth(Food itemToEat) {
        this.health += itemToEat.getHealing();
    }

    public int reallyEat(String itemToEat) {
        Food food = (Food) findItem(itemToEat);
        return reallyEat(food);
    }
    public int reallyEat(Food foodToEat) {
        calculateHealth(foodToEat);
        items.remove(foodToEat);
        return health;
        //return "You eat the " + foodToEat.getShortName() + ". Your health is now " + health;
    }
}
