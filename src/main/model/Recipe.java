package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    //EFFECTS: writes Recipe to json.
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("cuisine", cuisine);
        jsonObject.put("ingredients", ingredientsToJson());
        jsonObject.put("instructions", instructionsToJson());

        return jsonObject;
    }

    //EFFECTS: returns ingredients as json Array.
    private JSONArray ingredientsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (String s : ingredients) {
            jsonArray.put(s);
        }
        return jsonArray;
    }

    //EFFECTS: returns instructions as json Array.
    private JSONArray instructionsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (CookingInstructions c : instructions) {
            jsonArray.put(c.toJson());
        }
        return jsonArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Recipe recipe = (Recipe) o;

        if (!Objects.equals(ingredients, recipe.ingredients)) {
            return false;
        }
        if (!Objects.equals(cookingInstruction, recipe.cookingInstruction)) {
            return false;
        }
        if (!Objects.equals(instructions, recipe.instructions)) {
            return false;
        }
        if (!cuisine.equals(recipe.cuisine)) {
            return false;
        }
        return name.equals(recipe.name);
    }

    @Override
    public int hashCode() {
        int result = ingredients != null ? ingredients.hashCode() : 0;
        result = 31 * result + (cookingInstruction != null ? cookingInstruction.hashCode() : 0);
        result = 31 * result + (instructions != null ? instructions.hashCode() : 0);
        result = 31 * result + cuisine.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
