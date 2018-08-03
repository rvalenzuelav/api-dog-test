package cl.mobdev.pruebatecnicabackend.web.mapper;

import cl.mobdev.pruebatecnicabackend.service.ApiDogClientService;
import cl.mobdev.pruebatecnicabackend.service.beans.ApiDogResponse;
import cl.mobdev.pruebatecnicabackend.web.beans.TestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by rvalenzuela on 02-08-2018.
 */
@Component
public class ResponseMapper {

    private static ApiDogClientService apiDogClientService;

    @Autowired
    public ResponseMapper(ApiDogClientService apiDogClientService) {
        ResponseMapper.apiDogClientService = apiDogClientService;
    }

    public static TestResponse buildResponse(final String breedName) {

        TestResponse testResponse = new TestResponse();
        Optional<String> opt = Optional.ofNullable(breedName);

        if (opt.isPresent()) {
            ApiDogResponse subBreedResponse = apiDogClientService.getBreedSubBreedByName(breedName);
            ApiDogResponse imagesResponse = apiDogClientService.getBreedImageByName(breedName);

            testResponse.setBreed(breedName);
            testResponse.setSubBreeds(subBreedResponse.getMessage());
            testResponse.setImages(imagesResponse.getMessage());
        }
        return testResponse;
    }

}
