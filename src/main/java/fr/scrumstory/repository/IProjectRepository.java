package fr.scrumstory.repository;

import fr.scrumstory.domain.Project;

import java.util.List;

/**
 * Classe d'accès au données de type projet.
 */
public interface IProjectRepository {

    Project create(Project project);

    Project findByCode(String code);

    void update(Project project);

    List<Project> getAll();
}
