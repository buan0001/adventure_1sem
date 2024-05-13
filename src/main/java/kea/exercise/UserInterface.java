package kea.exercise;

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
        System.out.println("Type 'quit' to quit the game.");
        System.out.println("Type 'help' to see these instructions again.");
    }

    public void startGame() {
        while (true) {
            System.out.println("You are in " + adventure.getCurrentRoom().getName());
            System.out.println("Where do you want to go?");
            //System.out.println("Valid directions are: " + adventure.getAdjacentRooms());
            String command = scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Goodbye!");
                break;
            }

            switch (command) {
                case "go north",
                    "go n":
                    adventure.moveNorth();
                    break;
                case "go south", "go s":
                    adventure.moveSouth();
                    break;
                case "go east", "go e":
                    adventure.moveEast();
                    break;
                case "go west", "go w":
                    adventure.moveWest();
                    break;
                case "help":
                    printInstructions();
                    break;
                    case "look":
                    System.out.println("You are in " + adventure.getCurrentRoom().getName());

                default:
                    System.out.println("I don't understand that command.");
            }

        }
    }
}
