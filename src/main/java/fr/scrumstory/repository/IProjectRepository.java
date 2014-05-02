package fr.scrumstory.repository;

import fr.scrumstory.domain.Project;

/**
 * Classe d'accès au données de type projet.
 */
public interface IProjectRepository {

    public Project create(Project project);

    public Project findByCode(String code);

    public void update(Project project);
}
