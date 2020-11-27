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
    private String main_category;
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

}
