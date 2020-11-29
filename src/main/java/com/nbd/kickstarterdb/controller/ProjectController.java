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

    @GetMapping("/allProjects")
    public ResponseEntity<List<Project>> getAllProjects() { // todo limit it somehow
        try {
            List<Project> projects = new ArrayList<>(projectRepository.findAll());

            if (projects.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(projects, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("projects")
    public ResponseEntity<Project> getProjectByID(@RequestParam Integer ID) {
        Optional<Project> project = projectRepository.findById(ID);

        if (project.isPresent()) {
            return new ResponseEntity<>(project.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/projects/{ID}")
    public ResponseEntity<Project> getProjectByIDPath(@PathVariable("ID") Integer ID) {
        return getProjectByID(ID);
    }

    @DeleteMapping("/allProjects")
    public ResponseEntity<Project> deleteProjects() {
        try {
            projectRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("projects")
    public ResponseEntity<Project> deleteProjectByID(@RequestParam Integer ID) {
        try {
            projectRepository.deleteById(ID);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/projects/{ID}")
    public ResponseEntity<Project> deleteProjectByIDPath(@PathVariable("ID") Integer ID) {
        return deleteProjectByID(ID);
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> createProject(@RequestBody Project project, @RequestParam(required = false) Integer ID) {
        try {
            if (ID != null) {
                project.setID(ID);
            }
            Project _project = projectRepository.save(new Project(project));
            return new ResponseEntity<>(_project, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/projects/{ID}")
    public ResponseEntity<Project> createProjectPath(@RequestBody Project project, @PathVariable("ID") Integer ID) {
        return createProject(project, ID);
    }

    @PutMapping("/projects")
    public ResponseEntity<Project> updateProject(@RequestBody Project project, @RequestParam(required = false) Integer ID) {
        Optional<Project> projectData;
        if (ID != null) {
            projectData = projectRepository.findById(ID);
        } else {
            projectData = projectRepository.findById(project.getID());
        }

        if (projectData.isPresent()) {
            Project _project = projectData.get();
            _project.setName(project.getName());
            _project.setCategory(project.getCategory());
            _project.setMain_category(project.getMain_category());
            System.out.println(project.getMain_category());
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
            System.out.println(project);
            return new ResponseEntity<>(projectRepository.save(_project), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/projects/{ID}")
    public ResponseEntity<Project> updateProjectPath(@RequestBody Project project, @PathVariable("ID") Integer ID) {
        return updateProject(project, ID);
    }

}
