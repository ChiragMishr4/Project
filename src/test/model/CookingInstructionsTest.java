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

    @Test
    void testAddInstructionsOnce() {
        CookingInstructions instructionsTest2 = new CookingInstructions("def", 2);
        instructionsTest.addInstruction(instructionsTest2);
        assertEquals("def", instructionsTest.getInstructions().get(0).getInstruction());
    }

    @Test
    void testAddInstructionsMultiple() {
        CookingInstructions instructionsTest2 = new CookingInstructions("def", 2);
        CookingInstructions instructionsTest3 = new CookingInstructions("dfe", 3);
        instructionsTest.addInstruction(instructionsTest2);
        instructionsTest.addInstruction(instructionsTest3);
        assertEquals(2, instructionsTest.getInstructions().size());
        assertEquals("def", instructionsTest.getInstructions().get(0).getInstruction());
        assertEquals("dfe", instructionsTest.getInstructions().get(1).getInstruction());
    }



}
