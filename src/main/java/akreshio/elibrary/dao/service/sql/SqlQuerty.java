package akreshio.elibrary.dao.service.sql;

/**
 * The enum Sql querty.
 */
public enum SqlQuerty {
    /**
     * The Get.
     */
    get {
        public String sql(String table) {
            return "select * from " + table;
        }
    },
    /**
     * The Get by.
     */
    get_by{
        public String sql(String table) {
            return "select * from " + table + " where ";
        }
    },
    /**
     * The Delete.
     */
    delete{
        public String sql(String table) {
            return "delete from " + table + " where ";
        }
    },
    /**
     * The Insert.
     */
    insert{
        public String sql(String table) {
            return "insert into " + table;
        }
    },
    /**
     * The Update.
     */
    update{
        public String sql(String table) {
            return "update " + table + " set ";
        }
    };

    /**
     * Sql string.
     *
     * @return the string
     */
    public abstract String sql(String table);


}
