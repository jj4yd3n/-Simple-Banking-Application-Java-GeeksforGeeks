import at.favre.lib.crypto.bcrypt.BCrypt;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    String url = "jdbc:mysql://localhost:3306/javaBank";
    String u = "root";
    String p = "britneybitch";
    public String printDB(){
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

    public String retrievePassHash(String uname){
        String retrievePass = "";
        try {
            Connection connection = DriverManager.getConnection(url, u, p);
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            String sql = "SELECT * FROM Accounts WHERE username = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,uname);
            resultSet = pstmt.executeQuery();
            while(resultSet.next()){
                retrievePass = resultSet.getString("password");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retrievePass;
    }

}
