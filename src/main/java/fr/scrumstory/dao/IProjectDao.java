package fr.scrumstory.dao;

import fr.scrumstory.domain.Project;

/**
 * Classe d'accés au données de type projet.
 */
public interface IProjectDao {

    public Project create(Project project);

    public Project findByCode(String code);

    public void update(Project project);
}
