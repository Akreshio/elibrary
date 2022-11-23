package akreshio.elibrary.dao.mapper;

import akreshio.elibrary.dao.entity.UserEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserMapper implements RowMapper<UserEntity>{
    @Override
    public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserEntity(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("password"),
                rs.getString("confirm")
        );
    }
}
