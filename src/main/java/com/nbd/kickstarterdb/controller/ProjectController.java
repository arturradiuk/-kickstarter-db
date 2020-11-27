package com.nbd.kickstarterdb.controller;

import com.nbd.kickstarterdb.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

}
