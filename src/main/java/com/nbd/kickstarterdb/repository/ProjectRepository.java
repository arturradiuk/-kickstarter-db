package com.nbd.kickstarterdb.repository;

import com.nbd.kickstarterdb.model.Project;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface ProjectRepository extends CassandraRepository<Project, Integer> {

    @AllowFiltering
    List<Project> findByID(Integer ID);

    List<Project> findByNameContaining(String name);

}
