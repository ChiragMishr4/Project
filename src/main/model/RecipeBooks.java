package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Represents a list of RecipeBook.
public class RecipeBooks implements Writable {
    private List<RecipeBook> recipeBooks;

    public RecipeBooks() {
        recipeBooks = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: adds RecipeBook to the list of RecipeBooks.
    public void addRecipeBook(RecipeBook r) {
        recipeBooks.add(r);
        EventLog.getInstance().logEvent(new Event("Added RecipeBook : " + r.getName()));
    }

    //EFFECTS: returns a list of all RecipeBooks.
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
