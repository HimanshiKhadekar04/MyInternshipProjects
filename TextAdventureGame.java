import java.util.Scanner;

public class TextAdventureGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Text Adventure Game!");
        System.out.println("You find yourself standing at a crossroad.");
        System.out.println("Do you want to go left or right?");

        String choice1 = scanner.nextLine();

        if (choice1.equalsIgnoreCase("left")) {
            System.out.println("You encounter a spooky forest.");
            System.out.println("Do you want to enter the forest or go back?");
            String choice2 = scanner.nextLine();
            if (choice2.equalsIgnoreCase("enter")) {
                System.out.println("You find a treasure chest hidden deep within the forest. You win!");
            } else {
                System.out.println("You decide to go back and continue your journey.");
            }
        } else if (choice1.equalsIgnoreCase("right")) {
            System.out.println("You come across a raging river.");
            System.out.println("Do you want to swim across or find another way?");
            String choice3 = scanner.nextLine();
            if (choice3.equalsIgnoreCase("swim")) {
                System.out.println("You attempt to swim across but get swept away by the current. Game Over!");
            } else {
                System.out.println("You search for a bridge and successfully cross the river. You win!");
            }
        } else {
            System.out.println("Invalid input. Please choose 'left' or 'right'.");
        }
    }
}

