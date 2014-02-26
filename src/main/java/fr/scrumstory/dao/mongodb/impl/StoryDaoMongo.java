package fr.scrumstory.dao.mongodb.impl;

import fr.scrumstory.dao.IStoryDao;
import fr.scrumstory.dao.mongodb.bean.StoryMongo;
import fr.scrumstory.dao.mongodb.spring.StoryMongoRepository;
import fr.scrumstory.domain.Story;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoryDaoMongo implements IStoryDao {

    @Autowired
    private StoryMongoRepository storyMongoRepository;

    @Autowired
    private Mapper mapper;

    public String create(Story story) {
        StoryMongo storyMongo = mapper.map(story, StoryMongo.class);
        storyMongo = storyMongoRepository.save(storyMongo);
        return storyMongo.getId();
    }

}
