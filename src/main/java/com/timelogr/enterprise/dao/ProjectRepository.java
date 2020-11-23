package com.timelogr.enterprise.dao;

import com.timelogr.enterprise.dto.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project,Integer> {
}
