package persistence;

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

//adapted from : https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public RecipeBooks read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkRoom(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private RecipeBooks parseWorkRoom(JSONObject jsonObject) {
        RecipeBooks wr = new RecipeBooks();
        addRecipeBooks(wr, jsonObject);
        return wr;
    }

    private void addRecipeBooks(RecipeBooks wr, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("recipeBooks");
        for (Object json : jsonArray) {
            JSONObject nextRecipeBook = (JSONObject) json;
            addRecipeBook(wr, nextRecipeBook);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses recipes from JSON object and adds them to RecipeBook
    private void addRecipeBook(RecipeBooks wr, JSONObject jsonObject) {
        RecipeBook r = new RecipeBook(jsonObject.getString("name"));
        JSONArray jsonArray = jsonObject.getJSONArray("recipes");
        for (Object json : jsonArray) {
            JSONObject k = (JSONObject) json;
            addRecipe(r, k);
        }
        wr.addRecipeBook(r);
    }

    // MODIFIES: wr
    // EFFECTS: parses recipe from JSON object and adds it to RecipeBook
    private void addRecipe(RecipeBook wr, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String cuisine = jsonObject.getString("cuisine");
        Recipe r1 = new Recipe(name, cuisine);
        addInstructions(r1, jsonObject);
        addIngredients(r1, jsonObject);
        wr.addRecipe(r1);
    }

    //MODIFIES: this
    //EFFECTS: adds instructions from json to recipe.
    private void addInstructions(Recipe r, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("instructions");
        for (Object json : jsonArray) {
            JSONObject jsonObject2 = (JSONObject) json;
            String instruction = jsonObject2.getString("instruction");
            int id = jsonObject2.getInt("id");
            r.addCookingInstruction(instruction, id);
        }
    }

    //MODIFIES: this
    //EFFECTS: adds ingredients from json to recipe.
    private void addIngredients(Recipe r, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("ingredients");
        for (Object json : jsonArray) {
            r.addIngredient(json.toString());
        }
    }
}