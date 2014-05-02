package fr.scrumstory.domain;

import fr.scrumstory.AbstractSpringTest;
import fr.scrumstory.repository.IProjectRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Classe de Test du domain project.
 */
public class TUProject extends AbstractSpringTest{

    @Autowired
    private IProjectRepository mockProjectRepository;

    /**
     * Test la création d'un projet.
     */
    @Test
    public void testCreate() {
        Project project = tools.project().create();
        project.create();
        verify(mockProjectRepository).create(project);
    }
}
