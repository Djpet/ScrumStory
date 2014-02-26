package fr.scrumstory.dao.mongodb.spring;

import fr.scrumstory.dao.mongodb.bean.ProjectMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectSpringRepository extends MongoRepository<ProjectMongo, String> {

    ProjectMongo findByCode(String code);

}
