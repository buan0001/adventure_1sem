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
        allItems.add(new Food("A delicious apple", "apple", 10));
        allItems.add(new Food("A juicy steak", "steak", 20));
        allItems.add(new Food("A tasty sandwich", "sandwich", 15));
        allItems.add(new Food("A refreshing soda", "soda", 5));
        allItems.add(new Food("A moldy piece of bread", "bread", -2));
        allItems.add(new Food("A rotten tomato", "tomato", -5));
        allItems.add(new Food("A spoiled piece of meat", "meat", -10));
    }
    public Room[] createRooms(Room[] allRooms){
        System.out.println("seventh item:");
        System.out.println(allItems.get(7).getLongName());
        allRooms[0] = new Room("Room 1", allItems.get(0), "entrance to the dungeon", "Entrance" );
        allRooms[1] = new Room("Room 2", allItems.get(1), "a room with a table and a chair", "Table room");
        allRooms[2]= new Room("Room 3", allItems.get(2), "a room with a bed and a chest", "Bedroom");
        allRooms[3]= new Room("Room 4", allItems.get(3), "a room with a fireplace", "Fireplace room");
        allRooms[4]= new Room("Room 5", allItems.get(4), "a room with a desk and a bookshelf", "Study");
        allRooms[5]= new Room("Room 6", allItems.get(5), "a room with a table and a chair", "Table room");
        allRooms[6]= new Room("Room 7", allItems.get(6), "a room with a bed and a chest", "Bedroom");
        allRooms[7]= new Room("Room 8", allItems.get(7), "a room with a fireplace", "Fireplace room");
        allRooms[8]= new Room("Room 9", allItems.get(8), "a LOT of bookshelves full of dusty books", "Library");

        System.out.println(allRooms[7].getItems().getFirst().getShortName());

        allRooms[0].addItem(allItems.get(9));
        //allRooms[0].addItem( "A long, ancient stick", "stick");
        allRooms[0].addItem(allItems.get(10));
        allRooms[1].addItem(allItems.get(11));
        allRooms[1].addItem(allItems.get(12));
        allRooms[2].addItem(allItems.get(13));
        allRooms[2].addItem(allItems.get(14));
        allRooms[3].addItem(allItems.get(15));
        allRooms[3].addItem(allItems.get(16));
        allRooms[4].addItem(allItems.get(17));

        allRooms[0].setEastRoom(allRooms[1]);
        allRooms[0].setSouthRoom(allRooms[3]);

        allRooms[1].setEastRoom(allRooms[2]);

        allRooms[2].setSouthRoom(allRooms[5]);

        allRooms[3].setSouthRoom(allRooms[6]);

        allRooms[4].setSouthRoom(allRooms[7]);

        allRooms[5].setSouthRoom(allRooms[8]);

        allRooms[6].setEastRoom(allRooms[7]);

        allRooms[7].setEastRoom(allRooms[8]);

        return allRooms;
    }
}
