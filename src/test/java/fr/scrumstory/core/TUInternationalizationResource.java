package fr.scrumstory.core;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.scrumstory.AbstractSpringTest;
import fr.scrumstory.core.resource.MessageBundle;

public class TUInternationalizationResource extends AbstractSpringTest {
	
	@Autowired
	private MessageBundle messageBundle;

	@Test
	public void checkMessagesFileInEnglish() {
		sessionBean.setLocaleUser(Locale.ENGLISH);
		assertEquals("ENGLISH",
				messageBundle.getMessage("exception.activeLanguage"));
		assertEquals("ENGLISH",
				messageBundle.getMessage("validation.activeLanguage"));
	}

	@Test
	public void checkMessagesFileInFrench() {
		sessionBean.setLocaleUser(Locale.FRENCH);
		assertEquals("FRANCAIS",
				messageBundle.getMessage("exception.activeLanguage"));
		assertEquals("FRANCAIS",
				messageBundle.getMessage("validation.activeLanguage"));
	}

	@Test
	public void checkMessagesFileNoLocaleUser() {
		sessionBean.setLocaleUser(null);
		assertEquals("ENGLISH",
				messageBundle.getMessage("exception.activeLanguage"));
	}
}
