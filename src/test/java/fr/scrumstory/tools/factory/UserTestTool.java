package fr.scrumstory.tools.factory;

import fr.scrumstory.domain.User;
import fr.scrumstory.tools.RandomManager;
import org.springframework.stereotype.Component;

/**
 * Fabrique de test pour les User.
 */
@Component
public class UserTestTool extends AbstractTestTool {

    /**
     * Crée un utilisateur avec des champs aléatoire.
     *
     * @return utilisateur
     */
    public User create() {
        User user = new User();
        user.setId(RandomManager.randomId());
        user.setLogin(RandomManager.randomString());
        user.setFirstName(RandomManager.randomString());
        user.setLastName(RandomManager.randomString());
        user.setEmail(RandomManager.randomString() + "@test.fr");
        user.setLanguage(RandomManager.randomString("fr-FR", "en-EN"));
        domainFactory.autowireProject(user);
        return user;
    }

    /**
     * Crée un utilisateur qui sera utilisé dans la session pour chaque test.<br />
     * Champs fixes :
     * <ul>
     * <li>id=1</li>
     * <li>login=test</li>
     * <li>firstname=te</li>
     * <li>lastname=st</li>
     * <li>email=test@test.fr</li>
     * <li>language=fr-FR</li>
     * </ul>
     *
     * @return utilisateur
     */
    public User createUserSessionBeanTest() {
        User user = new User();
        user.setId("1");
        user.setLogin("test");
        user.setFirstName("te");
        user.setLastName("st");
        user.setEmail("test@test.fr");
        user.setLanguage("fr-FR");
        return user;
    }
}
