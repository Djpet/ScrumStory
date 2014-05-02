package fr.scrumstory.factory;

import fr.scrumstory.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class DomainFactory {

    @Autowired
    private AutowireCapableBeanFactory autowireBeanFactory;

    /**
     * Inject beans in object domain.
     * @param objectDomain : the object domain
     */
    public <T> void  autowireProject(T objectDomain) {
        autowireBeanFactory.autowireBean(objectDomain);
    }

    /**
     * Create Project Spring Bean.
     * @return a project.
     */
    public Project createProject() {
        return autowireBeanFactory.getBean(Project.class);
    }

}
