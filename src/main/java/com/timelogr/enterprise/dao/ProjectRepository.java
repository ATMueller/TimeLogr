package com.timelogr.enterprise.dao;

import com.timelogr.enterprise.dto.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project,Integer> {
    @Query(value = "SELECT * FROM project a WHERE a.id = ?1", nativeQuery = true)
    Project findProjectById(Integer id);

    List<Project> findByClientId(int client);

}
