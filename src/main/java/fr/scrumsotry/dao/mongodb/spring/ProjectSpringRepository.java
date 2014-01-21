package fr.scrumsotry.dao.mongodb.spring;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.scrumsotry.dao.mongodb.bean.ProjectMongo;

public interface ProjectSpringRepository extends MongoRepository<ProjectMongo, String> {

	ProjectMongo findByCode(String code);

}
