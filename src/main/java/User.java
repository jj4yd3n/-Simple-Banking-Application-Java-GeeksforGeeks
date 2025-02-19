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

    public void registerUser(String username, String password, Integer accountNo, Double balance){
        String url = "jdbc:mysql://localhost:3306/javaBank";
        String u = "root";
        String p = "britneybitch";
        try {
            Connection connection = DriverManager.getConnection(url, u, p);
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT * FROM Accounts");
            while(resultSet.next()){
                String user = resultSet.getString("username");
                String pass = resultSet.getString("password");
                Integer accountNo1 = resultSet.getInt("accountNo");
                System.out.println("Table: " + user + " " + pass + " " + accountNo);
            }
            //statement.executeUpdate("INSERT INTO Accounts (username, password, accountNo) VALUES ('Lindsay Lohan', 'ihateparishilton', 121)");
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
