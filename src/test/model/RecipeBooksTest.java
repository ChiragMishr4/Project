package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeBooksTest {
    private RecipeBooks r1;
    private RecipeBook testRecipeBook;

    @BeforeEach
    void runBefore() {
        r1 = new RecipeBooks();
        testRecipeBook = new RecipeBook("abc");
    }

    @Test
    void testConstructor() {
        assertEquals(0, r1.getRecipeBooks().size());
    }

    @Test
    void testAddRecipe() {
        assertEquals(0, r1.getRecipeBooks().size());
        r1.addRecipeBook(testRecipeBook);
        assertEquals(1, r1.getRecipeBooks().size());
        assertEquals("abc", r1.getRecipeBooks().get(0).getName());
    }

    @Test
    void testGetRecipeBook() {
        assertEquals(0, r1.getRecipeBooks().size());
        r1.addRecipeBook(testRecipeBook);
        assertEquals(1, r1.getRecipeBooks().size());
        assertEquals(testRecipeBook, r1.getRecipeBooks().get(0));
    }
}
