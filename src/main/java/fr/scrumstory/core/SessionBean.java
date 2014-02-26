package fr.scrumstory.core;

import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

/**
 * Classe représentant une session utilisateur.
 */
public class SessionBean {

    @Getter @Setter
    private Locale localeUser;

}
