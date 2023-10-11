package model;

import java.util.ArrayList;
import java.util.List;

public class RecipeBook {

    private String userName;
    private List<Recipe> recipes;

    public RecipeBook(String name) {
        this.userName = name;
        recipes = new ArrayList<>();
    }

    public String getName() {
        return userName;
    }

    public List<String> getRecipes() {
        List<String> recipesName = new ArrayList<>();
        for (Recipe i : recipes) {
            recipesName.add(i.getName());
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
