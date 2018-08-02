package cl.mobdev.pruebatecnicabackend.service;

import cl.mobdev.pruebatecnicabackend.service.beans.ApiDogResponse;

public interface ApiDogClientService {

    ApiDogResponse getAllBreedList();

    ApiDogResponse getBreedSubBreedByName(String breedName);

    ApiDogResponse getBreedImageByName(String breedName);
}
