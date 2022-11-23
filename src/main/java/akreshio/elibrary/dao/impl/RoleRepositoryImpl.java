package akreshio.elibrary.dao.impl;

import akreshio.elibrary.dao.RoleRepository;
import akreshio.elibrary.dao.entity.RoleEntity;
import akreshio.elibrary.dao.mapper.RoleMapper;
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
public class RoleRepositoryImpl implements RoleRepository {

    private final RoleMapper mapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final SqlFormation queryParam;
    private final SqlCreateByObject byObject;
    private final String TABLE = "role";

    @Override
    public List<RoleEntity> get() {
        log.debug (SqlQuerty.get.sql(TABLE));
        return jdbcTemplate.query(SqlQuerty.get.sql(TABLE), mapper);
    }

    @Override
    public RoleEntity get(String name) {
        queryParam.set(SqlQuerty.get_by, byObject.set(name),TABLE);
        log.debug (queryParam.getQuerySql() + "  " + queryParam.getParams());
        List<RoleEntity> list = jdbcTemplate.query(
                queryParam.getQuerySql(),
                queryParam.getParams(),
                mapper
        );
        if (list.size()!=1) return null;
        return list.get(0);
    }

    @Override
    public RoleEntity get(Long id) {
        queryParam.set(SqlQuerty.get_by, byObject.set(id),TABLE);
        log.debug (queryParam.getQuerySql() + "  " + queryParam.getParams());
        List<RoleEntity> list = jdbcTemplate.query(
                queryParam.getQuerySql(),
                queryParam.getParams(),
                mapper
        );
        if (list.size()!=1) return null;
        return list.get(0);
    }

}
