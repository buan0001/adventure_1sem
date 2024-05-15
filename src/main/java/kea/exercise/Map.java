package kea.exercise;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<Item> allItems = new ArrayList<>();
    public void createItems() {
        allItems.add(new Item("A long, ancient stick", "stick"));
        allItems.add(new Item("A horrendous smelling bottle", "bottle"));
        allItems.add(new Item("A jar of dirt", "jar"));
        allItems.add(new Item("A shiny gold coin", "coin"));
        allItems.add(new Item("Five confused ants", "ants"));
        allItems.add(new Item("Apple with marginal magical capabilities", "apple"));
        allItems.add(new Item("Flaming red ruby", "ruby"));
        allItems.add(new Item("A dragons bones", "bones"));
        allItems.add(new Item("A soft piece of moss", "moss"));
        allItems.add(new Item("A glimmering starfruit", "starfruit"));
        allItems.add(new Item("Six unhappy worms", "worms"));
    }
    public Room[] createRooms(Room[] allRooms){
        allRooms[0] = new Room("Room 1", allItems.get(0), "Entrance to the dungeon", "Entrance");
        allRooms[1] = new Room("Room 2", allItems.get(1), "A room with a table and a chair", "Table room");
        allRooms[2]= new Room("Room 3", allItems.get(2), "A room with a bed and a chest", "Bedroom");
        allRooms[3]= new Room("Room 4", allItems.get(3), "A room with a fireplace", "Fireplace room");
        allRooms[4]= new Room("Room 5", allItems.get(4), "A room with a desk and a bookshelf", "Library");
        allRooms[5]= new Room("Room 6", allItems.get(5), "A room with a table and a chair", "Table room");
        allRooms[6]= new Room("Room 7", allItems.get(6), "A room with a bed and a chest", "Bedroom");
        allRooms[7]= new Room("Room 8", allItems.get(7), "A room with a fireplace", "Fireplace room");
        allRooms[8]= new Room("Room 9", allItems.get(8), "A room with a desk and a bookshelf", "Library");
//
//        allRooms[1] = new Room("Room 2");
//        allRooms[2]= new Room("Room 3");
//        allRooms[3]= new Room("Room 4");
//        allRooms[4]= new Room("Room 5");
//        allRooms[5]= new Room("Room 6");
//        allRooms[6]= new Room("Room 7");
//        allRooms[7]= new Room("Room 8");
//        allRooms[8]= new Room("Room 9");

        allRooms[0].addItem(allItems.get(9));
        allRooms[0].addItem(allItems.get(10));

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
