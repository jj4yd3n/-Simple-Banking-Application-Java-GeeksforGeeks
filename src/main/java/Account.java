import at.favre.lib.crypto.bcrypt.BCrypt;

import java.sql.*;
public class Account {
    private Integer accountNo;
    private Double balance;
    private String uname;
    private String pass;
    private String bcryptHash;

    public Account(String uname, String pass){
        this.uname = uname;
        this.pass = pass;
    }

    public String viewDB(){
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
    public void registerUser(String uname, String pass){
        String url = "jdbc:mysql://localhost:3306/javaBank";
        String u = "root";
        String p = "britneybitch";
        try {
            Connection connection = DriverManager.getConnection(url, u, p);
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            String getBack = "INSERT INTO Accounts (username, password) VALUES (?,?)";
            PreparedStatement pstmt = connection.prepareStatement(getBack);
            resultSet = statement.executeQuery("SELECT * FROM Accounts");
            pstmt.setString(1,uname);
            pstmt.setString(2, pass);
            pstmt.executeUpdate();

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setBcryptHash(String pass){
        this.pass = BCrypt.withDefaults().hashToString(12,pass.toCharArray());
    }

    public String getBcryptHash(){
        return bcryptHash;
    }


}
