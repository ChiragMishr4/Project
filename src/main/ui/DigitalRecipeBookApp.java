package ui;

import model.CookingInstructions;
import model.Recipe;
import model.RecipeBook;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

//Digital Recipe Book Application.
public class DigitalRecipeBookApp {

    private Scanner input;
    private RecipeBook recipeBook;
    private int idGen = 0;
    private boolean keepGoing2 = false;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String json_book = "./data/recipes.json";

    //EFFECTS :  runs DigitalRecipeBookApp.
    public DigitalRecipeBookApp() {
        init();
        runApp();
    }

    //MODIFIES : this
    //EFFECTS : processes user input
    public void runApp() {
        boolean keepGoing = true;
        String command = null;

        while (keepGoing) {
            displayMenu();
            command = input.nextLine();
            command = command.toLowerCase(Locale.ROOT);

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nGoodbye!");
    }

    //MODIFIES : this
    //EFFECTS : initializes fields
    public void init() {
        input = new Scanner(System.in);
        recipeBook = new RecipeBook();
        jsonWriter = new JsonWriter(json_book);
        jsonReader = new JsonReader(json_book);
    }

    // EFFECTS: displays menu of options to user
    public void displayMenu() {
        System.out.println("Welcome To The Digital Recipe Book!");
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Add a Recipe");
        System.out.println("\tr -> Remove a Recipe");
        System.out.println("\tv -> View all Recipes");
        System.out.println("\ts -> Save Recipes");
        System.out.println("\tl -> Load Recipes");
        System.out.println("\tq -> Quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    public void processCommand(String command) {
        if (command.equals("a")) {
            addRecipe();
        } else if (command.equals("r")) {
            removeRecipe();
        } else if (command.equals("v")) {
            viewRecipes();
        } else if (command.equals("s")) {
            saveRecipes();
        } else if (command.equals("l")) {
            loadRecipes();
        }
    }

    //MODIFIES : this
    //EFFECTS : takes user input and adds recipe to recipe book.
    public void addRecipe() {
        System.out.println("Enter the Name of Your Dish!");
        String name = input.nextLine();
        System.out.println("Sounds Great!");
        System.out.println("Enter the Cuisine of This Dish!");
        String cuisine = input.nextLine();
        Recipe r1 = new Recipe(name, cuisine);
        addIngredient(r1);
    }

    //MODIFIES : this
    //EFFECTS : takes user input and adds ingredients to recipe.
    public void addIngredient(Recipe r1) {
        boolean keepGoing1 = false;

        do {
            System.out.println("Would You Like to Add the Required Ingredients?");
            System.out.println("Y/N");
            String command = input.nextLine();
            command = command.toLowerCase(Locale.ROOT);
            if (command.equals("y")) {
                keepGoing1 = true;
            } else if (command.equals("n")) {
                keepGoing1 = false;
            } else {
                System.out.println("Didn't recognize that!");
                displayMenu();
            }
            if (keepGoing1) {
                System.out.println("Enter the Name of the ingredient!");
                String ingredient = input.nextLine();
                r1.addIngredient(ingredient);
            }
        } while (keepGoing1);
        addCookingInstructions(r1);
    }

    //MODIFIES : this
    //EFFECTS : takes user input and adds CookingInstructions to recipe.
    public void addCookingInstructions(Recipe r) {
        do {
            System.out.println("Would you like to add a Cooking Instruction?");
            System.out.println("Y//N");
            String command = input.nextLine();
            command = command.toLowerCase(Locale.ROOT);
            if (command.equals("y")) {
                keepGoing2 = true;
                System.out.println("Please Enter the Cooking Instruction!");
                String instruction = input.nextLine();
                idGen += 1;
                r.addCookingInstruction(instruction, idGen);
                addCookingInstructions(r);
            } else if (command.equals("n")) {
                keepGoing2 = false;
                recipeBook.addRecipe(r);
                idGen = 0;
            } else {
                System.out.println("Didn't Recognize That!");
                displayMenu();
            }
        } while (keepGoing2);
    }

    //MODIFIES : this
    //EFFECTS : removes recipe from recipe book.
    public void removeRecipe() {
        System.out.println("Enter the Name of the Recipe You Would Like to Remove!");
        String name = input.next();
        recipeBook.removeRecipe(name);
    }

    //EFFECTS : displays recipes in recipe book.
    public void viewRecipes() {
        System.out.println("Here are your recipes!");
        displayRecipes();
    }

    //EFFECTS : displays recipes with the required ingredients and cooking instructions.
    public void displayRecipes() {
        for (Recipe r : recipeBook.getRecipes()) {
            System.out.println("===============================================");
            System.out.println("Recipe Name : ");
            System.out.println(r.getName());
            System.out.println("Required Ingredients : ");
            for (String s : r.getIngredients()) {
                System.out.println(s);
            }
            System.out.println("Cooking Instructions : ");
            for (CookingInstructions c : r.getCookingInstructions()) {
                System.out.println("Step " + c.getId() + ": " + c.getInstruction());
            }
            System.out.println("===============================================");
        }
    }

    //EFFECTS: saves the Recipes to file
    private void saveRecipes() {
        try {
            jsonWriter.open();
            jsonWriter.write(recipeBook);
            jsonWriter.close();
            System.out.println("Saved Your Recipes!!");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file");
        }
    }

    private void loadRecipes() {
        try {
            recipeBook = jsonReader.read();
            System.out.println("Loaded Recipes!!");
        } catch (IOException e) {
            System.out.println("Unable to load recipes");
        }
    }
}
