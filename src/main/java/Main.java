import at.favre.lib.crypto.bcrypt.BCrypt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main {
    public static void main(String[] args) {
    new GUI();
    Database database = new Database();
    String placeUser = "showman6595";
    boolean userTaken = false;

        Account myAccount = new Account();
        System.out.println(database.printDB());
    //myAccount.registerUser("showman6595", "7Fp6GsXFT4PolV");
        System.out.println(database.retrieveUsers());

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
