package fr.scrumstory.repository.mongodb;

import fr.scrumstory.domain.Project;
import fr.scrumstory.repository.mongodb.bean.ProjectMongo;
import fr.scrumstory.repository.mongodb.bean.core.CounterMongo;
import fr.scrumstory.repository.mongodb.impl.SequenceRepositoryMongo;
import fr.scrumstory.repository.mongodb.impl.ProjectRepositoryMongo;
import fr.scrumstory.repository.mongodb.spring.ProjectSpringMongo;
import fr.scrumstory.tools.ScrumStoryExceptionMatcher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class TUProjectDaoMongo extends AbstractMongoTest {

	@Autowired
	private ProjectRepositoryMongo projectRepositoryMongo;
	
	@Autowired
	private ProjectSpringMongo projectRepository;

    @Autowired
    private SequenceRepositoryMongo sequenceRepositoryMongo;

    @Test
	public void createProject() {
		// Arrange
		Project project = new Project();
		project.setName("name");
		project.setDescription("description");
		project.setCode("CODE");


		// Act
		projectRepositoryMongo.create(project);
		
		// Assert
        List<ProjectMongo> projects = projectRepository.findAll();
        assertEquals(1, projects.size());
        ProjectMongo projectMongo = projects.get(0);
		assertEquals("name", projectMongo.getName());
		assertEquals("CODE", projectMongo.getCode());
		assertEquals("description", projectMongo.getDescription());

        List<CounterMongo> sequences = mongoTemplate.findAll(CounterMongo.class);
        assertEquals(1, sequences.size());
        assertEquals("CODE", sequences.get(0).getName());
        assertEquals(1, sequences.get(0).getSequence());
	}


    @Test
    public void createTwoProjectWithSameCode() {
        // Arrange
        Project project1 = new Project();
        project1.setName("name 1");
        project1.setDescription("description 1");
        project1.setCode("CODE");

        Project project2 = new Project();
        project2.setName("name 2");
        project2.setDescription("description 2");
        project2.setCode("CODE");

        // Assert
        assertException.expect(ScrumStoryExceptionMatcher.hasCode("project.duplicate.code"));

        // Act
        projectRepositoryMongo.create(project1);
        projectRepositoryMongo.create(project2);

    }
}
