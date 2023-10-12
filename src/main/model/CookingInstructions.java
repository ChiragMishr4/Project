package model;

import java.util.ArrayList;
import java.util.List;

public class CookingInstructions {

    private String instruction;
    private int id;

    public CookingInstructions(String instruction, int id) {
        this.instruction = instruction;
        this.id = id;
    }

    public String getInstruction() {
        return instruction;
    }

    public int getId() {
        return id;
    }
}
