import java.sql.*;

public class Main {

    public static final String DB_NAME = "test1java.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\databases" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {

        // try with resources
        try(Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\databases\\test1.db");
            Statement statement = con.createStatement()){
//            con.setAutoCommit(true); // stops auto save
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Joe', 07895798917 , 'Joe@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('James', 07846798917 , 'James@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Remy', 07896768917 , 'Remy@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Samy', 07896398917 , 'Samy@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Terry', 078197209812, 'tary@gmail.com')");
//            statement.execute("UPDATE contacts SET email='terry@gmail.com' WHERE name='Terry'");
//            statement.execute("UPDATE contacts SET phone=07819720981 WHERE name = 'Terry'");
//            statement.execute("DELETE FROM contacts WHERE name = 'Joe'");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Joe', 11123487534 , 'Joe@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Greg', 11123475148 , 'Greg@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Rebs', 11123647842 , 'Rebs@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Billi', 11126478954 , 'Billi@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Frank', 11148732548 , 'Frank@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Foroh', 07887521456 , 'Foroh@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Emes', 07863248742 , 'Emes@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Rick', 07864725647 , 'Rick@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Roland', 07856936547 , 'Roland@gmail.com')");

//            statement.execute("SELECT * FROM contacts");
//            ResultSet rs = statement.getResultSet();
              ResultSet rs = statement.executeQuery("SELECT * FROM contacts");
            while(rs.next()){
                System.out.println(rs.getString("name") + " " + rs.getString("phone") + " " + rs.getString("email"));
            }
            rs.close();

//            statement.close();
            con.close();
        }catch (SQLException e){

        }

  }
}


//        try{
//            Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\databases\\test.db");
//            Statement statement = con.createStatement();
//            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");
//        }catch (SQLException e){
//            System.out.println("Something Went Wrong: Could Not Connect To Database " + e);
//        }