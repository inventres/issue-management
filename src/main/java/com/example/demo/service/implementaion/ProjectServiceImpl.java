package com.example.demo.service.implementaion;

import com.example.demo.dto.ProjectDto;
import com.example.demo.entity.Project;
import com.example.demo.util.TPage;
import org.modelmapper.ModelMapper;
import com.example.demo.repo.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.example.demo.service.ProjectService;

import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {
        Project projectCheck = projectRepository.getProjectByProjectCode(project.getProjectCode());

        if (projectCheck != null)
            throw new IllegalArgumentException("This project code have already in db.");

        Project p = modelMapper.map(project, Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }

    @Override
    public ProjectDto getById(Long id) {
        if (id < 0 || id == 0)
            throw new IllegalArgumentException("ProjectId cannot be 0 or negative.");

        return modelMapper.map(projectRepository.getById(id), ProjectDto.class);
    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> response = new TPage<>();
        response.setStats(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
        return  response;
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }

    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto projectDto) {
        Project projectControl = projectRepository.getOne(id);

        if (projectControl == null)
            throw new IllegalArgumentException("This project does not found.!");

        Project projectCheck = projectRepository.getProjectByProjectCode(projectDto.getProjectCode());

        if (projectCheck != null && !Objects.equals(id, projectCheck.getId()))
            throw new IllegalArgumentException("This project code have already in db.");

        projectControl.setProjectCode(projectDto.getProjectCode());
        projectControl.setProjectName(projectDto.getProjectName());
        projectRepository.save(projectControl);
        projectDto = modelMapper.map(projectControl, ProjectDto.class);
        return projectDto;
    }

    public List<ProjectDto> getAll() {
        List<Project> data = projectRepository.findAll();
        return Arrays.asList(modelMapper.map(data, ProjectDto[].class));
    }
}
