package com.production.stock.service;




import com.production.stock.entity.AppUser;

import com.production.stock.model.AppUserModel;
import com.production.stock.repositories.AppUserRepository;
import com.production.stock.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    @Autowired
    private  AppUserRepository appUserRepository;
    @Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;

    public void setAppUserService(AppUserRepository appUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

    public AppUser signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();

        if (userExists) {
            throw new IllegalStateException("email already taken");
        }

        //PasswordEncoder passwordEncoder = new PasswordEncoder();
        /*String encodedPassword = bCryptPasswordEncoder
                .encode(appUser.getPassword());*/
        String encodedPassword = bCryptPasswordEncoder
                .encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);
        appUser.setEnabled(true);

        return appUserRepository.save(appUser);

    }

    public List<AppUser> findAll(){
        return appUserRepository.findAll();
    }

    public Optional<AppUser> findById(Long id){
        return appUserRepository.findById(id);
    }

    public AppUser addUser(AppUserModel model){
        AppUser appUser = new AppUser(model.getFirstName(), model.getLastName(), model.getEmail(), model.getPassword(), model.getAppUserRole());
        appUserRepository.save(appUser);
        return appUser;
    }

    public AppUser edit(Long id, AppUserModel model) throws Exception {
        return appUserRepository.findById(id)
                .map(edit -> {
                    edit.setFirstName(model.getFirstName());
                    edit.setLastName(model.getLastName());
                    edit.setEmail(model.getEmail());
                    return appUserRepository.save(edit);
                }).orElseThrow(Exception::new);
    }

    public String delete(Long id){
        appUserRepository.deleteById(id);
        return "Deleted";
    }

}
