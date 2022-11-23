package akreshio.elibrary.dao;

import akreshio.elibrary.dao.entity.RoleEntity;

import java.util.List;

public interface RoleRepository {

    List<RoleEntity> get();
    RoleEntity get(String name);
    RoleEntity get(Long id);

}
