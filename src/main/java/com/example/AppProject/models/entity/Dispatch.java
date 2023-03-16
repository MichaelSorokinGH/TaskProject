package com.example.AppProject.models.entity;

import com.example.AppProject.models.enums.DepartmentName;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "dispatch")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Dispatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "address", unique = true)
    String address;
    @Column(name = "phone")
    String phone;
    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            updatable = false)
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
    @JoinColumn(name = "branch_id")
    @OneToOne(cascade = CascadeType.ALL)
    Branch branch;
}
