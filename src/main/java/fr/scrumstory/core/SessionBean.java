package fr.scrumstory.core;

import fr.scrumstory.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.util.Locale;

/**
 * Classe représentant une session utilisateur.
 */
public class SessionBean {

    /** Utilisateur courant */
    @Getter
    private User user;

    /** Langue de l'utilisateur courant */
    @Getter @Setter
    private Locale localeUser;

    public void setUser(User user) {
        this.user = user;
        localeUser = Locale.forLanguageTag(user.getLanguage());
    }
}
