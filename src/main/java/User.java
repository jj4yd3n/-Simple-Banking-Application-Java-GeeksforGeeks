import java.sql.*;

public class User {
    private Integer accountNo;
    private Double balance;
    private String username;
    private String password;

    public User(String username, String password, Integer accountNo, Double balance){
        this.accountNo = accountNo;
        this.balance = balance;
        this.username = username;
        this.password = password;
    }

    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/javaBank";
        String username = "root";
        String password = "britneybitch";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM Accounts");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
