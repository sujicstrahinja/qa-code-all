import java.sql.*;

public class jdbconnection {

    public static void main(String[] args) throws SQLException {

        String host = "localhost";
        String port = "3306";
        Connection connection = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/demo?useSSL=false", "root", "sifra1");

        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery("select * from credentials where scenario = \"zerobalanced\"");

        while (results.next()) {
            System.out.println(results.getString("username"));
            System.out.println(results.getString("password"));
        }
    }
}
