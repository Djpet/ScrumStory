package fr.scrumstory.service;

import fr.scrumstory.domain.Project;
import fr.scrumstory.factory.DomainFactory;
import fr.scrumstory.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

/**
 * Service d'exposition REST des méthodes pour les projets.
 */
@Service
public class ProjectService {

    @Autowired
    private DomainFactory domainFactory;

    @Autowired
    private Repository repository;

    public void create(Project project) {
        Project springProject = domainFactory.autowireProject(project);
        springProject.create();
    }

    public List<Project> getAll() {
        return repository.project().getAll();
    }
}
