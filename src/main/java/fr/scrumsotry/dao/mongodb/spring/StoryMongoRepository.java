package fr.scrumsotry.dao.mongodb.spring;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.scrumsotry.dao.mongodb.bean.StoryMongo;

public interface StoryMongoRepository extends MongoRepository<StoryMongo, String> {

	StoryMongo findByName(String name);
	StoryMongo findByCodeProjectAndKey(String codeProject, Integer key);

}
