import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel altPanel;
    private JButton button1;
    private JButton button2;
    private JTextField jTextField;
    private JTextField jTextField1;
    private JLabel jLabel;

    public GUI(){
        frame = new JFrame();
        mainPanel = new JPanel();
        altPanel = new JPanel();
        button1 = new JButton("Sign in");
        button2 = new JButton("Create account");
        jTextField = new JTextField(20);
        jTextField1 = new JTextField(20);
        jLabel = new JLabel("Please enter user information:", SwingConstants.CENTER);
        button1.addActionListener(this);
        button2.addActionListener(this);


        mainPanel.add(button1);
        mainPanel.add(button2);
        altPanel.add(jLabel);
        altPanel.add(jTextField);
        altPanel.add(jTextField1);
        mainPanel.setSize(500,500);
        mainPanel.setVisible(true);
        altPanel.setPreferredSize(new Dimension(500,500));
        altPanel.setVisible(true);

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
        if(s.equals("Sign in")){
            int response = JOptionPane.showOptionDialog(null, altPanel, "Sign in", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null,null);
            if(response == JOptionPane.OK_OPTION){
                //Does the if statement above work?
                // System.out.println("User pressed OK.");
                if(jTextField.getText() != null && jTextField1.getText() != null){
                    JOptionPane.showMessageDialog(null, "Please type in your username and password.");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Signed in!");
                }
            }

        }
    }







}
