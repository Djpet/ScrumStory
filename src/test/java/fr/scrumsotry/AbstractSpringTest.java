package fr.scrumsotry;

import java.util.Locale;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.scrumsotry.core.SessionBean;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-application-context.xml")
public abstract class AbstractSpringTest extends AbstractMockitoTest {

	@Autowired
	protected SessionBean sessionBean;
	
	@Before
	public void initSessionBean() {
		sessionBean.setLocaleUser(Locale.ENGLISH);
	}
}
