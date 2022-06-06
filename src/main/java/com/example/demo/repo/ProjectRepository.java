package com.example.demo.repo;

import com.example.demo.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project getProjectByProjectCode(String projectCode);

    Project getProjectByProjectCodeContains(String projectCode);

    Page<Project> findAll(Pageable pageable);

    List<Project> findAll(Sort sort);
}
