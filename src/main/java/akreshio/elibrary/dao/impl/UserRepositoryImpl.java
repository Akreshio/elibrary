package akreshio.elibrary.dao.impl;

import akreshio.elibrary.dao.UserRepository;
import akreshio.elibrary.dao.entity.UserEntity;
import akreshio.elibrary.dao.mapper.UserMapper;
import akreshio.elibrary.dao.service.sql.SqlCreateByObject;
import akreshio.elibrary.dao.service.sql.SqlFormation;
import akreshio.elibrary.dao.service.sql.SqlQuerty;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Slf4j
@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserMapper mapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final SqlFormation queryParam;
    private final SqlCreateByObject byObject;
    private final String TABLE = "user_id";

    @Override
    public List<UserEntity> get() {
        log.debug (SqlQuerty.get.sql(TABLE));
        return jdbcTemplate.query(SqlQuerty.get.sql(TABLE), mapper);
    }

    @Override
    public UserEntity get(String username) {
        queryParam.set(SqlQuerty.get_by, byObject.set(username),TABLE);
        log.debug (queryParam.getQuerySql() + "  " + queryParam.getParams());
        List <UserEntity> list = jdbcTemplate.query(
                queryParam.getQuerySql(),
                queryParam.getParams(),
                mapper
        );
        if (list.size()!=1) return null;
        return list.get(0);
    }

    @Override
    public UserEntity get(Long userId) {
        queryParam.set(SqlQuerty.get_by, byObject.set(userId),TABLE);
        log.debug (queryParam.getQuerySql() + "  " + queryParam.getParams());
        List <UserEntity> list = jdbcTemplate.query(
                queryParam.getQuerySql(),
                queryParam.getParams(),
                mapper
        );
        if (list.size()!=1) return null;
        return list.get(0);
    }

    @Override
    public void add (UserEntity user){
        queryParam.set(SqlQuerty.insert, byObject.set(user),TABLE);
        log.debug (queryParam.getQuerySql() + "  " + queryParam.getParams());
        jdbcTemplate.update(
                queryParam.getQuerySql(),
                queryParam.getParams()
        );
    }

    @Override
    public void delete (Long userId){
        queryParam.set(SqlQuerty.insert, byObject.set(userId),TABLE);
        log.debug (queryParam.getQuerySql() + "  " + queryParam.getParams());
        jdbcTemplate.update(
                queryParam.getQuerySql(),
                queryParam.getParams()
        );
    }
}
