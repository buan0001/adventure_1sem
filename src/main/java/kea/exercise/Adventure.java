package kea.exercise;

import java.util.List;

public class Adventure {

    private Room[] allRooms = new Room[9];

    private Player player;
    private final UserInterface ui = new UserInterface(this);
    private final Map map = new Map();
    public Adventure(){}

    public void start(){
        map.createItems();
        allRooms = map.createRooms(allRooms);
        player = new Player(allRooms[0]);
        ui.printWelcome();
        ui.startGame();
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }


//    public String getAdjacentRooms() {
//        String adjacentRooms = "";
//        if(currentRoom.getNorthRoom() != null){
//            adjacentRooms += "north ";
//        }
//        if(currentRoom.getSouthRoom() != null){
//            adjacentRooms += "south ";
//        }
//        if(currentRoom.getEastRoom() != null){
//            adjacentRooms += "east ";
//        }
//        if(currentRoom.getWestRoom() != null){
//            adjacentRooms += "west ";
//        }
//
//        return adjacentRooms;
//    }

    public String moveEast() {
       return player.moveEast();
    }

    public String moveNorth() {
        return player.moveNorth();
    }

    public String moveSouth() {
        return player.moveSouth();
    }

    public String moveWest() {
        return player.moveWest();
    }

    public String takeItem(String command) {
        return player.takeItem(command);
    }

    public String dropItem(String itemToDrop) {
        return player.dropItem(itemToDrop);
    }

    public List<Item> getCarriedItems() {
        return player.getItems();
    }

    public String getCarriedItemNames(String shortOrLong){
        return player.getItemNames(shortOrLong);
    }

    public String getCarriedItemNames(){
        return player.getItemNames();
    }

    public String getRoomItemNames(){
        return player.getCurrentRoom().getItemNames();
    }

    public String eatItem(String itemToEat) {
        return player.attemptToEatItem(itemToEat);
    }

    public String reallyEat(String itemToEat) {
        return player.reallyEat(itemToEat);
    }
}
