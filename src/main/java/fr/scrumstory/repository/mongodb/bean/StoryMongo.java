package fr.scrumstory.repository.mongodb.bean;

import fr.scrumstory.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stories")
public class StoryMongo {

    @Id
    @Getter @Setter
    private String id;

    @Getter @Setter
    private Integer key;

    @Getter @Setter
    private String projectCode;

    @Indexed(unique =  true)
    @Getter @Setter
    private String name;

    @Getter @Setter
    private String description;

    @DBRef
    @Getter @Setter
    private User creator;
}
