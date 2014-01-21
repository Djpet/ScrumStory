package fr.scrumsotry.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;

import fr.scrumsotry.dao.IProjectDao;

@Slf4j
public class Project {
	
	@Getter @Setter
	private String id;
	
	@NotBlank
	@Getter @Setter
	private String code;

	@NotBlank
	@Getter @Setter
	private String name;

	@NotBlank
	@Getter @Setter
	private String description;

	@Getter @Setter
	private Integer itemKey;
	
	@Autowired
	private IProjectDao projectDao;
	
	public void create() {
		log.debug("BEGIN create Project");
		itemKey = 0;
		projectDao.create(this);
		log.debug("END create project");
	}

	public Integer nextKey() {
		itemKey++;
		projectDao.update(this);
		return itemKey;
	}
}
