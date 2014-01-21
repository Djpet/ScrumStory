package fr.scrumsotry.dao.mongodb.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.scrumsotry.bean.Story;
import fr.scrumsotry.dao.IStoryDao;
import fr.scrumsotry.dao.mongodb.bean.StoryMongo;
import fr.scrumsotry.dao.mongodb.spring.StoryMongoRepository;


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
