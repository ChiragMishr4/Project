package model;

import java.util.ArrayList;
import java.util.List;

public class RecipeBook {

    private List<Recipe> recipes;

    public RecipeBook() {
        recipes = new ArrayList<>();
    }

    public List<Recipe> getRecipes() {
        List<Recipe> recipesName = new ArrayList<>();
        for (Recipe i : recipes) {
            recipesName.add(i);
        }
        return recipesName;
    }

    public void addRecipe(Recipe r) {
        if (!recipes.contains(r)) {
            recipes.add(r);
        }
    }

    public void removeRecipe(String s) {
        for (Recipe r : recipes) {
            if (r.getName().equals(s)) {
                recipes.remove(r);
                break;
            }
        }
    }






}
