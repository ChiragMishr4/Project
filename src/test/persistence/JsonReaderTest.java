package persistence;

import model.*;
import persistence.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

// adapted from : https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class JsonReaderTest extends JsonTest{

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            RecipeBook wr = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyFile.json");
        try {
            RecipeBook wr = reader.read();
            assertEquals(0, wr.getRecipes().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneral() {
        JsonReader reader = new JsonReader("./data/testReaderGeneral.json");
        ArrayList<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("abc", "def"));
        recipes.add(new Recipe("def", "xyz"));
        try {
            RecipeBook wr = reader.read();
            List<Recipe> recipes1 = wr.getRecipes();
            assertEquals(2, recipes1.size());
            checkRecipe("abc", recipes1.get(0), "def");
            recipes.remove(recipes.get(0));
            checkRecipe("def", recipes1.get(1), "xyz");
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
