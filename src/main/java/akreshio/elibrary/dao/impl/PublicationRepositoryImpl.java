package akreshio.elibrary.dao.impl;

import akreshio.elibrary.dao.PublicationRepository;
import akreshio.elibrary.dao.entity.PublicationEntity;
import akreshio.elibrary.dao.mapper.PublicationMapper;
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
public class PublicationRepositoryImpl implements PublicationRepository {

    private final PublicationMapper publicationMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final SqlFormation queryParam;
    private final SqlCreateByObject byObject;
    private final String TABLE = "publication";

    @Override
    public List<PublicationEntity> get() {
        log.debug (SqlQuerty.get.sql(TABLE));
        return jdbcTemplate.query(SqlQuerty.get.sql(TABLE), publicationMapper);
    }

    @Override
    public List <PublicationEntity> get(Long id) {
        queryParam.set(SqlQuerty.get_by, byObject.set(id),TABLE);
        log.debug (queryParam.getQuerySql() + "  " + queryParam.getParams());
        return jdbcTemplate.query(
                queryParam.getQuerySql(),
                queryParam.getParams(),
                publicationMapper
        );
    }

        @Override
    public List <PublicationEntity> get(PublicationEntity publication) {
        queryParam.set(SqlQuerty.get_by, byObject.set(publication),TABLE);
        log.debug (queryParam.getQuerySql() + "  " + queryParam.getParams());
        return jdbcTemplate.query(
                queryParam.getQuerySql(),
                queryParam.getParams(),
                publicationMapper
        );
    }

    @Override
    public boolean add(PublicationEntity publication) {
        queryParam.set(SqlQuerty.insert, byObject.set(publication),TABLE);
        log.debug (queryParam.getQuerySql() + "  " + queryParam.getParams());
        jdbcTemplate.update(
                queryParam.getQuerySql(),
                queryParam.getParams()
        );
        return true;
    }

    @Override
    public boolean delete(PublicationEntity publication) {
        queryParam.set(SqlQuerty.delete, byObject.set(publication),TABLE);
        log.debug (queryParam.getQuerySql() + "  " + queryParam.getParams());
        jdbcTemplate.update(
                queryParam.getQuerySql(),
                queryParam.getParams()
        );
        return true;
    }
}
