package fr.scrumstory.repository.mongodb.impl;

import fr.scrumstory.domain.User;
import fr.scrumstory.repository.IUserRepository;
import fr.scrumstory.repository.mongodb.bean.UserMongo;
import fr.scrumstory.repository.mongodb.spring.UserSpringMongo;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implémentation du repository de persistance des utilisateurs.
 */
@Repository
public class UserRepositoryMongo implements IUserRepository {

    @Autowired
    private UserSpringMongo userSpringMongo;

    @Autowired
    private Mapper mapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public String create(User user) {
        UserMongo userMongo = mapper.map(user, UserMongo.class);

        userMongo = userSpringMongo.save(userMongo);
        return userMongo.getId();
    }

}
