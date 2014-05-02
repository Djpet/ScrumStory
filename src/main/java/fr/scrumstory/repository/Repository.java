package fr.scrumstory.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Repository générale.
 */
@org.springframework.stereotype.Repository
public class Repository {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IProjectRepository projectRepository;

    @Autowired
    private IStoryRepository storyRepository;

    /**
     * Accès au repository User.
     * @return repository User
     */
    public IUserRepository user() {
        return userRepository;
    }

    /**
     * Accès au repository Project.
     * @return repository Project
     */
    public IProjectRepository project() {
        return projectRepository;
    }

    /**
     * Accès au repository Story.
     * @return repository Story
     */
    public IStoryRepository story() {
        return storyRepository;
    }

}
