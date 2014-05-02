package fr.scrumstory.domain;

import fr.scrumstory.core.GenericValidatorBean;
import fr.scrumstory.repository.IProjectRepository;
import fr.scrumstory.repository.Repository;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Slf4j
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Project {

    @Getter @Setter
    private String id;

    @NotBlank(message = "project.code.mandatory")
    @Size(min = 3, max = 6, message = "project.code.size")
    @Pattern(regexp = "[a-zA-Z]*", message = "project.code.notAlpha")
    @Getter @Setter
    private String code;

    @NotBlank(message = "project.name.mandatory")
    @Getter @Setter
    private String name;

    @NotBlank(message = "project.description.mandatory")
    @Getter @Setter
    private String description;

    @Autowired
    private Repository repository;

    @Autowired
    private GenericValidatorBean validator;

    public void create() {
        log.debug("BEGIN create Project");
        validator.validate(this);
        repository.project().create(this);
        log.debug("END create project");
    }
}
