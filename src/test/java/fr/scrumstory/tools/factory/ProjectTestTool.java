package fr.scrumstory.tools.factory;

import fr.scrumstory.domain.Project;
import fr.scrumstory.tools.RandomManager;
import org.springframework.stereotype.Component;

/**
 * Fabrique de test pour les Project.
 */
@Component
public class ProjectTestTool extends  AbstractTestTool{

    public Project create() {
        Project project = new Project();
        project.setCode(RandomManager.randomLetter(3));
        project.setName(RandomManager.randomString());
        project.setDescription(RandomManager.randomString());


        domainFactory.autowireProject(project);
        return project;
    }
}
