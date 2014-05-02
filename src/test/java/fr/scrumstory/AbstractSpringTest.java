package fr.scrumstory;

import fr.scrumstory.core.SessionBean;
import fr.scrumstory.domain.User;
import fr.scrumstory.factory.DomainFactory;
import fr.scrumstory.tools.factory.TestTools;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Locale;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(initializers = MockitoInitializer.class, locations = "classpath:testContextWithMemoryRepo.xml")
public abstract class AbstractSpringTest extends AbstractMockitoTest {

//    @Autowired
//    protected DomainFactory domainFactory;

    @Autowired
    protected TestTools tools;

    @Autowired
    protected SessionBean sessionBean;

    @Before
    public void initSessionBean() {
        sessionBean.setUser(tools.user().createUserSessionBeanTest());
    }
}
