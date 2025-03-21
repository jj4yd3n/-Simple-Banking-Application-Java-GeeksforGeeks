import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class GUI extends Container implements ActionListener {
        private JFrame frame;
        private JPanel accountPortalPanel;
        private JPanel loginAccountPanel;
        private JPanel registerAccountPanel;
        private JPanel bankPanel;
        private JPanel withdrawMoneyPanel;
        private JPanel depositMoneyPanel;
        private JPanel transferMoneyPanel;
        private JButton signInButton;
        private JButton registerButton;
        private JButton transferBttn;
        private JButton depositBttn;
        private JButton withdrawBttn;
        private JButton balanceBttn;
        private JButton logoutBttn;
        private JTextField loginUsernameField;
        private JPasswordField loginPasswordField;
        private JTextField registerAccountField;
        private JTextField registerPasswordField;
        private JTextField withdrawMoneyField;
        private JTextField depositMoneyField;
        private JTextField transferMoneyAmount;
        private JTextField recepientAccountNoField;
        private JLabel enterAccountInformationPrompt;
        private String storedUsername;
        private JLabel accountPanelGreeting;
        private JLabel bankPanelUserGreeting;
        private JLabel promptRecepient;
        private JLabel promptTransferAmount;
        private JLabel promptUsername;
        private JLabel promptPassword;
        private JLabel placeHolder1;
        private JLabel placeHolder2;
        private JLabel placeHolder3;
        private JLabel placeHolder4;
        private JLabel placeHolder5;
        private JLabel placeHolder6;

    private Banking banking;
        private Integer myAccountNo;
        private GridBagLayout gridBagLayout;

    Account myAccount = new Account();
    Database database = new Database();
    boolean isAuthenticated = false;

    public GUI(){
            frame = new JFrame();
            accountPortalPanel = new JPanel();
            loginAccountPanel = new JPanel();
            registerAccountPanel = new JPanel();
            bankPanel = new JPanel();
            withdrawMoneyPanel = new JPanel();
            depositMoneyPanel = new JPanel();
            transferMoneyPanel = new JPanel();
            signInButton = new JButton("Sign in");
            registerButton = new JButton("Create account");
            transferBttn = new JButton("Transfer money");
            depositBttn = new JButton("Deposit");
            withdrawBttn = new JButton("Withdraw");
            balanceBttn = new JButton("View Balance");
            logoutBttn = new JButton("Log out");
            loginUsernameField = new JTextField(20);
            loginPasswordField = new JPasswordField(20);
            transferMoneyAmount = new JTextField(20);
            recepientAccountNoField = new JTextField(20);
            registerAccountField = new JTextField(20);
            registerPasswordField = new JPasswordField(20);
            withdrawMoneyField = new JTextField(10);
            depositMoneyField = new JTextField(10);
            enterAccountInformationPrompt = new JLabel("Please enter user information:");
            promptRecepient = new JLabel("Enter recepient's account No.:");
            promptTransferAmount = new JLabel("Amount of money to transfer:");
            promptUsername = new JLabel("Username");
            promptPassword = new JLabel("Password");
            bankPanelUserGreeting = new JLabel("");
            accountPanelGreeting = new JLabel("Welcome! Please login or register an account.");
            gridBagLayout = new GridBagLayout();
            placeHolder1 = new JLabel();
            placeHolder2 = new JLabel();
            placeHolder3= new JLabel();
            placeHolder4 = new JLabel();
            placeHolder5 = new JLabel();
            placeHolder6 = new JLabel();
            signInButton.addActionListener(this);
            transferBttn.addActionListener(this);
            registerButton.addActionListener(this);
            balanceBttn.addActionListener(this);
            withdrawBttn.addActionListener(this);
            depositBttn.addActionListener(this);
            logoutBttn.addActionListener(this);

            //MAIN PANEL
            accountPortalPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 3;
            accountPanelGreeting.setFont(new Font(accountPanelGreeting.getFont().getFontName(), accountPortalPanel.getFont().getStyle(), 20));
            accountPortalPanel.add(accountPanelGreeting, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.insets = new Insets(10,125,0,0);
            accountPortalPanel.add(signInButton, gbc);

            gbc.insets = new Insets(10,25,0,0);
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.EAST;
            accountPortalPanel.add(registerButton, gbc);

            accountPortalPanel.setPreferredSize(new Dimension(500,500));
            accountPortalPanel.setVisible(true);
            signInButton.setVerticalAlignment(SwingConstants.CENTER);
            registerButton.setVerticalAlignment(SwingConstants.CENTER);



            //SIGN IN PANEL
            loginAccountPanel.add(placeHolder1);
            loginAccountPanel.add(placeHolder2);
            loginAccountPanel.add(placeHolder3);
            loginAccountPanel.add(enterAccountInformationPrompt);
            loginAccountPanel.add(new JLabel("Username"));
            loginAccountPanel.add(loginUsernameField);
            loginAccountPanel.add(new JLabel("Password"));
            loginAccountPanel.add(loginPasswordField);
            loginAccountPanel.setLayout(new GridLayout(12,12));
            loginAccountPanel.setPreferredSize(new Dimension(250,250));
            loginAccountPanel.setVisible(true);

            //CREATE ACCOUNT PANEL
            registerAccountPanel.add(placeHolder4);
            registerAccountPanel.add(placeHolder5);
            registerAccountPanel.add(new JLabel("Create account"));
            registerAccountPanel.add(promptUsername);
            registerAccountPanel.add(registerAccountField);
            registerAccountPanel.add(promptPassword);
            registerAccountPanel.add(registerPasswordField);
            registerAccountPanel.setPreferredSize(new Dimension(250,250));
            registerAccountPanel.setLayout(new GridLayout(12,12));
            registerAccountPanel.setVisible(true);

            //BANKPANEL
            bankPanel.setPreferredSize(new Dimension(1000,250));
            bankPanel.setLayout(new GridBagLayout());
            gbc.weightx = 0;
            gbc.weighty = 0;

            bankPanelUserGreeting.setFont(new Font(bankPanelUserGreeting.getFont().getFontName(), bankPanelUserGreeting.getFont().getStyle(), 20));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 3;
            bankPanel.add(bankPanelUserGreeting, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.gridwidth = 1;
            bankPanel.add(transferBttn, gbc);

            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.EAST;
            gbc.gridwidth = 1;

            bankPanel.add(depositBttn, gbc);

            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridx = 2;
            gbc.gridy = 1;
            gbc.gridwidth = 1;

            bankPanel.add(withdrawBttn, gbc);

            gbc.gridx = 3;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.EAST;

            bankPanel.add(balanceBttn, gbc);

            gbc.gridx = 4;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.EAST;

            bankPanel.add(logoutBttn, gbc);

            gbc.gridx = 5;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            bankPanel.add(new JLabel(""), gbc);

            bankPanel.setVisible(true);

            //WITHDRAW PANEL
            withdrawMoneyField.add(new JLabel(""));
            withdrawMoneyField.add(new JLabel(""));
            withdrawMoneyField.add(new JLabel(""));
            withdrawMoneyPanel.add(new JLabel("Enter amount to withdraw:"));
            withdrawMoneyPanel.add(withdrawMoneyField);
            withdrawMoneyPanel.setPreferredSize(new Dimension(250,250));
            withdrawMoneyPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            withdrawMoneyPanel.setVisible(true);

            //DEPOSIT PANEL
            depositMoneyPanel.add(new JLabel(""));
            depositMoneyPanel.add(new JLabel(""));
            depositMoneyPanel.add(new JLabel("Enter amount to deposit:"));
            depositMoneyPanel.add(depositMoneyField);
            depositMoneyPanel.setPreferredSize(new Dimension(250,250));
            depositMoneyPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            depositMoneyPanel.setVisible(true);

            //TRANSFER PANEL
            transferMoneyPanel.add(promptRecepient);
            transferMoneyPanel.add(recepientAccountNoField);
            transferMoneyPanel.add(promptTransferAmount);
            transferMoneyPanel.add(transferMoneyAmount);
            transferMoneyPanel.setPreferredSize(new Dimension(250,250));
            transferMoneyPanel.setVisible(true);


            //MAIN FRAME
            frame.add(accountPortalPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Piece of Me Banking");
            frame.setLayout(new GridBagLayout());
            frame.setVisible(true);
            frame.pack();
        }


    @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String s = actionEvent.getActionCommand();
            //CODE FOR "SIGN IN" BUTTON
             if(s.equals("Create account")){
                int response1 = JOptionPane.showOptionDialog(null, registerAccountPanel, "Create account", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null,null);
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
                        bankPanelUserGreeting.setText("Hello, " + storedUsername + "!");
                        frame.remove(accountPortalPanel);
                        frame.setContentPane(bankPanel);
                        frame.setPreferredSize(new Dimension(500, 250));
                        frame.pack();

                    }
                }
            }
            else if(s.equals("Sign in")){
                int response = JOptionPane.showOptionDialog(null, loginAccountPanel, "Sign in", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null,null);
                if(response == JOptionPane.OK_OPTION){
                    //Does the if statement above work?
                    // System.out.println("User pressed OK.");
                    //Check if username and password boxes are empty. If one of them are, print if statement. IF they are not empty, print else statement.
                    if(loginUsernameField.getText().isEmpty() || loginPasswordField.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please type in your username and password.");
                    }
                    else{
                            if(myAccount.checkPass(loginPasswordField.getText(), loginUsernameField.getText()) && !myAccount.getExceptStatus()){
                            isAuthenticated = true;
                                myAccountNo = database.retriveAccountNo(loginUsernameField.getText());
                                banking = new Banking(myAccountNo);
                                JOptionPane.showMessageDialog(null, "Signed in!");
                                this.storedUsername = loginUsernameField.getText();
                                bankPanelUserGreeting.setText("Hello, " + storedUsername + "!");
                                frame.remove(accountPortalPanel);
                            frame.setContentPane(bankPanel);
                                frame.setPreferredSize(new Dimension(1000, 500));
                                frame.pack();
                            }
                            //Prevent error msg to pop up again by only running method if checkPass hasn't thrown an exception.
                        else if (!myAccount.threwException){
                            myAccount.incorrectErrorDialog();
                        }
                    }
                }

            }
            else if(s.equals("Transfer money")){
                int response2 = JOptionPane.showOptionDialog(null, transferMoneyPanel, "Transfer money", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
                if(response2 == JOptionPane.OK_OPTION) {
                    try{
                        if (transferMoneyAmount.getText().isEmpty() || recepientAccountNoField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter a double!");
                        }
                        else if (Double.parseDouble(transferMoneyAmount.getText()) < 0) {
                            JOptionPane.showMessageDialog(null, "Please enter a positive double!");
                        }
                        else if (!database.retrieveAccountNos().contains(Integer.parseInt(recepientAccountNoField.getText()))) {
                            JOptionPane.showMessageDialog(null, "Please enter the correct account No.");
                        }
                        else if (Integer.parseInt(recepientAccountNoField.getText()) == myAccountNo){
                            JOptionPane.showMessageDialog(null, "Cannot transfer money to your own account. Please try again.");
                        }
                        else if(new BigDecimal(transferMoneyAmount.getText()).compareTo(banking.getBalance()) == 1){
                            JOptionPane.showMessageDialog(null, "Insufficient funds!");
                        }
                        else {
                            int confirmTransfer = JOptionPane.showOptionDialog(null,"Are you sure you want to transfer $" + transferMoneyAmount.getText() + "?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
                            if(confirmTransfer == JOptionPane.YES_OPTION){
                                banking.transferMoney(new BigDecimal(transferMoneyAmount.getText()), Integer.parseInt(recepientAccountNoField.getText()));
                                JOptionPane.showMessageDialog(null, "Successfully transferred " + "$" + banking.getAmount() + "!\nRemaining balance is now $" + banking.getBalance());
                            }
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Please enter a double!");
                    }


                }

             }

            //CODE FOR BANKING BUTTONS
            else if(s.equals("Withdraw")){
                int response3 = JOptionPane.showOptionDialog(null, withdrawMoneyPanel, "Withdraw", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null, null,null);
                if(response3 == JOptionPane.OK_OPTION){
                    try{
                        if(withdrawMoneyField.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Please enter a double!");
                        }
                        else if(Double.parseDouble(withdrawMoneyField.getText()) < 0){
                            JOptionPane.showMessageDialog(null, "Please enter a positive double!");
                        }
                        else if(new BigDecimal(withdrawMoneyField.getText()).compareTo(banking.getBalance()) == 1){
                            JOptionPane.showMessageDialog(null, "Insufficient funds!");
                        }
                        else if(!withdrawMoneyField.getText().isEmpty()){
                            banking.withdrawBal(new BigDecimal(withdrawMoneyField.getText()));
                            JOptionPane.showMessageDialog(null, "Successfully withdrew " + "$" + banking.getDiff() + "!\n Remaining balance is now $" + banking.getBalance());
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Please enter a double!");
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
                int response4 = JOptionPane.showOptionDialog(null, depositMoneyPanel, "Deposit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null, null,null);
                if (response4 == JOptionPane.OK_OPTION) {
                    try{
                        if (Double.parseDouble(depositMoneyField.getText()) > 0 && Double.parseDouble(depositMoneyField.getText()) <= 10000) {
                            banking.depositBal(new BigDecimal(depositMoneyField.getText()));
                            JOptionPane.showMessageDialog(null, "Successfuly deposited $" + banking.getSum() + "!\n" + "Remaining balance is now $" + banking.getBalance());
                        }
                        else if (depositMoneyField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter a double!");
                        }
                        else if (Double.parseDouble(depositMoneyField.getText()) > 10000) {
                            JOptionPane.showMessageDialog(null, "Please contact your bank for more information.");
                        }
                        else if(new BigDecimal(depositMoneyField.getText()).compareTo(banking.getBalance()) == 1){
                            JOptionPane.showMessageDialog(null, "Insufficient funds!");
                        }
                        else if (Double.parseDouble(depositMoneyField.getText()) < 0) {
                            JOptionPane.showMessageDialog(null, "Please enter a positive double.");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Please enter a double!");
                    }


                }
            }
            else if(s.equals("Log out")){
                int response5 = JOptionPane.showOptionDialog(null,"Are you sure you want to log out?","Log out", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,null, null);
                    if(response5 == JOptionPane.OK_OPTION){
                        isAuthenticated = false;
                        frame.setContentPane(accountPortalPanel);
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
