package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

//Represents cooking instructions with an instruction and an id.
public class CookingInstructions implements Writable {

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

    @Override
    //EFFECTS: writes CookingInstructions to json.
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("instruction", instruction);
        jsonObject.put("id", id);

        return jsonObject;
    }
}
