package com.social_media.social_media.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.social_media.social_media.models.SocialUser;

public interface SocialUserRepository extends JpaRepository<SocialUser,Long>{
    
}