package com.example.demo.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Project> getAllProjects() {
		ArrayList<Project> projects = new ArrayList<>();
		Iterable<Project> projectsIter = projectRepository.findAll();
		for(Project project : projectsIter) {
			projects.add(project);
		}
		
		return projects;
		
	}
	public Project getProject(String id) {
		return projectRepository.findById(id).get();
	}
	public void editProject(Project project) {
		projectRepository.save(project);

		
	}
	public void addProject(Project project) {
		projectRepository.save(project);
	}
	public void deleteProject(String id) {
		projectRepository.deleteById(id);
	}
	
}
