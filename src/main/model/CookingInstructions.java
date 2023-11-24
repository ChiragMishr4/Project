package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CookingInstructions that = (CookingInstructions) o;

        if (id != that.id) {
            return false;
        }
        return Objects.equals(instruction, that.instruction);
    }

    @Override
    public int hashCode() {
        int result = instruction.hashCode();
        result = 31 * result + id;
        return result;
    }
}
