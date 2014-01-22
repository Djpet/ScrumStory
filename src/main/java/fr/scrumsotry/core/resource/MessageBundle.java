package fr.scrumsotry.core.resource;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import fr.scrumsotry.core.SessionBean;

@Component
public class MessageBundle {

	@Autowired private MessageSource messageSource;
	
	@Autowired private SessionBean sessionBean;
	
	public String getMessage(String code) {
		if (sessionBean == null || sessionBean.getLocaleUser() == null) {
			return messageSource.getMessage(code, null, Locale.ENGLISH);
		}
		return messageSource.getMessage(code, null, sessionBean.getLocaleUser());
	}
}
