package cl.mobdev.pruebatecnicabackend.web.controller;

import cl.mobdev.pruebatecnicabackend.web.beans.ErrorResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionHandlerController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public ErrorResponse error() {

        return new ErrorResponse("error", "error");

    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
