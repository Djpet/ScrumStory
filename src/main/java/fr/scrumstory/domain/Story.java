package fr.scrumstory.domain;

import fr.scrumstory.core.GenericValidatorBean;
import fr.scrumstory.repository.IProjectRepository;
import fr.scrumstory.repository.IStoryRepository;
import fr.scrumstory.repository.Repository;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Slf4j
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Story {

    @Getter @Setter
    private String id;

    @Getter @Setter
    private Integer key;

    @NotNull
    @Getter @Setter
    private String projectCode;

    @NotNull
    @Getter @Setter
    private String name;

    @NotNull
    @Getter @Setter
    private String description;

    @Autowired
    private GenericValidatorBean validator;

    @Autowired
    private Repository repository;

    public void create() {
        log.debug("BEGIN create Story");
        validator.validate(this);
        repository.story().create(this);
        log.debug("END create Story");
    }

}
