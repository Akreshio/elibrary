package akreshio.elibrary.dao.mapper;

import akreshio.elibrary.dao.entity.RoleEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RoleMapper implements RowMapper<RoleEntity> {

    @Override
    public RoleEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new RoleEntity(
                rs.getLong("id"),
                rs.getString("name")
        );
    }

}
