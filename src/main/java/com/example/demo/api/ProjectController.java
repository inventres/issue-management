package com.example.demo.api;

import com.example.demo.dto.ProjectDto;
import com.example.demo.util.ApiPaths;
import com.example.demo.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.implementaion.ProjectServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api("Project APIs")
@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping("/pagination")
    @ApiOperation(value="Get By Pagination Operation", response = ProjectDto.class)
    public ResponseEntity<TPage<ProjectDto>> getAllByPagination(Pageable pageable) {
        TPage<ProjectDto> tpage = projectServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(tpage);
    }

    @GetMapping()
    @ApiOperation(value = "Get All Operation", response = ProjectDto.class , responseContainer = "List")
    public ResponseEntity<List<ProjectDto>> getAll() {
        List<ProjectDto> data = projectServiceImpl.getAll();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    @ApiOperation(value="GetbyId", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id) {
        log.info("ProjectController -> GetById -> PARAM:" + id);
        log.debug("ProjectController -> GetById -> PARAM:" + id);
        return ResponseEntity.ok(projectServiceImpl.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "Create Project Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto) {
        log.info("ProjectController -> createProject -> PARAM:" + projectDto);
        log.debug("ProjectController -> createProject -> PARAM:" + projectDto);
        return ResponseEntity.ok(projectServiceImpl.save(projectDto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value="Update Project Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> updateProject(@PathVariable("id") Long id, @RequestBody ProjectDto projectDto) {
        log.info("ProjectController -> updateProject -> PARAM:" + projectDto);
        log.debug("ProjectController -> updateProject -> PARAM:" + projectDto);
       return ResponseEntity.ok(projectServiceImpl.update(id, projectDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Delete Project Operation", response = Boolean.class)
    public ResponseEntity<Boolean> DeleteProject(@PathVariable(value = "id", required = true) Long id){
        log.info("ProjectController -> DeleteProject -> PARAM:" + id);
        log.debug("ProjectController -> DeleteProject -> PARAM:" + id);
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }
}
