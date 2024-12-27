package com.social_media.social_media;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.social_media.social_media.models.Post;
import com.social_media.social_media.models.SocialGroup;
import com.social_media.social_media.models.SocialProfile;
import com.social_media.social_media.models.SocialUser;
import com.social_media.social_media.repositories.PostRepository;
import com.social_media.social_media.repositories.SocialGroupRepository;
import com.social_media.social_media.repositories.SocialProfileRepository;
import com.social_media.social_media.repositories.SocialUserRepository;

@Configuration
public class DataInitializer {

    private final SocialUserRepository socialUserRepository;
    private final SocialProfileRepository socialProfileRepository;
    private final PostRepository postRepository;
    private final SocialGroupRepository socialGroupRepository;

    public DataInitializer(SocialUserRepository socialUserRepository, SocialGroupRepository socialGroupRepository, 
        SocialProfileRepository socialProfileRepository, PostRepository postRepository){
        this.socialUserRepository = socialUserRepository;
        this.socialGroupRepository = socialGroupRepository;
        this.socialProfileRepository = socialProfileRepository;
        this.postRepository = postRepository;
    }

    @Bean
    public CommandLineRunner initializeData(){
        return (args -> {
            // Create some users
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            // Save Users to the Database

            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);

            // Create some groups
            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            // Add users to the groups 

            group1.getSocialUsers().add(user1);
            group1.getSocialUsers().add(user2);

            group2.getSocialUsers().add(user2);
            group2.getSocialUsers().add(user3);

            // Save the Groups
            socialGroupRepository.save(group1);
            socialGroupRepository.save(group2);

            // Add Groups to Users
            user1.getGroups().add(group1);
            user2.getGroups().add(group1);

            user2.getGroups().add(group2);
            user3.getGroups().add(group2);

            // Save users 
            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);

            // Create Some Posts
            Post post1 = new Post();
            Post post2 = new Post();
            Post post3 = new Post();
            Post post4 = new Post();

            // Associate the posts with a user

            post1.setSocialUser(user1);
            post2.setSocialUser(user2);
            post3.setSocialUser(user3);
            post4.setSocialUser(user1);

            // Save the posts into the database
            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);
            postRepository.save(post4);

            // Create Profiles
            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();

            // Associated the profile with a user
            profile1.setUser(user1);
            profile2.setUser(user2);
            profile3.setUser(user3);

            // Save the profile
            socialProfileRepository.save(profile1);
            socialProfileRepository.save(profile2);
            socialProfileRepository.save(profile3);

            // Show Fetch Types
            System.out.println("Find our User");

            socialUserRepository.findById(1L);

        });
    }
}
