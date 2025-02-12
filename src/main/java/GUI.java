import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel altPanel;
    private JPanel altPanel1;
    private JButton button1;
    private JButton button2;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JLabel jLabel;

    public GUI(){
        frame = new JFrame();
        mainPanel = new JPanel();
        altPanel = new JPanel();
        altPanel1 = new JPanel();
        button1 = new JButton("Sign in");
        button2 = new JButton("Create account");
        jTextField1 = new JTextField(20);
        jTextField2 = new JTextField(20);
        jTextField3 = new JTextField(20);
        jTextField4 = new JTextField(20);
        jLabel = new JLabel("Please enter user information:", SwingConstants.CENTER);
        button1.addActionListener(this);
        button2.addActionListener(this);


        mainPanel.add(button1);
        mainPanel.add(button2);
        altPanel.add(jLabel);
        altPanel.add(jTextField1);
        altPanel.add(jTextField2);
        altPanel1.add(jTextField3);
        altPanel1.add(jTextField4);
        mainPanel.setSize(500,500);
        mainPanel.setVisible(true);
        altPanel.setPreferredSize(new Dimension(500,500));
        altPanel.setVisible(true);
        altPanel1.setPreferredSize(new Dimension(500,500));
        altPanel1.setVisible(true);

        frame.add(mainPanel);
        frame.setMinimumSize(new Dimension(500,500));
        frame.setTitle("Piece of Me Banking");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String s = actionEvent.getActionCommand();
        //CODE FOR "SIGN IN" BUTTON
        if(s.equals("Sign in")){
            int response = JOptionPane.showOptionDialog(null, altPanel, "Sign in", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null,null);
            if(response == JOptionPane.OK_OPTION){
                //Does the if statement above work?
                // System.out.println("User pressed OK.");
                //Check if username and password boxes are empty. If one of them are, print if statement. IF they are not empty, print else statement.
                if(jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please type in your username and password.");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Signed in!");
                }
            }

        }
        else if(s.equals("Create account")){
            int response1 = JOptionPane.showOptionDialog(null, altPanel1, "Create account", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null,null);
            if(response1 == JOptionPane.OK_OPTION){
                if(jTextField3.getText().isEmpty() || jTextField4.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please type in a username and password.");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Successfully created account!");
                }
            }
        }
    }







}
