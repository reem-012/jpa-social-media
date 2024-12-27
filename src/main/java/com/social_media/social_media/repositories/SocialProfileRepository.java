package com.social_media.social_media.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social_media.social_media.models.SocialProfile;

public interface SocialProfileRepository extends JpaRepository<SocialProfile, Long>{

    
}