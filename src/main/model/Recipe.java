package model;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private List<String> ingredients;
    private String cuisine;
    private String name;

    public Recipe(String name, String cuisine) {
        this.name = name;
        this.cuisine = cuisine;
        ingredients = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getName() {
        return name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void addIngredient(String ingredient) {
        if (!ingredients.contains(ingredient)) {
            ingredients.add(ingredient);
        }
    }

    public void removeIngredient(String ingredient) {
        if (ingredients.contains(ingredient)) {
            ingredients.remove(ingredient);
        }
    }
}
