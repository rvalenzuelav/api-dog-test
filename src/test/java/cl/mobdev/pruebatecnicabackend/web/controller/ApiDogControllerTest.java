package cl.mobdev.pruebatecnicabackend.web.controller;


import cl.mobdev.pruebatecnicabackend.service.beans.ApiDogResponse;
import cl.mobdev.pruebatecnicabackend.web.beans.TestResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ApiDogController.class)
public class ApiDogControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ApiDogController apiDogController;

    @Test
    public void successRetrieveBreedDataTest() throws Exception {

        TestResponse testResponse = new TestResponse();
        testResponse.setBreed("boxer");

        given(apiDogController.retrieveBreedData(testResponse.getBreed())).willReturn(testResponse);

        mvc.perform(get("/retrieve-breed-data")
                .param("breed-name", "boxer")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("breed", is(testResponse.getBreed())));

    }

    @Test
    public void successBreedListTest() throws Exception {

        ApiDogResponse response = new ApiDogResponse();
        response.setStatus("success");

        given(apiDogController.breedList()).willReturn(response);

        mvc.perform(get("/api-dog-list")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("status", is(response.getStatus())));

    }

    @Test
    public void errorBreedListTest() throws Exception {

        String errorUrl = "/api-dog-lizzzz";

        ApiDogResponse response = new ApiDogResponse();
        response.setStatus("error");

        given(apiDogController.breedList()).willReturn(response);

        mvc.perform(get(errorUrl)
                .contentType(APPLICATION_JSON))
                .andExpect(status().is4xxClientError());

    }

}