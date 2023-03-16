package com.example.AppProject.models.repositories;

import com.example.AppProject.models.entity.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DispatchRepository extends JpaRepository<Dispatch, Long> {

    Optional<Dispatch> findByAddress(String address);
}
