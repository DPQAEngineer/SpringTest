package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PetModel implements Serializable {
    private static final PetModel Instance = new PetModel();

    private final Map<Integer, Pet> model;


    public PetModel() {
        model = new HashMap<Integer, Pet>();
    }

    public static PetModel getInstance() {
        return Instance;
    }

    public void add(Pet pet, int id) {
        model.put(id, pet);
    }

    public Pet getFromList(int id) {
        return model.get(id);
    }

    public Map<Integer, Pet> getAll() {
        return this.model;
    }

    public Pet deleteFromList(int id) {
        return model.remove(id);
    }

    public Pet updateFromList(Pet pet, int id) {
        return model.replace(id, pet);
    }
}