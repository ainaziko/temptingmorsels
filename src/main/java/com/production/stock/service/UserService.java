package com.production.stock.service;


import com.production.stock.entity.AppUser;
import com.production.stock.model.AppUserModel;
import com.production.stock.registration.RegistrationRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    AppUser save(AppUserModel registrationDto);
}
