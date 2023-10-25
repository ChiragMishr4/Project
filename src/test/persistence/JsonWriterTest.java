package persistence;

import model.*;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// adapted from : https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonWriterTest extends JsonTest {
    @Test
    void testWriterInvalidFile() {
        try {
            RecipeBook wr = new RecipeBook();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            RecipeBook wr = new RecipeBook();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyFile.json");
            writer.open();
            writer.write(wr);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyFile.json");
            wr = reader.read();
            assertEquals(0, wr.getRecipes().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneral() {
        try {
            RecipeBook wr = new RecipeBook();
            Recipe r1 = new Recipe("abc", "def");
            Recipe r2 = new Recipe("def", "xyz");
            wr.addRecipe(r1);
            wr.addRecipe(r2);
            ArrayList<Recipe> recipes = new ArrayList<>();
            recipes.add(new Recipe("abc", "def"));
            recipes.add(new Recipe("def", "xyz"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneral.json");
            writer.open();
            writer.write(wr);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneral.json");
            wr = reader.read();
            List<Recipe> recipes1 = wr.getRecipes();
            assertEquals(2, recipes1.size());
            checkRecipe("abc", recipes1.get(0), "def");
        } catch (IOException e) {
            fail("Exception not expected");
        }
    }
}
