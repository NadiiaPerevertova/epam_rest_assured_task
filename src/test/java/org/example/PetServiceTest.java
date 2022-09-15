package org.example;

import org.example.entities.Pet;
import org.example.steps.PetServiceSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class PetServiceTest {

    @Test
    public void getByStatusTest() {
        List<Pet> pets = PetServiceSteps.getByStatus(Pet.Status.available);
        boolean allPetsInStatusAvailable = pets.stream().allMatch(pet -> pet.getStatus() == Pet.Status.available);
        Assert.assertNotEquals(pets.size(), 0, "Expected pet list should not be empty");
        Assert.assertTrue(allPetsInStatusAvailable, "Not all pets have expected status: available");
    }

    @Test
    public void getByIdTest() {
        List<Pet> pets = PetServiceSteps.getByStatus(Pet.Status.available);
        Pet expectedPet = pets.get(0);
        Pet actualPet = PetServiceSteps.getById(expectedPet.getId());
        Assert.assertEquals(actualPet, expectedPet, "Expected pet does not match expected one");
    }

    @Test
    public void createPetTest() {
        Pet expectedPet = createPet();
        Pet createdPet = PetServiceSteps.createPet(expectedPet);
        Assert.assertEquals(createdPet, expectedPet.setId(createdPet.getId()), "Expected pet does not match created one");
    }

    private Pet createPet() {
        Random random = new Random();
        return new Pet()
                .setName("Cezar_" + random.nextInt())
                .setCategory(new Pet.Category().setId(random.nextInt()).setName("cat"))
                .setPhotoUrls(new String[]{"https://petstore.swagger.io/#/pet/cat/cazar"})
                .setTags(new Pet.Tag[]{new Pet.Tag().setId(random.nextInt()).setName("bengal")})
                .setStatus(Pet.Status.pending);
    }

    @Test
    public void deleteUsersTest() {
        Pet expectedPet = createPet();
        Pet createdPet = PetServiceSteps.createPet(expectedPet);
        PetServiceSteps.deletePetById(createdPet.getId());

        List<Pet> petsAfterDelete = PetServiceSteps.getByStatus(createdPet.getStatus()).stream()
                .filter(pet -> pet.getId() == createdPet.getId() && pet.getName().equals(createdPet.getName()))
                .toList();
        Assert.assertEquals(petsAfterDelete.size(), 0, "Pet is not deleted:" + createdPet);
    }
}
