package fr.scrumstory.repository.mongodb.spring;

import fr.scrumstory.repository.mongodb.bean.StoryMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StorySpringMongo extends MongoRepository<StoryMongo, String> {

    StoryMongo findByName(String name);

    StoryMongo findByProjectCodeAndKey(String projectCode, Integer key);

}
