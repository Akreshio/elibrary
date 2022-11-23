package akreshio.elibrary.dao.impl;

import akreshio.elibrary.dao.UserAndRoleRepository;
import akreshio.elibrary.dao.entity.UsersRolesEntity;
import akreshio.elibrary.dao.mapper.UsersRolesMapper;
import akreshio.elibrary.dao.service.sql.SqlCreateByObject;
import akreshio.elibrary.dao.service.sql.SqlFormation;
import akreshio.elibrary.dao.service.sql.SqlQuerty;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@AllArgsConstructor
public class UserAndRoleRepositoryImpl implements UserAndRoleRepository {


    private final UsersRolesMapper mapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final SqlFormation queryParam;
    private final SqlCreateByObject byObject;
    private final String TABLE = "user_role";

    public  List<UsersRolesEntity> getByUserId(Long idUser){
        MapSqlParameterSource param = new MapSqlParameterSource();
        String sql = "select * from " + TABLE + " where user_id=" + idUser;
        param.addValue(":user_id", idUser);
        log.debug (sql + " " + param);
        List<UsersRolesEntity> list = jdbcTemplate.query(
                sql,
                mapper
        );
        return list;
    }

    public void add (UsersRolesEntity ur){
        queryParam.set(SqlQuerty.insert, byObject.set(ur),TABLE);
        log.debug (queryParam.getQuerySql() + "  " + queryParam.getParams());
        jdbcTemplate.update(
                queryParam.getQuerySql(),
                queryParam.getParams()
        );

    }
}
