package ui;

import model.Recipe;

import java.util.Locale;
import java.util.Scanner;

public class DigitalRecipeBookApp {

    private Scanner input;

    public DigitalRecipeBookApp() {
        init();
        runApp();
    }

    public void runApp() {
        boolean keepGoing = true;
        String command = null;

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase(Locale.ROOT);

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nGoodbye!");
    }

    public void init() {
        input = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome To The Digital Recipe Book!");
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Add a Recipe");
        System.out.println("\tr -> Remove a Recipe");
        System.out.println("\te -> Edit a Recipe");
        System.out.println("\tv -> View all Recipes");
        System.out.println("\tq -> Quit");
    }

    public void processCommand(String command) {
        if (command.equals("a")) {
            addRecipe();
        } else if (command.equals("r")) {
            //removeRecipe();
        } else if (command.equals("e")) {
            //editRecipe();
        } else if (command.equals("v")) {
            //viewRecipe();
        }
    }

    public void addRecipe() {
        System.out.println("Enter the Name of Your Dish!");
        String name = input.next();
        System.out.println("Sounds Great!");
        System.out.println("Enter the Cuisine of This Dish!");
        String cuisine = input.next();
        Recipe r1 = new Recipe(name, cuisine);
        addIngredient(r1);
    }

    public void addIngredient(Recipe r1) {
        boolean keepGoing1 = false;

        do {
            System.out.println("Would You Like to Add the Required Ingredients?");
            System.out.println("Y/N?");
            String command = input.next();
            command = command.toLowerCase(Locale.ROOT);
            if (command.equals("y")) {
                keepGoing1 = true;
            } else if (command.equals("n")) {
                keepGoing1 = false;
            } else {
                System.out.println("Didn't recognize that!");
                addRecipe();
            }
            if (keepGoing1) {
                System.out.println("Enter the Name of the ingredient!");
                String ingredient = input.next();
                r1.addIngredient(ingredient);
            }
        } while (keepGoing1);
    }
}
