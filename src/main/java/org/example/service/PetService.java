package org.example.service;

import io.restassured.response.Response;
import org.example.entities.Pet;
import org.example.service.uritemplate.UriTemplate;

public final class PetService extends CommonService {
    private static PetService instance;

    public static PetService getInstance() {
        if (instance == null) {
            instance = new PetService();
        }
        return instance;
    }

    private PetService() {
    }

    private static final UriTemplate PET = new UriTemplate("pet");
    private static final UriTemplate PETS_BY_STATUS = new UriTemplate("pet/findByStatus?status=%s");
    private static final UriTemplate PET_BY_ID = new UriTemplate("pet/%s");

    public Response getPetsByStatus(Pet.Status status) {
        return super.getRequest(PETS_BY_STATUS.getUri(status.name()));
    }

    public Response getPetById(long id) {
        return super.getRequest(PET_BY_ID.getUri(id));
    }

    public Response createPet(Object body) {
        return super.postRequest(PET.getUri(), body);
    }

    public void deletePetById(long id) {
        super.deleteRequest(PET_BY_ID.getUri(id));
    }
}
