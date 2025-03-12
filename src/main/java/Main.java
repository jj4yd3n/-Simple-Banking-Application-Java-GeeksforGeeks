import at.favre.lib.crypto.bcrypt.BCrypt;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main {
    public static void main(String[] args) {
    GUI gui = new GUI();
        Account myAccount = new Account();
        Database database = new Database();
        Banking banking = new Banking(102);
    String placeUser = "showman6595";
    String placePass = "7Fp6GsXFT4PolV";
    boolean userTaken = false;


    /* Retrieve "passwords" column aka BCrypt hases from DB
    System.out.println(database.retrieveHash());
     */

    //System.out.println(myAccount.checkPass(placePass)); //Prints true or false when .checkPass() is called.
    //System.out.println(database.retrievePassHash("hello")); //Print Bcrypt hash for "hello" account.
    //System.out.println(gui.getUser()); //Print userBox.getText() from GUI.java
        /*

        System.out.println(database.getBalance("hello")); // Print balance of "hello" account.
        banking.depositBal(5000.0);
        System.out.println(database.getBalance("hello"));
        System.out.println(banking.viewBalance());

        banking.depositBal(1000.0);
         */

        /* Testing some methods
        System.out.println(banking.getBalance());
        banking.depositBal(BigDecimal.valueOf(2000.0));
        System.out.println(banking.getBalance());
         */




    //myAccount.registerUser("showman6595", "7Fp6GsXFT4PolV");

    /* Program can register an account to the database.
    myUser.registerUser("asdfafsd", "asdfasfasddsf", 323);
     */

        //myUser.registerUser("Britney Jean", "jamielynn");

    /* Successfully: created "Banking" object, setting balance of person, viewing person's balance and reporting a string of user's bank account.
    Banking person = new Banking(110,500.0);
    person.setBalance(12.52);
    System.out.println(person.viewBalance());
    System.out.println(person.reportUser());
     */

    /* Confirm .withdrawBal() methods works as intended.
    Banking person1 = new Banking(110,500.0);
        person1.withdrawBal(60.0);
        System.out.println(person1.reportUser());
     */
    }

}
