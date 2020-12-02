package com.timelogr.enterprise.dao;

import com.timelogr.enterprise.dto.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project,Integer> {

    List<Project> findByClientId(int client);

}
