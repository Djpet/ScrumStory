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

import java.util.List;

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


    @Test
    public void createTwoStoryWithNextSequence() {
        // Arrange
        Story story1 = new Story();
        story1.setName("Story 1");
        story1.setDescription("Description 1");
        story1.setProjectCode("CODE");

        Story story2 = new Story();
        story2.setName("Story 2");
        story2.setDescription("Description 2");
        story2.setProjectCode("CODE");

        sequenceRepositoryMongo.createSequence("CODE");

        // Act
        storyRepositoryMongo.create(story1);
        storyRepositoryMongo.create(story2);

        // Assert
        List<StoryMongo> stories = storyRepository.findAll();
        assertEquals(2, stories.size());
        assertEquals("Story 1", stories.get(0).getName());
        assertEquals(1, stories.get(0).getKey().intValue());
        assertEquals("Story 2", stories.get(1).getName());
        assertEquals(2, stories.get(1).getKey().intValue());
    }
}
