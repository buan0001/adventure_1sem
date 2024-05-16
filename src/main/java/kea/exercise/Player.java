package kea.exercise;

public class Player extends ItemCarrier {
    private Room currentRoom;

    private int health = 50;
    public Player (Room initialRoom) {
        setCurrentRoom(initialRoom);
    }


    public String takeItem(String itemName) {
        Item item = currentRoom.findItem(itemName);
        if (item != null) {
            items.add(item);
            currentRoom.removeItem(item);
            return "You picked up " + item.getLongName();
        } else {
            return "There is no " + itemName + " here.";
        }
    }

    public String dropItem(String itemName) {
        Item item = findItem(itemName);
        if (item != null) {
            items.remove(item);
            currentRoom.addItem(item);
            return "You dropped the " + item.getLongName();
        } else {
            return "You are not carrying any item called " + itemName;
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

    public String moveNorth() {
        if(currentRoom.getNorthRoom() != null){
            setCurrentRoom(currentRoom.getNorthRoom());
            return "You moved north.";
        } else {
            return null;
        }
    }

    public String moveSouth() {
        if(currentRoom.getSouthRoom() != null){
            setCurrentRoom(currentRoom.getSouthRoom());
            return "You moved south.";
        } else {
            return null;
        }
    }

    public String moveEast() {
        if(currentRoom.getEastRoom() != null){
            setCurrentRoom(currentRoom.getEastRoom());
            return "You moved east.";
        } else {
            return null;
        }
    }

    public String moveWest() {
        if(currentRoom.getWestRoom() != null){
            setCurrentRoom(currentRoom.getWestRoom());
            return "You moved west.";
        } else {
            return null;
        }
    }

    public String attemptToEatItem(String itemToEat) {
        Item item = findItem(itemToEat);
        if (item == null) {
            return "You are not carrying any item called " + itemToEat;
        }
        else if (!(item instanceof Food)) {
            return "You can't eat that - it's not a food";
        }
        else {
            Food food = (Food) item;
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

    public String reallyEat(String itemToEat) {
        Food food = (Food) findItem(itemToEat);
        return reallyEat(food);
    }
    public String reallyEat(Food foodToEat) {
        calculateHealth(foodToEat);
        items.remove(foodToEat);
        return "You eat the " + foodToEat.getShortName() + ". Your health is now " + health;
    }
}
