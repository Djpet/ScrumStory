package fr.scrumstory.repository.mongodb.impl;

import fr.scrumstory.repository.IStoryRepository;
import fr.scrumstory.repository.mongodb.bean.StoryMongo;
import fr.scrumstory.repository.mongodb.spring.StorySpringMongo;
import fr.scrumstory.domain.Story;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoryRepositoryMongo implements IStoryRepository {

    @Autowired
    private StorySpringMongo storySpringMongo;

    @Autowired
    private SequenceRepositoryMongo sequenceRepositoryMongo;



    @Autowired
    private Mapper mapper;

    public String create(Story story) {
        StoryMongo storyMongo = mapper.map(story, StoryMongo.class);

        storyMongo.setKey(sequenceRepositoryMongo.getNextIntSequence(story.getProjectCode()));
        storyMongo = storySpringMongo.save(storyMongo);
        return storyMongo.getId();
    }

}
