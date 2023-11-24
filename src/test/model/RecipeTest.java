package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {
    private Recipe r1;
    private Recipe r2;

    @BeforeEach
    void runBefore() {
        r1 = new Recipe("abc", "def");
        r2 = new Recipe("abc", "def");
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
    void testAddSameIngredient() {
        r1.addIngredient("chicken");
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
    void testRemoveSameIngredient() {
        r1.addIngredient("chicken");
        r1.removeIngredient("chicken");
        r1.removeIngredient("chicken");
        assertEquals(0, r1.getIngredients().size());
        assertTrue(r1.getIngredients().isEmpty());
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

    @Test
    void testGetCookingInstructions() {
        assertEquals(0, r1.getCookingInstructions().size());
    }

    @Test
    void testAddCookingInstructionsOnce() {
        r1.addCookingInstruction("Preheat Oven", 1);
        assertEquals("Preheat Oven", r1.getCookingInstructions().get(0).getInstruction());
        assertEquals(1, r1.getCookingInstructions().get(0).getId());
    }

    @Test
    void testAddCookingInstructionsMultiple() {
        r1.addCookingInstruction("Preheat Oven", 1);
        assertEquals("Preheat Oven", r1.getCookingInstructions().get(0).getInstruction());
        assertEquals(1, r1.getCookingInstructions().get(0).getId());
        r1.addCookingInstruction("Chop Veg", 2);
        assertEquals("Chop Veg", r1.getCookingInstructions().get(1).getInstruction());
        assertEquals(2, r1.getCookingInstructions().get(1).getId());
    }

    @Test
    void testRemoveCookingInstructionsOnce() {
        r1.addCookingInstruction("Preheat Oven", 1);
        assertEquals("Preheat Oven", r1.getCookingInstructions().get(0).getInstruction());
        assertEquals(1, r1.getCookingInstructions().get(0).getId());
        r1.removeCookingInstruction(1);
        assertTrue(r1.getCookingInstructions().isEmpty());
    }

    @Test
    void testRemoveCookingInstructionsMultiple() {
        r1.addCookingInstruction("Preheat Oven", 1);
        assertEquals("Preheat Oven", r1.getCookingInstructions().get(0).getInstruction());
        assertEquals(1, r1.getCookingInstructions().get(0).getId());
        r1.addCookingInstruction("Chop Veg", 2);
        assertEquals("Chop Veg", r1.getCookingInstructions().get(1).getInstruction());
        assertEquals(2, r1.getCookingInstructions().get(1).getId());
        r1.removeCookingInstruction(1);
        assertEquals("Chop Veg", r1.getCookingInstructions().get(0).getInstruction());
        assertEquals(2, r1.getCookingInstructions().get(0).getId());
        r1.removeCookingInstruction(1);
        assertEquals("Chop Veg", r1.getCookingInstructions().get(0).getInstruction());
        assertEquals(2, r1.getCookingInstructions().get(0).getId());
        r1.removeCookingInstruction(2);
        assertTrue(r1.getCookingInstructions().isEmpty());
        r1.removeCookingInstruction(3);
        assertTrue(r1.getCookingInstructions().isEmpty());
    }

    @Test
    void testEqualsIngredients() {
        assertTrue(r1.equals(r2));
        r1.addIngredient("water");
        r2.addIngredient("salt");
        assertFalse(r1.equals(r2));
    }

    @Test
    void testEqualsInstructions() {
        assertTrue(r1.equals(r2));
        r1.addCookingInstruction("Boil Water", 1);
        r2.addCookingInstruction("Boil Water", 1);
        assertTrue(r1.equals(r2));
        r1.addCookingInstruction("Boil Pasta", 2);
        r2.addCookingInstruction("Boil Pasta", 3);
        assertFalse(r1.equals(r2));
        r1.addCookingInstruction("abc", 3);
        r2.addCookingInstruction("def", 3);
        assertFalse(r1.equals(r2));
    }

    @Test
    void testHashcode() {
        assertTrue(r1.hashCode() == r2.hashCode());
    }
}
