package kea.exercise;

public class Map {
    public Room[] createRooms(Room[] allRooms){
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

        return allRooms;
    }
}
