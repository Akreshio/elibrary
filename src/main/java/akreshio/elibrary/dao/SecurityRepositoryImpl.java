package akreshio.elibrary.dao;

import akreshio.elibrary.dao.entity.RoleEntity;
import akreshio.elibrary.dao.entity.UserEntity;
import akreshio.elibrary.dao.entity.UsersRolesEntity;
import akreshio.elibrary.model.Role;
import akreshio.elibrary.model.User;
import akreshio.elibrary.service.dao.SecurityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class SecurityRepositoryImpl implements SecurityRepository {

    RoleRepository roleRepository;
    UserRepository userRepository;
    UserAndRoleRepository userRoleRepository;

    @Override
    public List<User> findAll() {
        List<UserEntity> usersList = userRepository.get();
        List<RoleEntity> rolesList = roleRepository.get();
        Map<Long,Role> rolesMap = rolesList
                .stream()
                .collect(
                        Collectors.toMap(
                                RoleEntity::getId,
                                x -> new Role(
                                        x.getName()
                                )
                        )
                );

        List<User> users = new ArrayList<>();
        User user;

        for (UserEntity entity:usersList) {
           user = new User(
                   entity.getUsername(),
                   entity.getPassword(),
                   entity.getPasswordConfirm()
           );
           List<UsersRolesEntity> roles = userRoleRepository.getByUserId(
                    entity.getId()
           );
           for (UsersRolesEntity role:roles) {
                user.rolePut(
                        rolesMap.get(
                                role.getIdRole()
                        )
                );
           }
           users.add(user);
        }

        return users;
    }

    @Override
    public User findByUsername(String username) {
        UserEntity entity = userRepository.get(username);
        if (entity == null) return null;
        User user = new User(
                entity.getUsername(),
                entity.getPassword(),
                entity.getPasswordConfirm()
        );
        List<UsersRolesEntity> roles = userRoleRepository.getByUserId(
                entity.getId()
        );
        for (UsersRolesEntity role:roles) {
            user.rolePut(
                    new Role(
                        roleRepository.get(
                            role.getIdRole()
                        ).getName()
                    )
            );
        }

        return user;
    }

    @Override
    public User findById(Long userId) {
        UserEntity entity = userRepository.get(userId);
        User user = new User(
                entity.getUsername(),
                entity.getPassword(),
                entity.getPasswordConfirm()
        );
        List<UsersRolesEntity> roles = userRoleRepository.getByUserId(entity.getId());
        for (UsersRolesEntity role:roles) {
            user.rolePut(
                    new Role(
                            roleRepository.get(
                                    role.getIdRole()
                            ).getName()
                    )
            );
        }

        return user;
    }

    @Override
    public void save(User user) {
        UserEntity entity = new UserEntity(
                user.getUsername(),
                user.getPassword(),
                user.getPasswordConfirm());

        userRepository.add(entity);
        entity = userRepository.get(user.getUsername());

        for (Role role:user.getRoles()) {
            userRoleRepository.add(
                    new UsersRolesEntity(
                            entity.getId(),
                            roleRepository.get(role.getName()).getId()
                    )
            );
        }
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.delete(userId);
    }
}
