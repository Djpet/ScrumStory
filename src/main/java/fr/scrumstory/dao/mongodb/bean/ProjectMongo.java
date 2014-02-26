package fr.scrumstory.dao.mongodb.bean;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

public class ProjectMongo {

    @Id
    @Getter @Setter
    private String id;

    @Getter @Setter
    private String code;

    @Getter @Setter
    private String name;

    @NotBlank
    @Getter @Setter
    private String description;

}
