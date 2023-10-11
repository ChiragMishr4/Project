package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeBookTest {

    private RecipeBook testBook;
    private Recipe r1;
    private Recipe r2;

    @BeforeEach
    void runBefore() {
        testBook = new RecipeBook("Chirag");
        r1 = new Recipe("abc", "def");
        r2 = new Recipe("Pasta", "Italian");
    }

    @Test
    void testConstructor() {
        assertEquals("Chirag", testBook.getName());
        assertEquals(0, testBook.getRecipes().size());
    }

    @Test
    void testAddRecipeOnce() {
        testBook.addRecipe(r1);
        assertEquals(1, testBook.getRecipes().size());
        assertEquals("abc", testBook.getRecipes().get(0));
    }

    @Test
    void testAddRecipeMultiple() {
        testBook.addRecipe(r1);
        testBook.addRecipe(r2);
        assertEquals(2, testBook.getRecipes().size());
        assertEquals("abc", testBook.getRecipes().get(0));
        assertEquals("Pasta", testBook.getRecipes().get(1));
    }

    @Test
    void testRemoveRecipeOnce() {
        testBook.addRecipe(r1);
        testBook.removeRecipe("abc");
        assertEquals(0, testBook.getRecipes().size());
        assertTrue(testBook.getRecipes().isEmpty());
    }

    @Test
    void testRemoveRecipeMultiple() {
        testBook.addRecipe(r1);
        testBook.addRecipe(r2);
        assertEquals(2, testBook.getRecipes().size());
        assertEquals("abc", testBook.getRecipes().get(0));
        assertEquals("Pasta", testBook.getRecipes().get(1));
        testBook.removeRecipe("abc");
        assertEquals(1, testBook.getRecipes().size());
        assertEquals("Pasta", testBook.getRecipes().get(0));
        testBook.removeRecipe("Pasta");
        assertTrue(testBook.getRecipes().isEmpty());
    }
}
