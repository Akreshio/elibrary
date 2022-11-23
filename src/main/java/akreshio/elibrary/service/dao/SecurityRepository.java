package akreshio.elibrary.service.dao;

import akreshio.elibrary.model.User;
import java.util.List;
import java.util.Optional;

public interface SecurityRepository {

    List <User> findAll();
    User findByUsername(String username);
    User findById(Long userId);
    void save(User user);
    void deleteById(Long userId);
}
