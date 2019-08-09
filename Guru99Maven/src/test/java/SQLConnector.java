import  java.sql.Connection;
import  java.sql.Statement;
import  java.sql.ResultSet;
import  java.sql.DriverManager;
import  java.sql.SQLException;

public class  SQLConnector {

    public static void  main(String[] args) throws  ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/demo?useSSL=false";
        String username = "root";
        String password = "sifra1";
        String query = "select *  from credentials;";

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(dbUrl,username,password);
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery(query);

        while (rs.next()){
            String myName = rs.getString(1);
            String myAge = rs.getString(2);
            System. out.println(myName+"  "+myAge);
        }

        con.close();
    }
}