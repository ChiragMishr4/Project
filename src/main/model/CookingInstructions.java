package model;

import java.util.ArrayList;
import java.util.List;

public class CookingInstructions {

    private List<CookingInstructions> instructions;
    private String instruction;
    private int id;

    public CookingInstructions(String instruction, int id) {
        this.instruction = instruction;
        this.id = id;
        instructions = new ArrayList<>();
    }

    public void addInstruction(CookingInstructions c) {
        instructions.add(c);
    }

    public List<CookingInstructions> getInstructions() {
        return instructions;
    }

    public String getInstruction() {
        return instruction;
    }

    public int getId() {
        return id;
    }
}
