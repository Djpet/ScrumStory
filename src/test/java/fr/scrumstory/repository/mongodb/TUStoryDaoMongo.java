package fr.scrumstory.repository.mongodb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import fr.scrumstory.repository.mongodb.impl.SequenceRepositoryMongo;
import fr.scrumstory.repository.mongodb.spring.StorySpringMongo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.scrumstory.repository.mongodb.bean.StoryMongo;
import fr.scrumstory.repository.mongodb.impl.StoryRepositoryMongo;
import fr.scrumstory.domain.Story;


public class TUStoryDaoMongo extends AbstractMongoTest {

	@Autowired
	private StoryRepositoryMongo storyRepositoryMongo;
	
	@Autowired
	private StorySpringMongo storyRepository;

    @Autowired
    private SequenceRepositoryMongo sequenceRepositoryMongo;

    @Test
	public void createStory() {
		// Arrange
		Story story = new Story();
		story.setName("name");
		story.setDescription("description");
		story.setProjectCode("CODE");

        sequenceRepositoryMongo.createSequence("CODE");

		// Act
		storyRepositoryMongo.create(story);
		
		// Assert
		StoryMongo storyMongo = storyRepository.findByProjectCodeAndKey("CODE", 1);
		assertNotNull(storyMongo);
		assertEquals("name", storyMongo.getName());
		assertEquals("CODE", storyMongo.getProjectCode());
		assertEquals(1, storyMongo.getKey().intValue());
		assertEquals("description", storyMongo.getDescription());
	}
	
}
