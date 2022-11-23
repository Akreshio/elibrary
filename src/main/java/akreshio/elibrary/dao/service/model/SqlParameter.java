package akreshio.elibrary.dao.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class SqlParameter {

    private MapSqlParameterSource params;
    private LinkedHashSet<String> columnName;
    private LinkedHashSet<String> paramName;
    private int count;
}
