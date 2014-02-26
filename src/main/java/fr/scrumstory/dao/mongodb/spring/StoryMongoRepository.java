package fr.scrumstory.dao.mongodb.spring;

import fr.scrumstory.dao.mongodb.bean.StoryMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoryMongoRepository extends MongoRepository<StoryMongo, String> {

    StoryMongo findByName(String name);

    StoryMongo findByCodeProjectAndKey(String codeProject, Integer key);

}
