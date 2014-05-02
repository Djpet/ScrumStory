package fr.scrumstory.repository.mongodb.impl;

import fr.scrumstory.repository.mongodb.bean.core.CounterMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 * Classe de gestion des séquences pour les autres repositories.
 */
@Repository
public class SequenceRepositoryMongo {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Créer une séquence commençant à 1.
     *
     * @param sequenceName : nom de la séquence
     */
    public void createSequence(String sequenceName) {
       createSequence(sequenceName, 1);
    }

    /**
     * Créer une séquence commençant à nombre défini.
     *
     * @param sequenceName : nom de la séquence
     * @param startNumber : première valeur retourné par la séquence.
     */
    public void createSequence(String sequenceName, long startNumber) {
        CounterMongo counterMongo = new CounterMongo();
        counterMongo.setName(sequenceName);
        counterMongo.setSequence(startNumber);
        mongoTemplate.insert(counterMongo);
    }

    /**
     * Retourne la valeur suivante de la séquence.
     *
     * @param sequenceName : nom de la séquence
     * @return valeur suivante
     */
    public long getNextSequence(String sequenceName) {
        Query query = new Query(Criteria.where("name").is(sequenceName));
        Update update = new Update().inc("sequence", 1);
        CounterMongo counter = mongoTemplate.findAndModify(query, update, CounterMongo.class);
        return counter.getSequence();
    }

    /**
     * Retourne la valeur suivante de la séquence.
     *
     * @param sequenceName : nom de la séquence
     * @return valeur suivante
     */
    public int getNextIntSequence(String sequenceName) {
        return (int) getNextSequence(sequenceName);
    }
}
