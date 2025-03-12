import java.math.BigDecimal;
import java.sql.*;

public class Banking {
    private int accountNo;
    private BigDecimal balance;
    private BigDecimal diff;
    private BigDecimal sum;
    private BigDecimal amount;
    private BigDecimal recipientBal;
    private Integer currentAccountNo;
    private String currentUsername;

    Database database = new Database();
    String url = "jdbc:mysql://localhost:3306/javaBank";
    String u = "root";
    String p = "britneybitch";

    public Banking(Integer AccountNo){
        this.currentAccountNo = AccountNo;
        try {
            Connection connection = DriverManager.getConnection(url, u, p);
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            String sql = "SELECT * FROM Accounts WHERE accountNo = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, currentAccountNo);
            resultSet = pstmt.executeQuery();
            while(resultSet.next()){
                this.currentAccountNo = resultSet.getInt("accountNo");
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
        try {
            Connection connection = DriverManager.getConnection(url, u, p);
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            String sql = "SELECT * FROM Accounts WHERE accountNo = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, this.currentAccountNo);
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

    public BigDecimal doubleBalance(){
        BigDecimal balance = BigDecimal.valueOf(0.0);
        try {
            Connection connection = DriverManager.getConnection(url, u, p);
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            String sql = "SELECT * FROM Accounts WHERE accountNo = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, this.currentAccountNo);
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

    public BigDecimal getUserBalance(Integer accountNo){
        BigDecimal balance = BigDecimal.valueOf(0.0);
        try {
            Connection connection = DriverManager.getConnection(url, u, p);
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            String sql = "SELECT * FROM Accounts WHERE accountNo = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, accountNo);
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


    public void subtractBalance(BigDecimal amount, Integer user){
        try {
            Connection connection = DriverManager.getConnection(url, u, p);
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            String query = "UPDATE Accounts set balance = ? where accountNo = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            resultSet = statement.executeQuery("SELECT * FROM Accounts");
            pstmt.setBigDecimal(1, getUserBalance(user).subtract(amount));
            pstmt.setInt(2, user);
            pstmt.executeUpdate();

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    public void transferMoney(BigDecimal amount, Integer accountNo){
        this.amount = amount;
        try {
            Connection connection = DriverManager.getConnection(url, u, p);
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            String query = "UPDATE Accounts set balance = ? where accountNo = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            resultSet = statement.executeQuery("SELECT * FROM Accounts");
            subtractBalance(amount, this.currentAccountNo);
            pstmt.setBigDecimal(1, getUserBalance(accountNo).add(amount));
            pstmt.setInt(2, accountNo);
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
            String getBack = "UPDATE Accounts set balance = ? WHERE accountNo = ?";
            PreparedStatement pstmt = connection.prepareStatement(getBack);
            resultSet = statement.executeQuery("SELECT * FROM Accounts");
            pstmt.setBigDecimal(1, getBalance().subtract(diff));
            pstmt.setInt(2, this.currentAccountNo);
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
            String getBack = "UPDATE Accounts set balance = ? WHERE accountNo = ?";
            PreparedStatement pstmt = connection.prepareStatement(getBack);
            resultSet = statement.executeQuery("SELECT * FROM Accounts");
            pstmt.setBigDecimal(1, getBalance().add(sum));
            pstmt.setInt(2, this.currentAccountNo);
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
