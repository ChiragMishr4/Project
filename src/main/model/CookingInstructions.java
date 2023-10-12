package model;

import java.util.ArrayList;
import java.util.List;

public class CookingInstructions {

    private String instruction;
    private int id;

    //EFFECTS : constructs a CookingInstructions object with an instruction
    //          and id.
    public CookingInstructions(String instruction, int id) {
        this.instruction = instruction;
        this.id = id;
    }

    //EFFECTS : returns the instruction of the object.
    public String getInstruction() {
        return instruction;
    }

    //EFFECTS : returns the id of the object.
    public int getId() {
        return id;
    }
}
