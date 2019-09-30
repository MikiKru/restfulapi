package com.atos.rest_start.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

// klasa nasłuchująca na żądania http
// @RestController - adnotacja do zwacania wyików w postaci REST API
// @Controller - adnotacja do zwracania szbalonów widoków thymeleaf, JSP, HTML
// @RequestMapping("/hello") - adres do zasobów HelloWorldController
// @RequestMapping("/hello") - domyślenie żądanie typu GET
@RequestMapping("/hello")
@RestController
public class HelloWorldController {
    // żądanie wywołania metody hello() dla adresu localhost:8080/hello/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(){
        return "Hello World!";
    }
    @GetMapping("/data/{myName}&{birthDate}")
    public String helloWithName(@PathVariable String myName, @PathVariable String birthDate){
        try {
            LocalDate date = LocalDate.parse(birthDate);
            return "name: " + myName + ";" + "lastname: " + date;
        } catch (DateTimeParseException e){
            return "name: " + myName;
        } catch (Exception e){
            return "masakra";
        }
    }


}
