package com.example.springdemo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String Description;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    //private Long projectId;
    private Project project;

    private String status;
}
