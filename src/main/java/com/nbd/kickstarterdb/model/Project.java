package com.nbd.kickstarterdb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "ks_projects")
public class Project {
    @PrimaryKey
    private Integer ID;
    private String name;
    private String category;
    private String main_category;  // todo rename it
    private String currency;
    private LocalDateTime deadline;
    private Double goal;
    private LocalDateTime launched;
    private Double pledged;
    private String state;
    private Integer backers;
    private String country;
    private Double usd_pledged;
    private Double usd_pledged_real;
    private Double usd_goal_real;

    public Project(Project project) {
        this.ID = project.ID;
        this.name = project.name;
        this.category = project.category;
        this.main_category = project.main_category;
        this.currency = project.currency;
        this.deadline = project.deadline;
        this.goal = project.goal;
        this.launched = project.launched;
        this.pledged = project.pledged;
        this.state = project.state;
        this.backers = project.backers;
        this.country = project.country;
        this.usd_pledged = project.usd_pledged;
        this.usd_pledged_real = project.usd_pledged_real;
        this.usd_goal_real = project.usd_goal_real;
    }
}
