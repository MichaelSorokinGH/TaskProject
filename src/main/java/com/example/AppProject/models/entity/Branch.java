package com.example.AppProject.models.entity;

import com.example.AppProject.models.enums.BranchName;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "branches")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "address", unique = true)
    String address;
    @Column(name = "phone")
    String phone;
    @Enumerated(EnumType.STRING)
    BranchName branchName;
    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            updatable = false)
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
    @Column(name = "task_id")
    @OneToMany(cascade = CascadeType.ALL)
    List<Task> tasks;
    @Column(name = "department_id")
    @OneToMany(cascade = CascadeType.ALL)
    List<Department> departments;
    @JoinColumn(name = "dispatch_id")
    @OneToOne(cascade = CascadeType.ALL)
    Dispatch dispatch;

}
