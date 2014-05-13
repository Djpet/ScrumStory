package fr.scrumstory.repository.mongodb.impl;

import fr.scrumstory.core.exception.ScrumStoryException;
import fr.scrumstory.domain.Project;
import fr.scrumstory.repository.IProjectRepository;
import fr.scrumstory.repository.mongodb.bean.ProjectMongo;
import fr.scrumstory.repository.mongodb.spring.ProjectSpringMongo;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class ProjectRepositoryMongo implements IProjectRepository {

    @Autowired
    private ProjectSpringMongo projectSpringMongo;

    @Autowired
    private SequenceRepositoryMongo sequenceRepositoryMongo;

    @Autowired
    private Mapper mapper;

    @Override
    public Project create(Project project) {
        try {
            ProjectMongo projectMongo = mapper.map(project, ProjectMongo.class);
            projectMongo = projectSpringMongo.save(projectMongo);
            sequenceRepositoryMongo.createSequence(project.getCode());
            return mapper.map(projectMongo, Project.class);
        } catch (DuplicateKeyException e) {
            throw new ScrumStoryException("project.duplicate.code", e);
        }
    }

    @Override
    public Project findByCode(String code) {
        ProjectMongo projectMongo = projectSpringMongo.findByCode(code);
        return mapper.map(projectMongo, Project.class);
    }

    @Override
    public void update(Project project) {
        ProjectMongo projectToSave = mapper.map(project, ProjectMongo.class);
        ProjectMongo projectInDB = projectSpringMongo.findOne(projectToSave.getId());
        if (projectInDB.getCode().equals(projectToSave)) {
            projectSpringMongo.save(projectToSave);
        } else {
            throw new ScrumStoryException("project.update.code");
        }
    }

    @Override
    public List<Project> getAll() {
        List<ProjectMongo> projectsInDB = projectSpringMongo.findAll();
        List<Project> projects = new LinkedList<>();
        for (ProjectMongo projectMongo : projectsInDB) {
            projects.add(mapper.map(projectMongo, Project.class));
        }
        return projects;
    }

}
