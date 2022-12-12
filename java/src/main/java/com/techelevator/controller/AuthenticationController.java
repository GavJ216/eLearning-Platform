package com.techelevator.controller;

import javax.validation.Valid;

import com.techelevator.model.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.techelevator.dao.UserDao;
import com.techelevator.security.jwt.JWTFilter;
import com.techelevator.security.jwt.TokenProvider;

@RestController
@CrossOrigin
public class AuthenticationController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private UserDao userDao;

    public AuthenticationController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, UserDao userDao) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userDao = userDao;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginDto loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication, false);
        
        User user = userDao.findByUsername(loginDto.getUsername());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        return new ResponseEntity<>(new LoginResponseDto(jwt, user), httpHeaders, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User register(@Valid @RequestBody RegisterUserDto newUser) {

        return userDao.create(newUser.getFirstName(), newUser.getLastName(), newUser.getPassword(), newUser.getRole());

    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
    public boolean isAdmin(@Valid @PathVariable String username) {
        //Return True: User has role: 'ROLE_ADMIN'
        //Return False: User has role: 'ROLE_USER'
        boolean isAdmin = false;
        User currentUser = userDao.findByUsername(username);
        for (Authority authority : currentUser.getAuthorities()) {
            if (authority.getName().equals("ROLE_ADMIN")) {
                isAdmin = true;
                break;
            }
        }

        return isAdmin;
    }

}

/*
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
guhguhguhguhguhguhguhguhguh
 */

