package kea.exercise;

public class Adventure {

    private Room[] allRooms = new Room[9];

    private Player player;
    private final UserInterface ui = new UserInterface(this);
    private final Map map = new Map();
    public Adventure(){}

    public void start(){
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

    public void moveEast() {
        player.moveEast();
    }

    public void moveNorth() {
        player.moveNorth();
    }

    public void moveSouth() {
        player.moveSouth();
    }

    public void moveWest() {
        player.moveWest();
    }
}
