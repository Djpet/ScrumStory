package fr.scrumstory.repository.mongodb.bean;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "projects")
public class ProjectMongo {

    @Id
    @Getter @Setter
    private String id;

    @Getter @Setter
    private String name;

    @Indexed(unique = true)
    @Getter @Setter
    private String code;

    @Getter @Setter
    private String description;

}
