package model;

import java.util.ArrayList;
import java.util.List;

//Represents a RecipeBook that contains a list of recipes.
public class RecipeBook {

    private List<Recipe> recipes;

    //EFFECTS : constructs a Recipe object.
    public RecipeBook() {
        recipes = new ArrayList<>();
    }

    //EFFECTS : returns list of all recipes.
    public List<Recipe> getRecipes() {
        List<Recipe> recipesName = new ArrayList<>();
        for (Recipe i : recipes) {
            recipesName.add(i);
        }
        return recipesName;
    }

    //MODIFIES : this
    //EFFECTS : adds Recipe to list of recipes if
    //          not already in list.
    public void addRecipe(Recipe r) {
        if (!recipes.contains(r)) {
            recipes.add(r);
        }
    }

    //MODIFIES : this
    //EFFECTS : removes Recipe from list of recipes if
    //          already in list.
    public void removeRecipe(String s) {
        for (Recipe r : recipes) {
            if (r.getName().equals(s)) {
                recipes.remove(r);
                break;
            }
        }
    }






}
