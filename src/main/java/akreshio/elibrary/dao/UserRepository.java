package akreshio.elibrary.dao;

import akreshio.elibrary.dao.entity.UserEntity;

import java.util.List;

public interface UserRepository {
    List<UserEntity> get();
    UserEntity get(String username);
    UserEntity get(Long userId);
    void add (UserEntity user);
    void delete (Long userId);
}
