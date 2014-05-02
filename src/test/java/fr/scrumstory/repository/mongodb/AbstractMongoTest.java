package fr.scrumstory.repository.mongodb;

import fr.scrumstory.AbstractMockitoTest;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testContextWithMongoRepo.xml")
public abstract class AbstractMongoTest extends AbstractMockitoTest {

    @Autowired
    protected MongoTemplate mongoTemplate;

    @Before
    public void cleanCollections() {
        Set<String> collections = mongoTemplate.getCollectionNames();
        for (String collection : collections) {
            if (!collection.startsWith("system.")) {
                mongoTemplate.dropCollection(collection);
            }
        }
    }

}
