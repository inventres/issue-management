package repo;

import com.example.demo.entity.IssueHistory;
import org.springframework.data.repository.CrudRepository;

public interface IssueHistoryRepository extends CrudRepository <IssueHistory, Long> {


}
