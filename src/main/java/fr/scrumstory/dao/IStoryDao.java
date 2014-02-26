package fr.scrumstory.dao;

import fr.scrumstory.domain.Story;

/**
 * Classe d'accés au données de type projet.
 */
public interface IStoryDao {

    public String create(Story story);
}
