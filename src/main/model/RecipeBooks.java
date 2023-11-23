package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecipeBooks implements Writable {
    private List<RecipeBook> recipeBooks;

    public RecipeBooks() {
        recipeBooks = new ArrayList<>();
    }

    public void addRecipeBook(RecipeBook r) {
        recipeBooks.add(r);
    }

    public List<RecipeBook> getRecipeBooks() {
        return Collections.unmodifiableList(recipeBooks);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("recipeBooks", recipeBooksToJson());
        return json;
    }

    private JSONArray recipeBooksToJson() {
        JSONArray jsonArray = new JSONArray();
        for (RecipeBook r : recipeBooks) {
            jsonArray.put(r.toJson());
        }
        return jsonArray;
    }
}
