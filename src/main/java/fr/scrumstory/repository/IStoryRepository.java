package fr.scrumstory.repository;

import fr.scrumstory.domain.Story;

/**
 * Classe d'accès au données de type projet.
 */
public interface IStoryRepository {

    public String create(Story story);
}
