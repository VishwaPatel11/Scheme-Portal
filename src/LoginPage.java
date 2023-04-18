import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {
        JFrame frame = new JFrame();
        JButton signUp = new JButton("SignUp");
        JButton button = new JButton("LogIn");
        JButton resetButton = new JButton("Reset");
        JTextField userIDField = new JTextField(); // blank area to write user id
        JPasswordField userPasswordField = new JPasswordField(); // blank area to write password(unseen)
        JLabel userIDLabel = new JLabel("User-ID");
        JLabel userpasswordLabel = new JLabel("Password");

        JLabel message = new JLabel();
        HashMap<String, String> logininfo = new HashMap<String, String>();
//        String mainUsername, mainPassword;
        LoginPage() {
                System.out.println("LoginPage");
        }

        void logicPageClass(HashMap _logininfo_){
        logininfo = _logininfo_;
//                mainUsername = username;
//                mainPassword = password;

        userIDLabel.setBounds(50,100,75,25);
        userpasswordLabel.setBounds(50,150,75,25);

        message.setBounds(125,250,250,35);
        message.setFont(new Font(null, Font.ITALIC, 25));

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125, 150, 200, 25);

        button.setBounds(250, 230, 100, 25);
        button.setFocusable(false);
        button.addActionListener(this);

        signUp.setBounds(150, 230, 100, 25);
        signUp.setFocusable(false);
        signUp.addActionListener(this);

        resetButton.setBounds(50, 230, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(signUp);
        frame.add(userIDLabel);
        frame.add(userpasswordLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(button);
        frame.add(resetButton);
        frame.add(message);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
        String pass;
    public void actionPerformed(ActionEvent e) {
            // to perform as per the frames buttons, on click.

            if(e.getSource() == signUp)
            {
                    frame.dispose();
                    // here the connection for DataBase will be accessed. 
                    SignUp sign = new SignUp();
                    sign.signUpClass();
            }

            if(e.getSource() == resetButton)
            {
                    userIDField.setText("");
                    userPasswordField.setText("");
            }
            if(e.getSource() == button)
            {
                    String id = userIDField.getText();
                    String password = String.valueOf(userPasswordField.getPassword());
                    pass = String.valueOf(userPasswordField.getPassword());
                    if(userIDField.getText().equals("") && pass.equals(""))
                    {
                            Toolkit.getDefaultToolkit().beep();
                            JOptionPane.showMessageDialog(null, "Please, Enter Username & Password");
                    }
                    else{
                            if(logininfo.containsKey(id))
                            {
                                    if(logininfo.containsValue(password))
                                    {
//                                    message.setForeground(Color.green);
//                                    message.setText("Login Successfully");
                                            frame.dispose();
                                            Toolkit.getDefaultToolkit().beep();
                                            JOptionPane.showMessageDialog(null, "Log-In Successfully");
                                            CardSelectionPage cardSelectionPage = new CardSelectionPage();
                                            cardSelectionPage.selectcard();
                                    }
                                    else
                                    {
                                            Toolkit.getDefaultToolkit().beep();
                                            JOptionPane.showMessageDialog(null, "Invalid Username & Password!");
                                    }
                            }
                            else
                            {
                                    Toolkit.getDefaultToolkit().beep();
                                    JOptionPane.showMessageDialog(null, "Invalid Username & Password!");
                            }
                    }
            }
    }
}