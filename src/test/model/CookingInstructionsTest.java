package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CookingInstructionsTest {
    private CookingInstructions instructionsTest;
    private CookingInstructions instructionsTest1;
    private CookingInstructions instructionsTest2;
    private CookingInstructions instructionsTest3;

    @BeforeEach
    void runBefore() {
        instructionsTest = new CookingInstructions("abc", 1);
        instructionsTest1 = new CookingInstructions("Boil Water", 1);
        instructionsTest2 = new CookingInstructions("Boil Water", 2);
        instructionsTest3 = new CookingInstructions("abc", 1);
    }

    @Test
    void testConstructor() {
        assertEquals("abc", instructionsTest.getInstruction());
        assertEquals(1, instructionsTest.getId());
    }

    @Test
    void testEquals() {
        assertFalse(instructionsTest1.equals(instructionsTest2));
        assertTrue(instructionsTest.equals(instructionsTest3));
    }

    @Test
    void testHashcode() {
        assertTrue(instructionsTest.hashCode() == instructionsTest3.hashCode());
    }
}
