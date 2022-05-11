package service.implementaion;

import repo.UserRepository;
import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import service.UserService;

import org.springframework.data.domain.Pageable;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User issue) {
        return null;
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }

    @Override
    public Boolean delete(User user) {
        return null;
    }
}
