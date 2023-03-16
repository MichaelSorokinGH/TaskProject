package com.example.AppProject.models.entity;

import com.example.AppProject.models.enums.JobTitle;
import com.example.AppProject.models.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;
    @Column(name = "title")
    String title;
    @Column(name = "description", columnDefinition = "text")
    String description;
    @Column(name = "price")
    int price;
    @Column(name = "address")
    String address;
    @Enumerated(EnumType.STRING)
    Status status;
    @Column(name = "job_title")
    @Enumerated(EnumType.STRING)
    JobTitle jobTitle;
    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            updatable = false)
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    LocalDateTime updatedAt;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "branch_id")
//    Branch branch;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "department_id")
//    Department department;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    User user;


}
