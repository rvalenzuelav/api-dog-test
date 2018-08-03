package cl.mobdev.pruebatecnicabackend.web.controller;

import cl.mobdev.pruebatecnicabackend.service.ApiDogClientService;
import cl.mobdev.pruebatecnicabackend.service.beans.ApiDogResponse;
import cl.mobdev.pruebatecnicabackend.web.beans.TestResponse;
import cl.mobdev.pruebatecnicabackend.web.mapper.ResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public TestResponse retrieveBreedData(@RequestParam("breed-name") final String breedName) {
        return ResponseMapper.buildResponse(breedName);
    }

}
