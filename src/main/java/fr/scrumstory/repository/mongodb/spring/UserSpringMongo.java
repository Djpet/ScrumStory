package fr.scrumstory.repository.mongodb.spring;

import fr.scrumstory.repository.mongodb.bean.ProjectMongo;
import fr.scrumstory.repository.mongodb.bean.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Interface Mongo/Spring pour la persistance des utilisateurs.
 */
public interface UserSpringMongo extends MongoRepository<UserMongo, String> {

}
