package fr.scrumstory.domain;

import fr.scrumstory.dao.IProjectDao;
import fr.scrumstory.dao.IStoryDao;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;

@Slf4j
public class Story {

    @Getter @Setter
    private String id;

    @Getter @Setter
    private Integer key;

    @NotNull
    @Getter @Setter
    private String codeProject;

    @NotNull
    @Getter @Setter
    private String name;

    @NotNull
    @Getter @Setter
    private String description;

    @Autowired
    private IStoryDao storyDao;

    @Autowired
    private IProjectDao projectDao;

    public void create() {
        log.debug("BEGIN create Story");
        Project project = projectDao.findByCode(codeProject);
        key = project.nextKey();
        storyDao.create(this);
        log.debug("END create Story");
    }

}