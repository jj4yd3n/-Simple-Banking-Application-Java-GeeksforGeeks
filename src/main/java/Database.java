import at.favre.lib.crypto.bcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public String printDB(){
        String url = "jdbc:mysql://localhost:3306/javaBank";
        String u = "root";
        String p = "britneybitch";
        String contentDB = "";
        try {
            Connection connection = DriverManager.getConnection(url, u, p);
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT * FROM Accounts");
            while(resultSet.next()) {
                String myUser = resultSet.getString("username");
                String myPass = resultSet.getString("password");
                int accountNo1 = resultSet.getInt("accountNo");
                contentDB = "Table: " + myUser + " " + myPass + " " + accountNo1;
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contentDB;
    }

    public List retrieveUsers(){
        String url = "jdbc:mysql://localhost:3306/javaBank";
        String u = "root";
        String p = "britneybitch";
        List<String> users = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url, u, p);
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT * FROM Accounts");
            while(resultSet.next()) {
                 users.add(resultSet.getString("username"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public String retrieveUser(String uname){
        String url = "jdbc:mysql://localhost:3306/javaBank";
        String u = "root";
        String p = "britneybitch";
        String retrieveUser = "";
        String retrievePass = "";
        try {
            Connection connection = DriverManager.getConnection(url, u, p);
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            String sql = "SELECT * FROM Accounts WHERE username = ? and password = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,uname);
            pstmt.setString(2,retrievePass);
            resultSet = pstmt.executeQuery();
            while(resultSet.next()){
                retrieveUser = resultSet.getString("username");
                retrievePass = resultSet.getString("password");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retrieveUser + retrievePass;
    }
}
