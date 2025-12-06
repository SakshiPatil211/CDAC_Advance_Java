package com.demo.service;

import java.util.List;

import com.demo.beans.Project;

public interface ProjectService {

	void addProject();

	List<Project> findAllProject();

	boolean deleteProject(int id);

	boolean updateProjectById(int id, String pname);

}
