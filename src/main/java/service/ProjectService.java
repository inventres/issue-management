package service;

import com.example.demo.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {
    Project save(Project issue);

    Project getById(Long id);

    Page<Project> getAllPageable(Pageable pageable);

    Boolean delete(Project project);
}
