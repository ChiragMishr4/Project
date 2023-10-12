package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CookingInstructionsTest {
    private CookingInstructions instructionsTest;

    @BeforeEach
    void runBefore() {
        instructionsTest = new CookingInstructions("abc", 1);
    }

    @Test
    void testConstructor() {
        assertEquals("abc", instructionsTest.getInstruction());
        assertEquals(1, instructionsTest.getId());
    }
}
