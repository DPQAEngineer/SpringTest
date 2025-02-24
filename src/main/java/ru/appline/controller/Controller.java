package ru.appline.controller;

import com.sun.org.apache.xpath.internal.objects.XString;
import org.mockito.internal.hamcrest.MatcherGenericTypeExtractor;
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
    public String createPet(@RequestBody Pet pet) {
        petModel.add(pet, newId.getAndIncrement());
        return "Your Pet was successfully created";
    }

    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String, Integer> id) {
        return petModel.getFromList(id.get("id"));
    }


    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll() {
        return petModel.getAll();
    }


    @DeleteMapping(value = "/deletePet", consumes = "application/json", produces = "application/json")
    public Pet deletePet(@RequestBody Map<String, Integer> id) {
        return petModel.deleteFromList(id.get("id"));
    }

    @PutMapping(value = "/updatePet", consumes = "application/json", produces = "application/json")
    public String updatePet(@RequestBody Pet pet, int id) {
        petModel.updateFromList(pet, id);
        return "Pet was updated";
    }
}
