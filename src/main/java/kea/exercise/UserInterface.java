package kea.exercise;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);
    private Adventure adventure;

    public UserInterface(Adventure adventure) {
        this.adventure = adventure;
    }

    public void printWelcome() {
        System.out.println("__________________");
        System.out.println("Welcome to the adventure game!");
        System.out.println("You are in a maze of twisty little passages, all alike.");
        System.out.println("__________________");
        printInstructions();

    }

    private void printInstructions() {
        System.out.println();
        System.out.println("You can move around by typing commands like 'go north', 'go south', 'go east', 'go west'.");
        System.out.println("Alternatively type 'go n', 'go s', 'go e', 'go w'.");
        System.out.println("Type 'look' to see where you are.");
        System.out.println("Type 'inventory' or 'inv' to see the items you're currently carrying. If you only wish to see the short names of the items, type 'inv s'.");
        System.out.println("Type 'quit' to quit the game.");
        System.out.println("Type 'help' to see these instructions again.");
        System.out.println();
    }

    private void printRoomEntryMessage() {
        String msg = adventure.getCurrentRoom().isVisited() ? adventure.getCurrentRoom().getShortDescription() : adventure.getCurrentRoom().getLongDescription();
        System.out.println("You are in " + msg);
        printGroundItems();
        System.out.println("Where do you want to go?");
    }

    private void printGroundItems() {
        String msg = adventure.getRoomItemNames();
        if (Objects.equals(msg, "")){
            System.out.println("There are no items in this room");
        }
        else {
            System.out.println("These items are on the ground: ");
            System.out.println(msg);
        }
    }

    private void printCarriedItems(){
        printCarriedItems("l");
    }
    private void printCarriedItems(String str) {
        String msg = adventure.getCarriedItemNames(str);
        if (msg == null){
            System.out.println("You are not carrying any items");
        }
        else {
            System.out.println("These items are in your inventory: ");
            System.out.println(msg);
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
            boolean isEat = command.length() >2 && command.substring(0, 3).equalsIgnoreCase("eat");
            boolean isShortInventory = command.length() > 4 && command.substring(0,3).equalsIgnoreCase("inv") && command.substring(3,4).equalsIgnoreCase(" ");

            if (isTake) {
                if (command.length() < 5) {
                    System.out.println("You need to specify what you want to take");
                    continue;
                }
                String itemToPickUp = command.substring(5);
                System.out.println("attempting to take item: " + itemToPickUp);
                Item takenItem = adventure.takeItem(itemToPickUp);
                if (takenItem != null) {
                    System.out.println("You picked up: " + takenItem.getLongName());
                }
                else {
                    System.out.println("There is no " + itemToPickUp + " here.");
                }
                continue;
            }
            else if (isDrop) {
                if (command.length() < 5) {
                    System.out.println("You need to specify what you want to drop");
                    continue;
                }
                String itemToDrop = command.substring(5);
                System.out.println("attempting to take item: " + itemToDrop);
                Item droppedItem = adventure.dropItem(itemToDrop);
                if (droppedItem != null) {
                    System.out.println("You dropped the " + droppedItem.getLongName());
                }
                else {
                    System.out.println("You are not carrying any item called " + itemToDrop);
                }

                continue;
            }
            else if (isEat) {
                if (command.length() < 4) {
                    System.out.println("You need to specify what you want to eat");
                    continue;
                }
                String itemToEat = command.substring(4);
                System.out.println("attempting to eat item: " + itemToEat);
                message = adventure.eatItem(itemToEat);
                System.out.println(message);
                if (message == null) {
                    System.out.println("This piece of food doesn't look nice. It might hurt you in the process. Do you want to eat it anyway?");
                    System.out.println("answer with 'Y'/'N'");
                    String answer = scanner.nextLine();
                    System.out.println("answer " + answer);
                    if (answer.equalsIgnoreCase("y")) {
                        System.out.println("Yuck!");
                        System.out.println(adventure.reallyEat(itemToEat));
                    }
                    else {
                        System.out.println("Perhaps a wise choice...");
                    }
                }

                continue;
            }
            else if (isShortInventory) {

                System.out.println("printing short inventory");
                printCarriedItems("s");
//                System.out.println(adventure.getCarriedItemNames(command.substring(4))) ;
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
                    System.out.println("printing INVENTORY");
                    printCarriedItems();
                    break;



                default:
                    System.out.println("I don't understand that command.");
            }

        }
    }


}
