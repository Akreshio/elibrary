package akreshio.elibrary.dao.service.sql;

import akreshio.elibrary.dao.service.model.SqlParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;


/**
 * Creating sql query without null fields.
 * Создание sql-запроса без нулевых полей.
 */
@Getter
@NoArgsConstructor
@Component
public class SqlFormation {

    private MapSqlParameterSource params;
    private String querySql;

    /**
     * Set.
     *
     * @param sqlQuerty the sql query
     */
    public void set (SqlQuerty sqlQuerty, String table){
        if (sqlQuerty == SqlQuerty.get) {
            querySql = sqlQuerty.sql(table);
        }
    }

    /**
     * Setting the parameters sql query (Установка параметров sql запроса)
     *
     * @return the boolean
     */
    public boolean set (SqlQuerty sqlQuerty, SqlParameter parameter, String table){
        StringBuilder sql = new StringBuilder(sqlQuerty.sql(table));

        int count = parameter.getCount();
        params = parameter.getParams();
        String[] column = parameter.getColumnName().toArray(new String[0]);
        String[] param = parameter.getParamName().toArray(new String[0]);

        switch (sqlQuerty) {
            case get_by:
            case delete:
                for (int j=0; j<count; j++){
                    sql.append(column[j])
                            .append(" =")
                            .append(param[j])
                            .append(" AND ");
                }
                sql.setLength(sql.length()-5);
                querySql = sql.toString();
                return true;
            case insert:
                StringBuilder sqlColumn = new StringBuilder();
                StringBuilder sqlParam  = new StringBuilder();

                for (int j=0; j<=count-1; j++){
                    sqlColumn.append(column[j]).append(", ");
                    sqlParam.append(param[j]).append(", ");
                }
                sqlColumn.setLength(sqlColumn.length()-2);
                sqlParam.setLength(sqlParam.length()-2);
                sql.append(" (")
                        .append(sqlColumn)
                        .append(") values (")
                        .append(sqlParam)
                        .append(")");

                querySql = sql.toString();
                return true;
            default:
                return false;
        }
    }
}
