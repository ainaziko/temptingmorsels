package com.production.stock.registration;

import com.production.stock.entity.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public AppUser register(@RequestBody RegistrationRequest request) {
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
