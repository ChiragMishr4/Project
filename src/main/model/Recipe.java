package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

//Represents a Recipe having a name, cuisine, list of ingredients and list of cooking instructions.
public class Recipe implements Writable {
    private List<String> ingredients;
    private CookingInstructions cookingInstruction;
    private List<CookingInstructions> instructions;
    private String cuisine;
    private String name;

    //EFFECTS : constructs a Recipe object with a name and cuisine.
    public Recipe(String name, String cuisine) {
        this.name = name;
        this.cuisine = cuisine;
        ingredients = new ArrayList<>();
        instructions = new ArrayList<>();
    }

    // MODIFIES : this
    // EFFECTS : sets the name of the recipe to name.
    public void setName(String name) {
        this.name = name;
    }

    // MODIFIES : this
    // EFFECTS : sets the cuisine of Recipe to cuisine.
    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    //EFFECTS : returns name of Recipe.
    public String getName() {
        return name;
    }

    //EFFECTS : returns cuisine of Recipe.
    public String getCuisine() {
        return cuisine;
    }

    //EFFECTS : returns list of ingredients.
    public List<String> getIngredients() {
        return ingredients;
    }

    //EFFECTS : returns list of CookingInstructions.
    public List<CookingInstructions> getCookingInstructions() {
        return instructions;
    }

    //MODIFIES : this
    //EFFECTS : adds the ingredient to the list of ingredients
    //          if not already there.
    public void addIngredient(String ingredient) {
        if (!ingredients.contains(ingredient)) {
            ingredients.add(ingredient);
        }
    }

    //MODIFIES : this
    //EFFECTS : removes ingredient from list of ingredients if
    //          already in the list.
    public void removeIngredient(String ingredient) {
        if (ingredients.contains(ingredient)) {
            ingredients.remove(ingredient);
        }
    }

    //MODIFIES : this
    //EFFECTS : adds CookingInstruction to list of instructions.
    public void addCookingInstruction(String s, int i) {
        cookingInstruction = new CookingInstructions(s, i);
        instructions.add(cookingInstruction);
    }

    //MODIFIES : this
    //EFFECTS : removes CookingInstruction from list of instructions
    //          if already in list.
    public void removeCookingInstruction(int s) {
        for (CookingInstructions c : instructions) {
            if (c.getId() == s) {
                instructions.remove(c);
                break;
            }
        }
    }


    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("cuisine", cuisine);
        jsonObject.put("ingredients", ingredientsToJson());
        jsonObject.put("instructions", instructionsToJson());

        return jsonObject;
    }

    private JSONArray ingredientsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (String s : ingredients) {
            jsonArray.put(s);
        }
        return jsonArray;
    }

    private JSONArray instructionsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (CookingInstructions c : instructions) {
            jsonArray.put(c.toJson());
        }
        return jsonArray;
    }
}
