package kea.exercise;

public class Player {
    private Room currentRoom;

    private String[] inventory;

    public Player (Room initialRoom) {
        currentRoom = initialRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void moveNorth() {
        if(currentRoom.getNorthRoom() != null){
            currentRoom = currentRoom.getNorthRoom();
        } else {
            System.out.println("You can't go that way.");
        }
    }

    public void moveSouth() {
        if(currentRoom.getSouthRoom() != null){
            currentRoom = currentRoom.getSouthRoom();
        } else {
            System.out.println("You can't go that way.");
        }
    }

    public void moveEast() {
        if(currentRoom.getEastRoom() != null){
            currentRoom = currentRoom.getEastRoom();
        } else {
            System.out.println("You can't go that way.");
        }
    }

    public void moveWest() {
        if(currentRoom.getWestRoom() != null){
            currentRoom = currentRoom.getWestRoom();
        } else {
            System.out.println("You can't go that way.");
        }
    }
}
