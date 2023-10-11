package ui;

import model.CookingInstructions;
import model.Recipe;
import model.RecipeBook;

import java.util.Locale;
import java.util.Scanner;

public class DigitalRecipeBookApp {

    private Scanner input;
    private RecipeBook recipeBook;

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
        recipeBook = new RecipeBook();
    }

    public void displayMenu() {
        System.out.println("Welcome To The Digital Recipe Book!");
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Add a Recipe");
        System.out.println("\tr -> Remove a Recipe");
        System.out.println("\tv -> View all Recipes");
        System.out.println("\tq -> Quit");
    }

    public void processCommand(String command) {
        if (command.equals("a")) {
            addRecipe();
        } else if (command.equals("r")) {
            removeRecipe();
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
            System.out.println("Y/N");
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
        addCookingInstructions(r1);
    }

    public void addCookingInstructions(Recipe r) {
        System.out.println("Would you like to add a Cooking Instruction?");
        System.out.println("Y//N");
        String command = input.next();
        command = command.toLowerCase(Locale.ROOT);
        int i = 0;
        if (command.equals("y")) {
            System.out.println("Please Enter the Cooking Instruction!");
            String instruction = input.next();
            i++;
            r.addCookingInstruction(instruction, i);
        } else {
            recipeBook.addRecipe(r);
            displayMenu();
        }
    }

    public void removeRecipe() {
        System.out.println("Enter the Name of the Recipe You Would Like to Remove!");
        String name = input.next();
        recipeBook.removeRecipe(name);
    }


}
