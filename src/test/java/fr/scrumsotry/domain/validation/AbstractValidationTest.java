package fr.scrumsotry.domain.validation;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;

import fr.scrumsotry.AbstractSpringTest;
import fr.scrumsotry.core.GenericValidatorBean;
import fr.scrumsotry.core.exception.ValidationException;
import fr.scrumsotry.core.exception.ValidationMatcher;
import fr.scrumsotry.core.resource.MessageBundle;

public abstract class AbstractValidationTest extends AbstractSpringTest {

	@Mock
	private MessageBundle messageBundle;
	
	@Autowired
	@InjectMocks
	protected GenericValidatorBean validatorBean;


	protected ValidationMatcher validationMatcher;
	
	public AbstractValidationTest() {
		super();
		validationMatcher = new ValidationMatcher();
	}

	@Before
	public void setUp() {
		when(messageBundle.getMessage(anyString())).thenAnswer(
				new Answer<String>() {
					@Override
					public String answer(InvocationOnMock invocation)
							throws Throwable {
						Object[] args = invocation.getArguments();
						return (String) args[0];
					}
				});
	}

}