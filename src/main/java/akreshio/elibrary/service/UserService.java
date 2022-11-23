package akreshio.elibrary.service;

import akreshio.elibrary.model.Role;
import akreshio.elibrary.model.User;
import akreshio.elibrary.service.dao.SecurityRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;


@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    @PersistenceContext
    SecurityRepository securityRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = securityRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public List<User> allUsers() {
        return securityRepository.findAll();
    }

    public boolean saveUser (User user) {
        User userFromDB = securityRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }
        user.setRoles(Collections.singleton(new Role("ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        securityRepository.save(user);
        return true;
    }

    public boolean deleteUser (Long userId) {
        if (securityRepository.findById(userId)!=null) {
            securityRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
