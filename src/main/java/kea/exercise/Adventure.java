package kea.exercise;

public class Adventure {

    private Room[] allRooms = new Room[9];
    private Room currentRoom;
    private UserInterface ui = new UserInterface(this);
    public Adventure(){}

    public void start(){
        createRooms();
        ui.printWelcome();
        ui.startGame();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    private void createRooms(){
        allRooms[0] = new Room("Room 1");
        allRooms[1] = new Room("Room 2");
        allRooms[2]= new Room("Room 3");
        allRooms[3]= new Room("Room 4");
        allRooms[4]= new Room("Room 5");
        allRooms[5]= new Room("Room 6");
        allRooms[6]= new Room("Room 7");
        allRooms[7]= new Room("Room 8");
        allRooms[8]= new Room("Room 9");

        allRooms[0].setEastRoom(allRooms[1]);
        allRooms[0].setSouthRoom(allRooms[3]);

        //allRooms[1].setWestRoom(allRooms[0]);
        allRooms[1].setEastRoom(allRooms[2]);

        //allRooms[2].setWestRoom(allRooms[1]);
        allRooms[2].setSouthRoom(allRooms[5]);

        //allRooms[3].setNorthRoom(allRooms[0]);
        allRooms[3].setSouthRoom(allRooms[6]);

        allRooms[4].setSouthRoom(allRooms[7]);

        //allRooms[5].setNorthRoom(allRooms[2]);
        allRooms[5].setSouthRoom(allRooms[8]);

        //allRooms[6].setNorthRoom(allRooms[3]);
        allRooms[6].setEastRoom(allRooms[7]);

        //allRooms[7].setNorthRoom(allRooms[4]);
        //allRooms[7].setWestRoom(allRooms[6]);
        allRooms[7].setEastRoom(allRooms[8]);

        //allRooms[8].setNorthRoom(allRooms[5]);
        //allRooms[8].setWestRoom(allRooms[7]);

        currentRoom = allRooms[0];
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

    public String getAdjacentRooms() {
        String adjacentRooms = "";
        if(currentRoom.getNorthRoom() != null){
            adjacentRooms += "north ";
        }
        if(currentRoom.getSouthRoom() != null){
            adjacentRooms += "south ";
        }
        if(currentRoom.getEastRoom() != null){
            adjacentRooms += "east ";
        }
        if(currentRoom.getWestRoom() != null){
            adjacentRooms += "west ";
        }

        return adjacentRooms;
    }
}
