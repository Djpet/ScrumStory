package fr.scrumstory.core.resource;

import fr.scrumstory.core.SessionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageBundle {

    @Autowired private MessageSource messageSource;

    @Autowired private SessionBean sessionBean;

    public String getMessage(String code) {
        return getMessage(code, null);
    }

    public String getMessage(String code, Object[] args) {
        if (sessionBean == null || sessionBean.getLocaleUser() == null) {
            return messageSource.getMessage(code, args, Locale.FRENCH);
        }
        return messageSource.getMessage(code, args, sessionBean.getLocaleUser());
    }
}
