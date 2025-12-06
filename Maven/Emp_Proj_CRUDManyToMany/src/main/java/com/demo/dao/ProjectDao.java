package com.demo.dao;

import java.util.List;

import com.demo.beans.Project;

public interface ProjectDao {

	void save(Project p);

	Project findById(int pid);

	List<Project> findAllProject();

	boolean deleteProject(int id);

	boolean updateProjectById(int id, String pname);

}
