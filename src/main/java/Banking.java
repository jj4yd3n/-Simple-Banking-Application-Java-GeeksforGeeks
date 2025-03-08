import java.math.BigDecimal;
import java.sql.*;

public class Banking {
    private int accountNo;
    private BigDecimal balance;
    private BigDecimal diff;
    private BigDecimal sum;
    private BigDecimal amount;
    private BigDecimal recipientBal;
    private String user;

    Database database = new Database();
    String url = "jdbc:mysql://localhost:3306/javaBank";
    String u = "root";
    String p = "britneybitch";

    public Banking(String user){
        this.user = user;
        try {
            Connection connection = DriverManager.getConnection(url, u, p);
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            String sql = "SELECT * FROM Accounts WHERE username = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user);
            resultSet = pstmt.executeQuery();
            while(resultSet.next()){
                this.user = resultSet.getString("username");
                this.balance = resultSet.getBigDecimal("balance");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public BigDecimal getBalance(){
        balance = BigDecimal.valueOf(0.0);
        try {
            Connection connection = DriverManager.getConnection(url, u, p);
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            String sql = "SELECT * FROM Accounts WHERE username = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, this.user);
            resultSet = pstmt.executeQuery();
            while(resultSet.next()){
                balance = resultSet.getBigDecimal("balance");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }

    public BigDecimal getUserBalance(String user){
        balance = BigDecimal.valueOf(0.0);
        try {
            Connection connection = DriverManager.getConnection(url, u, p);
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            String sql = "SELECT * FROM Accounts WHERE username = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user);
            resultSet = pstmt.executeQuery();
            while(resultSet.next()){
                balance = resultSet.getBigDecimal("balance");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }


    public void transferMoney(BigDecimal amount, String user){
        this.amount = amount;
        try {
            Connection connection = DriverManager.getConnection(url, u, p);
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            String query = "UPDATE Accounts set balance = ? where username = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            resultSet = statement.executeQuery("SELECT * FROM Accounts");
            pstmt.setBigDecimal(1, getUserBalance(user).add(amount));
            pstmt.setString(2, user);
            pstmt.executeUpdate();

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void withdrawBal(BigDecimal diff){
        this.diff = diff;
        try {
            Connection connection = DriverManager.getConnection(url, u, p);
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            String getBack = "UPDATE Accounts set balance = ? WHERE username = ?";
            PreparedStatement pstmt = connection.prepareStatement(getBack);
            resultSet = statement.executeQuery("SELECT * FROM Accounts");
            pstmt.setBigDecimal(1, getBalance().subtract(diff));
            pstmt.setString(2, this.user);
            pstmt.executeUpdate();

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void depositBal(BigDecimal sum){
        this.sum = sum;
        try {
            Connection connection = DriverManager.getConnection(url, u, p);
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            String getBack = "UPDATE Accounts set balance = ? WHERE username = ?";
            PreparedStatement pstmt = connection.prepareStatement(getBack);
            resultSet = statement.executeQuery("SELECT * FROM Accounts");
            pstmt.setBigDecimal(1, getBalance().add(sum));
            pstmt.setString(2, this.user);
            pstmt.executeUpdate();
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BigDecimal getSum(){
        return sum;
    }

    public BigDecimal getDiff(){
        return diff;
    }

    public BigDecimal getAmount(){
        return amount;
    }

    public String reportUser(){
        return "Account no. " + accountNo + " has a balance of " + "$" + balance + ".";
    }


}
