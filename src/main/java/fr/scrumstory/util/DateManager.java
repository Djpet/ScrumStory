package fr.scrumstory.util;

import com.sun.corba.se.impl.presentation.rmi.ReflectiveTie;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Utilitaire pour la gestion des dates.
 */
public final class DateManager {

    @Setter
    private static LocalDateTime localDateTime;

    /**
     * Retourne la date spécifiée ou la date courante si cette première n'est pas définie.
     * @return la date spécifiée ou la date courante
     */
    public static LocalDateTime now() {
        if (localDateTime == null) {
            return LocalDateTime.now();
        }
        return localDateTime;
    }
}
