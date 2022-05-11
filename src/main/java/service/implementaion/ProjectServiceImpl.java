package service.implementaion;

import com.example.demo.entity.Project;
import repo.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import service.ProjectService;

import org.springframework.data.domain.Pageable;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {this.projectRepository = projectRepository;}

    @Override
    public Project save(Project project) {
        if (project.getProjectCode() == null || project.getProjectCode() == "") {
            throw new IllegalArgumentException("Project code cannot be null");
        }
        return projectRepository.save(project);
    }

    @Override
    public Project getById(Long id) {
        if (id < 0 || id == 0)
            throw new IllegalArgumentException("ProjectId cannot be 0 or negative.");

        return projectRepository.getById(id);
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }
}
