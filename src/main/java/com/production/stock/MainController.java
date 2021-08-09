package com.production.stock;

import com.production.stock.model.AuthenticationRequest;
import com.production.stock.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(method = RequestMethod.POST)
public class MainController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home");
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("title", "registration");
        return "registration";
    }

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("title", "main");
        return "main";
    }

    @PostMapping("/auth")
    @ResponseBody
    public String createAuthToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try {
            System.out.println(jwtTokenUtil.generateToken(authenticationRequest.getUsername()));
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password!!!",e);
        }
        return jwtTokenUtil.generateToken(authenticationRequest.getUsername());
    }

}