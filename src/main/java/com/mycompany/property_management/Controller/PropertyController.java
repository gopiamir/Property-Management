package com.mycompany.property_management.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//we cannot map url to java class functions


//RESTFul API - it is just mapping of a URL to a java class function
@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @GetMapping("/hello")
    public String sayHello()
    {
         return "Hello Spring Boot";
    }
}
