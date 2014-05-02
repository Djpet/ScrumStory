package fr.scrumstory.repository.mongodb.spring;

import fr.scrumstory.repository.mongodb.bean.ProjectMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectSpringMongo extends MongoRepository<ProjectMongo, String> {

    ProjectMongo findByCode(String code);

}
