package ru.appline.controller;

import com.sun.org.apache.xpath.internal.objects.XString;
import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
    private static final PetModel petModel = PetModel.getInstance();
    private static final AtomicInteger newId = new AtomicInteger(1);

    @PostMapping(value = "/createPet", consumes = "application/json")
    public void createPet(@RequestBody Pet pet) {
        petModel.add(pet, newId.getAndIncrement());
        String s = "Your Pet was successfully created"
                return s
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll() {
        return petModel.getAll();
    }

    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String, Integer> id) {
        return petModel.getFromList(id.get("id"));
    }

    @DeleteMapping(value = "/deletePet", consumes = "application/json", produces = "application/json")
    public void deletePet(@RequestBody int pet) {
        petModel.delete(pet)
                String b = "Your Pet was deleted"
                        return b
    }

    @PutMapping(value = "/updatePet", consumes = "application/json", produces = "application/json")
    public void updatePet(@RequestBody int pet, String type, String name, int age) {
        petModel.update(pet)
                String a = "Your Pet was updated"
                        return a
    }

}
