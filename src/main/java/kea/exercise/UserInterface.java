package kea.exercise;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);
    private Adventure adventure;

    public UserInterface(Adventure adventure) {
        this.adventure = adventure;
    }

    public void printWelcome() {
        System.out.println("Welcome to the adventure game!");
        System.out.println("You are in a maze of twisty little passages, all alike.");
        printInstructions();

    }

    private void printInstructions() {
        System.out.println("You can move around by typing commands like 'go north', 'go south', 'go east', 'go west'.");
        System.out.println("Alternatively type 'go n', 'go s', 'go e', 'go w'.");
        System.out.println("Type 'look' to see where you are.");
        System.out.println("Type 'inventory' or 'inv' to see the items you're currently carrying ");
        System.out.println("Type 'quit' to quit the game.");
        System.out.println("Type 'help' to see these instructions again.");
    }

    private void printRoomEntryMessage() {
        System.out.println("You are in " + adventure.getCurrentRoom().getLongDescription());
        printGroundItems();
        System.out.println("Where do you want to go?");
    }

    private void printGroundItems() {
        if (!adventure.getCurrentRoom().getItems().isEmpty()) {
            System.out.println("These items are on the ground: ");
            for (Item item : adventure.getCurrentRoom().getItems()) {
                System.out.println(item.getLongName());
            }
        }
        else {
            System.out.println("There are no items in this room");
        }
    }

    private void printCarriedItems(List<Item> carriedItems) {
        if (!carriedItems.isEmpty()) {
            System.out.println("These items are in your inventory: ");
            for (Item item : carriedItems) {
                System.out.println(item.getLongName());
            }
        }
        else {
            System.out.println("You are not carrying any items right now");
        }
    }

    private void printFailedToMove() {
        System.out.println("You can't move that direction");
    }

    public void startGame() {
        printRoomEntryMessage();
        while (true) {
            String message;

            //System.out.println("Valid directions are: " + adventure.getAdjacentRooms());
            String command = scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Goodbye!");
                break;
            }

            boolean isTake = command.length() >3 &&  command.substring(0, 4).equalsIgnoreCase("take");
            boolean isDrop = command.length() >3 && command.substring(0, 4).equalsIgnoreCase("drop");
            if (isTake) {
                System.out.println("take command:");
                System.out.println(command);
                String itemToPickUp = command.substring(5);
                System.out.println("attempting to take item: " + itemToPickUp);
                message = adventure.takeItem(itemToPickUp);
                System.out.println(message);
                continue;
            }
            else if (isDrop) {
                System.out.println("drop command:");
                System.out.println(command);
                String itemToDrop = command.substring(5);
                System.out.println("attempting to take item: " + itemToDrop);
                message = adventure.dropItem(itemToDrop);
                System.out.println(message);
                continue;
            }

            switch (command) {
                case "go north",
                        "go n":
                    message = adventure.moveNorth();
                    if (message != null) {
                        System.out.println(message);
                        printRoomEntryMessage();
                    } else {
                        printFailedToMove();
                    }
                    break;
                case "go south", "go s":
                    message = adventure.moveSouth();
                    if (message != null) {
                        System.out.println(message);
                        printRoomEntryMessage();
                    } else {
                        printFailedToMove();
                    }
                    break;
                case "go east", "go e":
                    message = adventure.moveEast();
                    if (message != null) {
                        System.out.println(message);
                        printRoomEntryMessage();
                    } else {
                        printFailedToMove();
                    }
                    break;
                case "go west", "go w":
                    message = adventure.moveWest();
                    if (message != null) {
                        System.out.println(message);
                        printRoomEntryMessage();
                    } else {
                        printFailedToMove();
                    }
                    break;

                case "help":
                    printInstructions();
                    break;
                case "look":
                    System.out.println("You are in " + adventure.getCurrentRoom().getName());
                    printGroundItems();
                    break;

                case "inventory", "inv":
                    printCarriedItems(adventure.getCarriedItems()) ;
                    break;
                default:
                    System.out.println("I don't understand that command.");
            }

        }
    }


}
