package fr.scrumstory.repository;

import fr.scrumstory.domain.User;

/**
 * Classe d'accès au données de type utilisateur.
 */
public interface IUserRepository {

    /**
     * Persiste un utilisateur.
     * @param user : l'utilisateur
     * @return id de l'utilisateur
     */
    String create(User user);
}
