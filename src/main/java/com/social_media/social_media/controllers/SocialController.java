package com.social_media.social_media.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.social_media.social_media.models.SocialUser;
import com.social_media.social_media.services.SocialService;

@RestController
public class SocialController {
    @Autowired
    private SocialService SocialService;
    
    @GetMapping("social/users")
    public ResponseEntity<List<SocialUser>> getUsers(){
        return new ResponseEntity<>(SocialService.getAllUsers(),HttpStatus.OK);
    }

    @PostMapping("social/users")
    public ResponseEntity<SocialUser> saveUser(@RequestBody SocialUser socialUser){
        return new ResponseEntity<>(SocialService.createUser(socialUser),HttpStatus.CREATED);
    }

    @DeleteMapping("social/users/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(SocialService.deleteUser(id),HttpStatus.OK);
    }
}
