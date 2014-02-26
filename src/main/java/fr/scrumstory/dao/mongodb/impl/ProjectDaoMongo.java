package fr.scrumstory.dao.mongodb.impl;

import fr.scrumstory.dao.IProjectDao;
import fr.scrumstory.dao.mongodb.bean.ProjectMongo;
import fr.scrumstory.dao.mongodb.spring.ProjectSpringRepository;
import fr.scrumstory.domain.Project;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDaoMongo implements IProjectDao {

    @Autowired
    private ProjectSpringRepository projectRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public Project create(Project project) {
        ProjectMongo projectMongo = mapper.map(project, ProjectMongo.class);
        projectMongo = projectRepository.save(projectMongo);
        return mapper.map(projectMongo, Project.class);
    }

    @Override
    public Project findByCode(String code) {
        ProjectMongo projectMongo = projectRepository.findByCode(code);
        return mapper.map(projectMongo, Project.class);
    }

    @Override
    public void update(Project project) {
        ProjectMongo projectMongo = mapper.map(project, ProjectMongo.class);
        projectMongo = projectRepository.save(projectMongo);
    }

}
