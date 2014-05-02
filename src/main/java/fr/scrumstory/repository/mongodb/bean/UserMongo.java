package fr.scrumstory.repository.mongodb.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Document(collection = "users")
public class UserMongo {

    @Id
    @Getter @Setter
    private String id;

    @Getter @Setter
    private String login;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

}
