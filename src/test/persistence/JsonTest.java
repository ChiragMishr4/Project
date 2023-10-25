package persistence;

import model.Recipe;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// adapted from : https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonTest {
    protected void checkRecipe(String name, Recipe r, String cuisine) {
        assertEquals(name, r.getName());
        assertEquals(cuisine, r.getCuisine());
    }
}
