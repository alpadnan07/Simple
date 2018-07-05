package com.example.demo.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
	@Autowired
	ProjectService projectService = new ProjectService();
	@RequestMapping("/")
	public String greetings() {
	return "Greetings!";
	}
	@RequestMapping("/projects")
	public List<Project> projects() {
		return projectService.getAllProjects();		
	}
	
	@RequestMapping("/projects/{id}")
	public Project getProject(@PathVariable String id) {
		return projectService.getProject(id);
	}
	@RequestMapping(method = RequestMethod.POST,value="/projects")
	public void addProject(@RequestBody Project project) {
		projectService.addProject(project);
	}
	
	@RequestMapping(method = RequestMethod.PUT ,value = "/projects/{id}")
	public void editProject(@RequestBody Project project) {
		 projectService.editProject(project);
	}
	@RequestMapping(method = RequestMethod.DELETE, value ="/projects/{id}")
	public void deleteProject(@PathVariable String id) {
		projectService.deleteProject(id);
	}
	
}
