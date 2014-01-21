package fr.scrumsotry.dao.mongodb.bean;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="stories")
public class StoryMongo {
	
	@Id
	@Getter @Setter
	private String id;
	
	@Getter @Setter
	private Integer key;

	@Getter @Setter
	private String codeProject;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private String description;
}
