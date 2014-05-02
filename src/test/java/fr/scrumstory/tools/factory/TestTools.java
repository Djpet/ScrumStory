package fr.scrumstory.tools.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Classe utilitaires de création de données pour les tests.
 */
@Component
public class TestTools {


    @Autowired
    private UserTestTool userTestTool;

    @Autowired
    private ProjectTestTool projectTestTool;

    @Autowired
    private StoryTestTool storyTestTool;

    /**
     * Accès à la fabrique de test pour les User.
     * @return User factory
     */
    public UserTestTool user() {
        return userTestTool;
    }

    /**
     * Accès à la fabrique de test pour les Project.
     * @return Project factory
     */
    public ProjectTestTool project() {
        return projectTestTool;
    }

    /**
     * Accès à la fabrique de test pour les Story.
     * @return Story factory
     */
    public StoryTestTool story() { return storyTestTool; }
}
