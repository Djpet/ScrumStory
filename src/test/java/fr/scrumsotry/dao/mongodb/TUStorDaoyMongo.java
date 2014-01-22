package fr.scrumsotry.dao.mongodb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.scrumsotry.dao.mongodb.bean.StoryMongo;
import fr.scrumsotry.dao.mongodb.impl.StoryDaoMongo;
import fr.scrumsotry.dao.mongodb.spring.StoryMongoRepository;
import fr.scrumsotry.domain.Story;


public class TUStorDaoyMongo extends AbstractMongoTest {

	@Autowired
	private StoryDaoMongo storyDaoMongo;
	
	@Autowired
	private StoryMongoRepository storyRepository;
	
	@Test
	public void createStory() {
		// Arrange
		Story story = new Story();
		story.setName("name");
		story.setDescription("description");
		story.setCodeProject("CODE");
		story.setKey(100);
		
		// Act
		storyDaoMongo.create(story);
		
		// Assert
		StoryMongo storyMongo = storyRepository.findByCodeProjectAndKey("CODE", 100);
		assertNotNull(storyMongo);
		assertEquals(story.getName(), storyMongo.getName());
		assertEquals(story.getCodeProject(), storyMongo.getCodeProject());
		assertEquals(story.getKey(), storyMongo.getKey());
		assertEquals(story.getDescription(), storyMongo.getDescription());
	}
	
}
