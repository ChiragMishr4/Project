package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

//Represents a RecipeBook that contains a list of recipes.
public class RecipeBook implements Writable {

    private ArrayList<Recipe> recipes;
    private String name;

    //EFFECTS : constructs a Recipe object.
    public RecipeBook(String name) {
        recipes = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    //EFFECTS : returns list of all recipes.
    public ArrayList<Recipe> getRecipes() {
        ArrayList<Recipe> recipesName = new ArrayList<>();
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

    @Override
    //EFFECTS: writes RecipeBook to json
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("recipes", recipesToJson());
        return json;
    }

    //EFFECTS: returns recipes as json Array.
    private JSONArray recipesToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Recipe r : recipes) {
            jsonArray.put(r.toJson());
        }
        return jsonArray;
    }
}
