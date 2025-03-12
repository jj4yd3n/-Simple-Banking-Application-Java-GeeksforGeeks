import at.favre.lib.crypto.bcrypt.BCrypt;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.*;
public class Account {
    private Integer accountNo;
    private BigDecimal balance;
    private String username;
    private String hashedPassword;
    private String bcryptHash;
    private BCrypt.Result result;

    String url = "jdbc:mysql://localhost:3306/javaBank";
    String u = "root";
    String p = "britneybitch";
    Database database = new Database();
    boolean threwException = false; //Flag to check if checkPass() method threw an exception.
    boolean isBcryptVerified = false;
    public void registerUser(String uname, String pass, BigDecimal balance){
        this.username = uname;
        bcryptHash = BCrypt.withDefaults().hashToString(12,pass.toCharArray());
        try {
            Connection connection = DriverManager.getConnection(url, u, p);
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            String getBack = "INSERT INTO Accounts (username, password, balance) VALUES (?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(getBack);
            resultSet = statement.executeQuery("SELECT * FROM Accounts");
            pstmt.setString(1,uname);
            pstmt.setString(2, bcryptHash);
            pstmt.setBigDecimal(3, balance);
            pstmt.executeUpdate();

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean checkPass(String plainPass, String username){
        this.username = username;
        try {
            result = BCrypt.verifyer().verify(plainPass.toCharArray(), database.retrievePassHash(username));
            //Otherwise, threwException is set to false.
            threwException = false;
            isBcryptVerified = true;

        } catch (Exception e) {
           incorrectErrorDialog();
           //checkPass threw exception, so set "threwException = false;"
           threwException = true;
        }
        return result.verified;
    }

    public boolean getBcryptVerified(){
        return isBcryptVerified;
    }

    public String getUsername(){
        return username;
    }

    //Method to use error message dialog.
    public void incorrectErrorDialog(){
        JOptionPane.showMessageDialog(null, "Incorrect username or password!");
    }

    //Retrieve true or false status of threwException.
    public boolean getExceptStatus(){
        return threwException;
    }



    /* Check if username and password already exists in database
    public boolean checkDupe(){
        if(uname && pass ==)
    }
     */




}
