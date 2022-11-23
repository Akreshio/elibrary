package akreshio.elibrary.dao;

import akreshio.elibrary.dao.entity.UsersRolesEntity;

import java.util.List;

public interface UserAndRoleRepository {
    List<UsersRolesEntity> getByUserId(Long idUser);
    void add (UsersRolesEntity ur);
}
