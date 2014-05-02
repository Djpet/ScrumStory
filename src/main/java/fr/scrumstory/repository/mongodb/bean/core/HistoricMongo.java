package fr.scrumstory.repository.mongodb.bean.core;

import fr.scrumstory.repository.mongodb.bean.UserMongo;
import fr.scrumstory.util.DateManager;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * Représente une ligne d'historique pour la modification des objets.
 */
public class HistoricMongo {

    @Getter @Setter
    private LocalDateTime dateTime;

    @DBRef
    @Getter @Setter
    private UserMongo user;

    @Getter @Setter
    private List<HistoricOldValueMongo> oldValues;

    public HistoricMongo() {
        dateTime = DateManager.now();
        oldValues = new LinkedList<>();
    }

    /**
     * Ajoute une ancienne valeur à l'historique.
     * @param attribute : champ modifié
     * @param oldValue : ancienne valeur du champ
     */
    public void addOldValue(String attribute, String oldValue) {
        HistoricOldValueMongo historicOldValueMongo = new HistoricOldValueMongo();
        historicOldValueMongo.setAttribute(attribute);
        historicOldValueMongo.setOldValue(oldValue);
        oldValues.add(historicOldValueMongo);
    }

}
