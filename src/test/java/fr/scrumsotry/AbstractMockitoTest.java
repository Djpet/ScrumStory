package fr.scrumsotry;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

public abstract class AbstractMockitoTest extends AbstractTest {

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
}
