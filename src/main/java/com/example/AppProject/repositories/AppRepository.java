package com.example.AppProject.repositories;

import com.example.AppProject.models.App;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppRepository extends JpaRepository<App, Long> {

    List<App> findByTitle(String title);
}
