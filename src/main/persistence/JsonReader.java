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
    public RecipeBook read() throws IOException {
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
    private RecipeBook parseWorkRoom(JSONObject jsonObject) {
        RecipeBook wr = new RecipeBook();
        addRecipes(wr, jsonObject);
        return wr;
    }

    // MODIFIES: wr
    // EFFECTS: parses recipes from JSON object and adds them to RecipeBook
    private void addRecipes(RecipeBook wr, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("recipes");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addRecipe(wr, nextThingy);
        }
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

    //MODIFIES:
    //EFFECTS:
    private void addInstructions(Recipe r, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("instructions");
        for (Object json : jsonArray) {
            JSONObject jsonObject2 = (JSONObject) json;
            String instruction = jsonObject2.getString("instruction");
            int id = jsonObject2.getInt("id");
            r.addCookingInstruction(instruction, id);
        }
    }

    //MODIFIES:
    //EFFECTS:
    private void addIngredients(Recipe r, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("ingredients");
        for (Object json : jsonArray) {
            r.addIngredient(json.toString());
        }
    }
}