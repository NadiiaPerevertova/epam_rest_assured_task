package org.example.steps;

import org.example.entities.Pet;
import org.example.service.PetService;

import java.util.List;

public final class PetServiceSteps {

    private static final PetService PET_SERVICE = PetService.getInstance();

    public static Pet getById(long id) {
        return PET_SERVICE.getRequest(id).as(Pet.class);
    }

    public static List<Pet> getByStatus(Pet.Status status) {
        return PET_SERVICE.getRequest(status).jsonPath().getList("", Pet.class);
    }

    public static Pet createPet(Pet pet) {
        return PET_SERVICE.postRequest(pet).as(Pet.class);
    }

    public static void deletePetById(long id) {
        PET_SERVICE.deleteRequest(id);
    }
}
