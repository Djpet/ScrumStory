package fr.scrumstory.repository.mongodb.bean.core;

import lombok.Getter;
import lombok.Setter;

/**
 *
 */
public class HistoricOldValueMongo {

    @Getter @Setter
    private String attribute;

    @Getter @Setter
    private String oldValue;
}
