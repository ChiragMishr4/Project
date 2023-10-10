package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {
    private Recipe r1;

    @BeforeEach
    void runBefore() {
        r1 = new Recipe("abc", "def");
    }

    @Test
    void testConstructor() {
        assertEquals("abc", r1.getName());
        assertEquals("def", r1.getCuisine());
    }

    @Test
    void testSetName() {
        r1.setName("def");
        assertEquals("def", r1.getName());
    }

    @Test
    void testSetCuisine() {
        r1.setCuisine("abc");
        assertEquals("abc", r1.getCuisine());
    }

    @Test
    void testAddIngredientSingle() {
        r1.addIngredient("chicken");
        assertEquals(1, r1.getIngredients().size());
        assertEquals("chicken", r1.getIngredients().get(0));
    }

    @Test
    void testAddIngredientMultiple() {
        r1.addIngredient("chicken");
        r1.addIngredient("mango");
        assertEquals(2, r1.getIngredients().size());
        assertEquals("chicken", r1.getIngredients().get(0));
        assertEquals("mango", r1.getIngredients().get(1));
    }

    @Test
    void testRemoveIngredientOneIngredient() {
        r1.addIngredient("chicken");
        r1.removeIngredient("chicken");
        assertEquals(0, r1.getIngredients().size());
    }

    @Test
    void testRemoveIngredientsMultiple() {
        r1.addIngredient("chicken");
        r1.addIngredient("mango");
        assertEquals(2, r1.getIngredients().size());
        r1.removeIngredient("chicken");
        assertEquals(1, r1.getIngredients().size());
        assertEquals("mango", r1.getIngredients().get(0));
        r1.removeIngredient("mango");
        assertEquals(0, r1.getIngredients().size());
    }
}