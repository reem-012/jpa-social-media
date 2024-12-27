package com.social_media.social_media.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social_media.social_media.models.SocialUser;
import com.social_media.social_media.repositories.SocialUserRepository;

@Service
public class SocialService {

    @Autowired
    SocialUserRepository socialUserRepository;

    public List<SocialUser> getAllUsers(){
        return socialUserRepository.findAll();
    }

    public SocialUser createUser(SocialUser socialUser){
        return socialUserRepository.save(socialUser);
    }

    public boolean deleteUser(Long id){
        SocialUser socialUser = socialUserRepository.findById(id).orElseThrow(()-> new RuntimeException("User Not Found"));
        socialUserRepository.delete(socialUser);
        return true;
    }

}
