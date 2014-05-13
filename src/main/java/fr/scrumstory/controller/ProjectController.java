package fr.scrumstory.controller;

import fr.scrumstory.domain.Project;
import fr.scrumstory.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void create(@RequestBody Project project) {
        projectService.create(project);
    }
}
