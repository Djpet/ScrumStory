package fr.scrumstory.repository.mongodb.bean.core;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Classe utilisé pour représenter une séquence.
 */

@Document(collection = "counters")
public class CounterMongo {

    @Indexed(unique = true)
    @Getter @Setter
    private String name;

    @Getter @Setter
    private long sequence;

}
