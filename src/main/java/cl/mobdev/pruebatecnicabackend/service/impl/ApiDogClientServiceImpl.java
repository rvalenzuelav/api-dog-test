package cl.mobdev.pruebatecnicabackend.service.impl;

import cl.mobdev.pruebatecnicabackend.service.ApiDogClientService;
import cl.mobdev.pruebatecnicabackend.service.beans.ApiDogResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiDogClientServiceImpl implements ApiDogClientService {

    @Value("${api.dog.breeds.list}")
    private String allBreedUrl;

    @Value("${api.dog.breed.subbreeds.list}")
    private String subBreedUrl;

    @Value("${api.dog.breed.images.list}")
    private String breedImageUrl;



    @Override
    public ApiDogResponse getAllBreedList() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(allBreedUrl, ApiDogResponse.class);

    }

    @Override
    public ApiDogResponse getBreedSubBreedByName(String breedName) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(String.format(subBreedUrl, breedName), ApiDogResponse.class);
    }

    @Override
    public ApiDogResponse getBreedImageByName(String breedName) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(String.format(breedImageUrl, breedName), ApiDogResponse.class);
    }
}
