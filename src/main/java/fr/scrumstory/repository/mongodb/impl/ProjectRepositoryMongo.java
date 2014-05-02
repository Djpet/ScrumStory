package fr.scrumstory.repository.mongodb.impl;

import fr.scrumstory.repository.IProjectRepository;
import fr.scrumstory.repository.mongodb.bean.ProjectMongo;
import fr.scrumstory.repository.mongodb.spring.ProjectSpringMongo;
import fr.scrumstory.domain.Project;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepositoryMongo implements IProjectRepository {

    @Autowired
    private ProjectSpringMongo projectSpringMongo;

    @Autowired
    private Mapper mapper;

    @Override
    public Project create(Project project) {
        ProjectMongo projectMongo = mapper.map(project, ProjectMongo.class);
        projectMongo = projectSpringMongo.save(projectMongo);
        return mapper.map(projectMongo, Project.class);
    }

    @Override
    public Project findByCode(String code) {
        ProjectMongo projectMongo = projectSpringMongo.findByCode(code);
        return mapper.map(projectMongo, Project.class);
    }

    @Override
    public void update(Project project) {
        ProjectMongo projectMongo = mapper.map(project, ProjectMongo.class);
        projectMongo = projectSpringMongo.save(projectMongo);
    }

}
