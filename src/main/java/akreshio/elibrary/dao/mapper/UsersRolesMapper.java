package akreshio.elibrary.dao.mapper;

import akreshio.elibrary.dao.entity.UsersRolesEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UsersRolesMapper implements RowMapper<UsersRolesEntity> {
    @Override
    public UsersRolesEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UsersRolesEntity(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getLong("role_id")
        );
    }
}
