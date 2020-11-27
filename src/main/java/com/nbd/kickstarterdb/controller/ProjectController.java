package com.nbd.kickstarterdb.controller;

import com.nbd.kickstarterdb.model.Project;
import com.nbd.kickstarterdb.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/projects/get")
    public ResponseEntity<List<Project>> getAllProjects(@RequestParam(required = false) String name) {
        try {
            List<Project> projects = new ArrayList<Project>();
            if (name == null) {
                projectRepository.findAll().forEach(projects::add);
            } else
                projectRepository.findByNameContaining(name).forEach(projects::add);

            if (projects.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(projects, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/projects/get/{ID}")
    public ResponseEntity<Project> getProjectByID(@PathVariable("ID") Integer ID) {

        Optional<Project> project = projectRepository.findById(ID);
        System.out.println(project.isPresent());

        if (project.isPresent()) {
            return new ResponseEntity<>(project.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/projects/delete")
    public ResponseEntity<Project> deleteAllProjects() {
        try {
            projectRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/projects/delete/{ID}")
    public ResponseEntity<Project> deleteProjectByID(@PathVariable("ID") Integer ID) {
        try {
            projectRepository.deleteById(ID);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping("/projects/post") // todo need to be tested
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        try {
            Project _project = projectRepository.save(new Project(project));
            return new ResponseEntity<>(_project, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/projects/post/{ID}") // todo need to be implemented

//    @PutMapping("/projects/post/") // todo need to be implemented

    @PutMapping("/projects/put/{ID}") // todo need to be tested
    public ResponseEntity<Project> updateProject(@PathVariable("ID") Integer ID, @RequestBody Project project) {
        Optional<Project> projectData = projectRepository.findById(ID);

        if (projectData.isPresent()) {
            Project _project = projectData.get();
            _project.setName(project.getName());
            _project.setCategory(project.getCategory());
            _project.setMain_category(project.getMain_category());
            _project.setCurrency(project.getCurrency());
            _project.setDeadline(project.getDeadline());
            _project.setGoal(project.getGoal());
            _project.setLaunched(project.getLaunched());
            _project.setPledged(project.getPledged());
            _project.setState(project.getState());
            _project.setBackers(project.getBackers());
            _project.setCountry(project.getCountry());
            _project.setUsd_pledged(project.getUsd_pledged());
            _project.setUsd_pledged_real(project.getUsd_pledged_real());
            _project.setUsd_goal_real(project.getUsd_goal_real());
            return new ResponseEntity<>(projectRepository.save(_project), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
