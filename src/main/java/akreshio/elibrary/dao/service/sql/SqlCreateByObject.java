package akreshio.elibrary.dao.service.sql;

import akreshio.elibrary.dao.entity.*;
import akreshio.elibrary.dao.service.model.SqlParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;

/**
 * Definition the params without null fields.
 * Определение параметров без нулевых полей.
 */
@Getter
@NoArgsConstructor
@Component
public class SqlCreateByObject {

    private MapSqlParameterSource params = new MapSqlParameterSource();
    private LinkedHashSet<String> columnName = new LinkedHashSet();
    private LinkedHashSet<String> paramName = new LinkedHashSet();
    private int count = 0;


    public SqlParameter set (Long id){
        params = new MapSqlParameterSource();
        columnName = new LinkedHashSet();
        paramName = new LinkedHashSet();
        int i=0;
        i = setField(id,       "id",       i); //long
        count = i;
        return new SqlParameter(params, columnName, paramName, count);
    }

    public SqlParameter set (String name){
        params = new MapSqlParameterSource();
        columnName = new LinkedHashSet();
        paramName = new LinkedHashSet();
        int i=0;
        i = setField(name,       "name",       i); //string
        count = i;
        return new SqlParameter(params, columnName, paramName, count);
    }

    public SqlParameter set (UsersRolesEntity ur){
        params = new MapSqlParameterSource();
        columnName = new LinkedHashSet();
        paramName = new LinkedHashSet();
        int i=0;
        i = setField(ur.getId(),       "id",       i); //long
        i = setField(ur.getIdUser(),       "user_id",       i); //long
        i = setField(ur.getIdRole(),       "role_id",       i); //long
        count = i;
        return new SqlParameter(params, columnName, paramName, count);
    }

    public SqlParameter set (UserEntity user){
        params = new MapSqlParameterSource();
        columnName = new LinkedHashSet();
        paramName = new LinkedHashSet();
        int i=0;
        i = setField(user.getUsername(),       "name",       i); //string
        i = setField(user.getPassword(),       "password",       i); //string
        i = setField(user.getPasswordConfirm(),"confirm",       i); //string

        count = i;
        return new SqlParameter(params, columnName, paramName, count);
    }


    public SqlParameter set (PublicationEntity edition){
        params = new MapSqlParameterSource();
        columnName = new LinkedHashSet();
        paramName = new LinkedHashSet();
        int i=0;
        i = setField(edition.getId(),       "id",       i); //long
        i = setField(edition.getName(),     "name",     i); //string
        i = setField(edition.getIsbn(),     "isbn",     i); //string
        i = setField(edition.getAuthor(),   "author",   i); //string
        i = setField(edition.getType(),     "type",     i); //string
        i = setField(edition.getPage(),     "page",     i); //int
        i = setField(edition.getCount(),    "count",    i); //int
        i = setField(edition.getPublisher(),"publisher",i); //string
        count = i;
        return new SqlParameter(params, columnName, paramName, count);
    }

    private int setField (String inString,  String nameColum, int counter) {
        if (inString == null) return counter;
        if (!inString.isEmpty()) {
            params.addValue(nameColum, inString);
            columnName.add(nameColum);
            paramName.add(" :" + nameColum);
            counter++;
            return counter;
        }
        return counter;
    }

    private int setField (int inInt,        String nameColum, int counter) {
        if (inInt!=0){
            params.addValue(nameColum, inInt);
            columnName.add(nameColum);
            paramName.add(" :" + nameColum);
            counter++;
            return counter;
        }
        return counter;
    }
    private int setField (double inDouble,  String nameColum, int counter) {
        if (inDouble!=0){
            params.addValue(nameColum, inDouble);
            columnName.add(nameColum);
            paramName.add(" :" + nameColum);
            counter++;
            return counter;
        }
        return counter;
    }
    private int setField (Long inLong,      String nameColum, int counter) {
        if (inLong!=null){
            params.addValue(nameColum, inLong);
            columnName.add(nameColum);
            paramName.add(" :" + nameColum);
            counter++;
            return counter;
        }
        return counter;
    }

}
