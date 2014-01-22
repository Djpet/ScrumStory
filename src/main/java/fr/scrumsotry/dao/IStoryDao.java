package fr.scrumsotry.dao;

import fr.scrumsotry.domain.Story;

/**
 * Classe d'accés au données de type projet.
 */
public interface IStoryDao  {

	public String create(Story story);
}
