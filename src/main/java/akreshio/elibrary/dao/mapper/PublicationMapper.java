package akreshio.elibrary.dao.mapper;

import akreshio.elibrary.dao.entity.PublicationEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PublicationMapper implements RowMapper<PublicationEntity> {

@Override
    public PublicationEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PublicationEntity(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("isbn"),
            rs.getString("author"),
            rs.getString("type"),
            rs.getInt("page"),
            rs.getInt("count"),
            rs.getString("publisher")
        );
    }
}
