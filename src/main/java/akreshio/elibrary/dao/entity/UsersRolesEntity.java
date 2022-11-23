package akreshio.elibrary.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_role")
@Getter
@Setter
public class UsersRolesEntity {

    public UsersRolesEntity(Long idUser, Long idRole) {
        this.idUser = idUser;
        this.idRole = idRole;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "user_id", nullable = false)
    private Long idUser;
    @Column(name = "role_id", nullable = false)
    private Long idRole;


    }
