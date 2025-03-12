import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class GUI implements ActionListener {
        private JFrame frame;
        private JPanel mainPanel;
        private JPanel loginPanel;
        private JPanel registerPanel;
        private JPanel bankPanel;
        private JPanel withdrawPanel;
        private JPanel depositPanel;
        private JPanel transferPanel;
        private JButton signinBttn;
        private JButton registerBttn;
        private JButton transferBttn;
        private JButton depositBttn;
        private JButton withdrawBttn;
        private JButton balanceBttn;
        private JButton logoutBttn;
        private JTextField loginUserField;
        private JPasswordField loginPassField;
        private JTextField registerAccountField;
        private JTextField registerPasswordField;
        private JTextField wdrawField;
        private JTextField depField;
        private JTextField transferField;
        private JTextField recepientField;
        private JLabel jLabel;
        private String storedUsername;
        private JLabel userGreeting;
        private JLabel promptRecepient;
        private JLabel promptTransferAmount;
        private JLabel promptUsername;
        private JLabel promptPassword;
        private JLabel pHolder1;
        private JLabel pHolder2;
        private JLabel pHolder3;
        private JLabel pHolder4;
        private Banking banking;
        private Integer myAccountNo;
        private GridBagLayout gridBagLayout;

    Account myAccount = new Account();
    Database database = new Database();
    boolean isAuthenticated = false;

    public GUI(){
            frame = new JFrame();
            mainPanel = new JPanel();
            loginPanel = new JPanel();
            registerPanel = new JPanel();
            bankPanel = new JPanel();
            withdrawPanel = new JPanel();
            depositPanel = new JPanel();
            transferPanel = new JPanel();
            signinBttn = new JButton("Sign in");
            registerBttn = new JButton("Create account");
            transferBttn = new JButton("Transfer money");
            depositBttn = new JButton("Deposit");
            withdrawBttn = new JButton("Withdraw");
            balanceBttn = new JButton("View Balance");
            logoutBttn = new JButton("Log out");
            loginUserField = new JTextField(20);
            loginPassField = new JPasswordField(20);
            transferField = new JTextField(20);
            recepientField = new JTextField(20);
            registerAccountField = new JTextField(20);
            registerPasswordField = new JPasswordField(20);
            wdrawField = new JTextField(10);
            depField = new JTextField(10);
            jLabel = new JLabel("Please enter user information:");
            promptRecepient = new JLabel("Enter recepient's account No.:");
            promptTransferAmount = new JLabel("Amount of money to transfer:");
            promptUsername = new JLabel("Username");
            promptPassword = new JLabel("Password");
            userGreeting = new JLabel("");
        gridBagLayout = new GridBagLayout();
            pHolder2 = new JLabel();
            pHolder1 = new JLabel();
            //pHolder3 = new JLabel();
            //pHolder4 = new JLabel();
            signinBttn.addActionListener(this);
            transferBttn.addActionListener(this);
            registerBttn.addActionListener(this);
            balanceBttn.addActionListener(this);
            withdrawBttn.addActionListener(this);
            depositBttn.addActionListener(this);
            logoutBttn.addActionListener(this);

            //MAIN PANEL
            //mainPanel.add(pHolder3);
            //mainPanel.add(pHolder4);
            mainPanel.add(signinBttn);
            mainPanel.add(Box.createHorizontalStrut(13));
            mainPanel.add(registerBttn);
            mainPanel.setSize(500,250);
            mainPanel.setVisible(true);
            mainPanel.setLayout(gridBagLayout);
            signinBttn.setVerticalAlignment(SwingConstants.CENTER);
            registerBttn.setVerticalAlignment(SwingConstants.CENTER);


            //SIGN IN PANEL
            loginPanel.add(pHolder1);
            loginPanel.add(pHolder2);
            loginPanel.add(jLabel);
            loginPanel.add(new JLabel("Username"));
            loginPanel.add(loginUserField);
            loginPanel.add(new JLabel("Password"));
            loginPanel.add(loginPassField);
            loginPanel.setLayout(new GridLayout(12,12));
            loginPanel.setPreferredSize(new Dimension(250,250));
            loginPanel.setVisible(true);

            //CREATE ACCOUNT PANEL
            registerPanel.add(new JLabel("Create account"));
            registerPanel.add(promptUsername);
            registerPanel.add(registerAccountField);
            registerPanel.add(promptPassword);
            registerPanel.add(registerPasswordField);
            registerPanel.setPreferredSize(new Dimension(250,250));
            registerPanel.setLayout(new GridLayout(12,12));
            registerPanel.setVisible(true);

            //BANKPANEL
            userGreeting.setFont(new Font(userGreeting.getFont().getFontName(), userGreeting.getFont().getStyle(), 20));
            bankPanel.add(userGreeting);
            bankPanel.add(transferBttn);
            bankPanel.add(depositBttn);
            bankPanel.add(withdrawBttn);
            bankPanel.add(balanceBttn);
            bankPanel.add(logoutBttn);
            bankPanel.setLayout(new GridLayout(12,12));
            bankPanel.setPreferredSize(new Dimension(250,1000));
            bankPanel.setVisible(true);

            //WITHDRAW PANEL
            withdrawPanel.add(wdrawField);
            withdrawPanel.setPreferredSize(new Dimension(250,250));
            withdrawPanel.setVisible(true);

            //DEPOSIT PANEL
            depositPanel.add(depField);
            depositPanel.setPreferredSize(new Dimension(250,250));
            depositPanel.setVisible(true);

            //TRANSFER PANEL
            transferPanel.add(promptRecepient);
            transferPanel.add(recepientField);
            transferPanel.add(promptTransferAmount);
            transferPanel.add(transferField);
            transferPanel.setPreferredSize(new Dimension(250,250));
            transferPanel.setVisible(true);


            //MAIN FRAME
            frame.add(mainPanel, BorderLayout.CENTER);
            frame.setMinimumSize(new Dimension(500,250));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Piece of Me Banking");
            frame.setLayout(gridBagLayout);
            frame.setVisible(true);
            frame.pack();
        }


    @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String s = actionEvent.getActionCommand();
            //CODE FOR "SIGN IN" BUTTON
             if(s.equals("Create account")){
                int response1 = JOptionPane.showOptionDialog(null, registerPanel, "Create account", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null,null);
                if(response1 == JOptionPane.OK_OPTION){
                    if(registerAccountField.getText().isEmpty() || registerPasswordField.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please type in a username and password.");
                    }
                    else if(database.retrieveAccountNos().contains(registerAccountField.getText())){
                        JOptionPane.showMessageDialog(null,"Username already taken!");
                    }
                    else{
                        myAccount.registerUser(registerAccountField.getText(), registerPasswordField.getText(), new BigDecimal("1000.0"));
                        myAccountNo = database.retriveAccountNo(registerAccountField.getText());
                        banking = new Banking(myAccountNo);
                        JOptionPane.showMessageDialog(null, "Successfully created account!");
                        this.storedUsername = registerAccountField.getText();
                        userGreeting.setText("Hello, " + storedUsername + "!");
                        frame.remove(mainPanel);
                        frame.setContentPane(bankPanel);
                        frame.revalidate();

                    }
                }
            }
            else if(s.equals("Sign in")){
                int response = JOptionPane.showOptionDialog(null, loginPanel, "Sign in", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null,null);
                if(response == JOptionPane.OK_OPTION){
                    //Does the if statement above work?
                    // System.out.println("User pressed OK.");
                    //Check if username and password boxes are empty. If one of them are, print if statement. IF they are not empty, print else statement.
                    if(loginUserField.getText().isEmpty() || loginPassField.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please type in your username and password.");
                    }
                    else{
                            if(myAccount.checkPass(loginPassField.getText(),loginUserField.getText()) && !myAccount.getExceptStatus()){
                            isAuthenticated = true;
                                myAccountNo = database.retriveAccountNo(loginUserField.getText());
                                banking = new Banking(myAccountNo);
                                JOptionPane.showMessageDialog(null, "Signed in!");
                                this.storedUsername = loginUserField.getText();
                                userGreeting.setText("Hello, " + storedUsername + "!");
                                frame.remove(mainPanel);
                            frame.setContentPane(bankPanel);
                            frame.revalidate();
                            }
                            //Prevent error msg to pop up again by only running method if checkPass hasn't thrown an exception.
                        else if (!myAccount.threwException){
                            myAccount.incorrectErrorDialog();
                        }
                    }
                }

            }
            else if(s.equals("Transfer money")){
                int response2 = JOptionPane.showOptionDialog(null, transferPanel, "Transfer money", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
                if(response2 == JOptionPane.OK_OPTION) {
                    if (transferField.getText().isEmpty() || recepientField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a double!");
                    }
                   else if (Double.parseDouble(transferField.getText()) < 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a positive double!");
                    }
                    else if (!database.retrieveAccountNos().contains(Integer.parseInt(recepientField.getText()))) {
                        JOptionPane.showMessageDialog(null, "Please enter the correct account No.");
                    }
                    else if(new BigDecimal(transferField.getText()).compareTo(banking.getBalance()) == 1){
                        JOptionPane.showMessageDialog(null, "Insufficient funds!");
                    }
                   //TODO Forbid user from proceeding further if they type Strings in either transferField or recepientField
                    else {
                        int confirmTransfer = JOptionPane.showOptionDialog(null,"Are you sure you want to transfer $" + transferField.getText() + "?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
                        if(confirmTransfer == JOptionPane.YES_OPTION){
                            banking.transferMoney(new BigDecimal(transferField.getText()), Integer.parseInt(recepientField.getText()));
                            JOptionPane.showMessageDialog(null, "Successfully transferred " + "$" + banking.getAmount() + "!\nRemaining balance is now $" + banking.getBalance());
                        }
                    }

                }

             }

            //CODE FOR BANKING BUTTONS
            else if(s.equals("Withdraw")){
                int response3 = JOptionPane.showOptionDialog(null, withdrawPanel, "Withdraw", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null, null,null);
                if(response3 == JOptionPane.OK_OPTION){
                    if(wdrawField.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please enter a double!");
                    }
                    else if(Double.parseDouble(wdrawField.getText()) < 0){
                        JOptionPane.showMessageDialog(null, "Please enter a positive double!");
                    }
                    else if(new BigDecimal(wdrawField.getText()).compareTo(banking.getBalance()) == 1){
                        JOptionPane.showMessageDialog(null, "Insufficient funds!");
                    }
                    else if(!wdrawField.getText().isEmpty()){
                        banking.withdrawBal(new BigDecimal(wdrawField.getText()));
                        JOptionPane.showMessageDialog(null, "Successfully withdrew " + "$" + banking.getDiff() + "!\n Remaining balance is now $" + banking.getBalance());
                    }
                }
            }
            else if(s.equals("View Balance")){
                //TODO Format balance as "-$10" if balance is less than 0
                if(banking.getBalance().compareTo(new BigDecimal(0)) == -1){
                    JOptionPane.showMessageDialog(null, "Remaining balance: " + "$" + banking.getBalance());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Remaining balance: " + "$" + banking.getBalance());
                }
            }
            else if(s.equals("Deposit")){
                int response4 = JOptionPane.showOptionDialog(null, depositPanel, "Deposit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null, null,null);
                if (response4 == JOptionPane.OK_OPTION) {
                    if (Double.parseDouble(depField.getText()) > 0 && Double.parseDouble(depField.getText()) <= 10000) {
                        banking.depositBal(new BigDecimal(depField.getText()));
                        JOptionPane.showMessageDialog(null, "Successfuly deposited $" + banking.getSum() + "!");
                    }
                    else if (depField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a double!");
                    }
                    else if (Double.parseDouble(depField.getText()) > 10000) {
                        JOptionPane.showMessageDialog(null, "Please contact your bank for more information.");
                    }
                    else if(new BigDecimal(depField.getText()).compareTo(banking.getBalance()) == 1){
                        JOptionPane.showMessageDialog(null, "Insufficient funds!");
                    }
                    else if (Double.parseDouble(depField.getText()) < 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a positive double.");
                    }
                    else if (depField.getText() != null) {
                        JOptionPane.showMessageDialog(null, "Please enter a double!");
                    }

                }
            }
            else if(s.equals("Log out")){
                int response5 = JOptionPane.showOptionDialog(null,"Are you sure you want to log out?","Log out", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,null, null);
                    if(response5 == JOptionPane.OK_OPTION){
                        isAuthenticated = false;
                        frame.setContentPane(mainPanel);
                        frame.revalidate();
                }
            }

        }




    public String getUser(){
            return registerAccountField.getText();
        }

        public boolean getAuthStatus(){
            return isAuthenticated;
        }







    }
