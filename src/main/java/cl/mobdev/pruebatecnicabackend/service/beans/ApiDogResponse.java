package cl.mobdev.pruebatecnicabackend.service.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiDogResponse {

    private String status;
    private List<String> message;

    public ApiDogResponse() {
    }

    public String getStatus() {
        return status;
    }

    public List<String> getMessage() {
        return message;
    }
}
