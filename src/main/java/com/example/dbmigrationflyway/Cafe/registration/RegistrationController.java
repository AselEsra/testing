package com.example.dbmigrationflyway.Cafe.registration;

import org.springframework.stereotype.Controller;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/register")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @PostMapping("/add")
    public String register(@RequestParam String firstname,
                           @RequestParam String lastname,
                           @RequestParam String email,
                           @RequestParam String password){
        registrationService.register(firstname, lastname, email, password);
        return "redirect:/login";
    }
}

