package fr.scrumstory.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Slf4j
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class User {

    @Getter @Setter
    private String id;

    @NotNull
    @Getter @Setter
    private String login;

    @NotNull
    @Getter @Setter
    private String email;

    @NotNull
    @Getter @Setter
    private String firstName;

    @NotNull
    @Getter @Setter
    private String lastName;

    @NotNull
    @Getter @Setter
    private String language;
}
