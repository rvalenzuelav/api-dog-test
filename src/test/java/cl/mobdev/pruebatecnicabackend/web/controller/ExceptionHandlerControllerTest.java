package cl.mobdev.pruebatecnicabackend.web.controller;

import cl.mobdev.pruebatecnicabackend.service.beans.ApiDogResponse;
import cl.mobdev.pruebatecnicabackend.web.beans.ErrorResponse;
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
@WebMvcTest(ExceptionHandlerController.class)
public class ExceptionHandlerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ExceptionHandlerController exceptionHandlerController;

    @Test
    public void error() throws Exception {

        ErrorResponse errorResponse = new ErrorResponse("error", "error");

        given(exceptionHandlerController.error()).willReturn(errorResponse);

        mvc.perform(get("/error")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("errorCode", is(errorResponse.getErrorCode())));

    }

}