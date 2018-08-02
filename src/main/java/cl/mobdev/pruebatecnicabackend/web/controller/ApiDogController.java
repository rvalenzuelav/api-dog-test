package cl.mobdev.pruebatecnicabackend.web.controller;

import cl.mobdev.pruebatecnicabackend.service.ApiDogClientService;
import cl.mobdev.pruebatecnicabackend.service.beans.ApiDogResponse;
import cl.mobdev.pruebatecnicabackend.web.beans.TestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiDogController {

    @Autowired
    private ApiDogClientService apiDogClientService;

    @RequestMapping("/api-dog-list")
    public ApiDogResponse breedList() {
        return apiDogClientService.getAllBreedList();

    }

    @RequestMapping("/retrieve-breed-data")
    public TestResponse retrieveBreedData(@RequestParam("breed-name") final String breedName)
            throws MissingServletRequestParameterException {
        if (breedName == null) {
            throw new MissingServletRequestParameterException("breed-name", "required");
        }
        return buildResponse(breedName);
    }



    private TestResponse buildResponse(final String breedName) {

        ApiDogResponse subBreedResponse = apiDogClientService.getBreedSubBreedByName(breedName);
        ApiDogResponse imagesResponse = apiDogClientService.getBreedImageByName(breedName);

        TestResponse testResponse = new TestResponse();
        testResponse.setBreed(breedName);
        testResponse.setSubBreeds(subBreedResponse.getMessage());
        testResponse.setImages(imagesResponse.getMessage());

        return testResponse;
    }
}
