import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainAdv {
    public static final String DB_NAME = "test2.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\databases\\" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {

        try(Connection con = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = con.createStatement()){

            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS +
                    "( " + COLUMN_NAME + "text, " +
                           COLUMN_PHONE + "integer, " +
                           COLUMN_EMAIL + "text" +
                    "(");

            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    "(" + COLUMN_NAME + ", "
                    + COLUMN_PHONE + ", "
                    + COLUMN_EMAIL + ")"
                    + "VALUES ('John, 236578965, 'john@gmail.com')");

            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    "(" + COLUMN_NAME + ", "
                    + COLUMN_PHONE + ", "
                    + COLUMN_EMAIL + ")"
                    + "VALUES ('James, 22547983, 'james@gmail.com')");

            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    "(" + COLUMN_NAME + ", "
                    + COLUMN_PHONE + ", "
                    + COLUMN_EMAIL + ")"
                    + "VALUES ('Jannie, 22369874, 'jannie@gmail.com')");

            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    "(" + COLUMN_NAME + ", "
                    + COLUMN_PHONE + ", "
                    + COLUMN_EMAIL + ")"
                    + "VALUES ('John, 22369874, 'angie@gmail.com')");

            statement.execute("UPDATE" + TABLE_CONTACTS + "SET " + COLUMN_NAME + "='angie'" + "WHERE" + COLUMN_EMAIL + "='angie@gmail.com'");

            // TODO - add a delete

            }catch (SQLException e){

        }

    }

    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException{
        statement.execute("INSERT INTO " + TABLE_CONTACTS + "(" + COLUMN_NAME + "," + COLUMN_PHONE + "," + COLUMN_EMAIL + ")" +
                                "VALUES ('" + name + "'," + phone + ", '" + email + "')");
    }

    // TODO - create method for update and delete

}
