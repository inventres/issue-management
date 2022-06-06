package com.example.demo.service;

import com.example.demo.dto.ProjectDto;
import com.example.demo.entity.Project;
import com.example.demo.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {
    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    TPage<ProjectDto> getAllPageable(Pageable pageable);

    Boolean delete(Project project);

    ProjectDto update(Long id, ProjectDto projectDto);
}
