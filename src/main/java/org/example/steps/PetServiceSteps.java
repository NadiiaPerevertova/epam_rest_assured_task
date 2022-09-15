package org.example.steps;

import org.example.entities.Pet;
import org.example.service.PetService;

import java.util.List;

public final class PetServiceSteps {

    private static final PetService PET_SERVICE = PetService.getInstance();

    private PetServiceSteps() {
    }

    public static Pet getPetById(long id) {
        return PET_SERVICE.getPetById(id).as(Pet.class);
    }

    public static List<Pet> getPetsByStatus(Pet.Status status) {
        return PET_SERVICE.getPetsByStatus(status).jsonPath().getList("", Pet.class);
    }

    public static Pet createPet(Pet pet) {
        return PET_SERVICE.createPet(pet).as(Pet.class);
    }

    public static void deletePetById(long id) {
        PET_SERVICE.deletePetById(id);
    }
}
