import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class SignUp implements ActionListener  {

    String firstname__ , middlename__, lastname__, phonenumber__, username__, password__, gender__, email__, income__, birthday__;
    String firstPassword;
    String secondPassword;
    String finalUsername;

    JLabel firstname = new JLabel("First Name: ");
    JTextField firstnamefield = new JTextField();

    JLabel middlename = new JLabel("Middle Name: ");
    JTextField middlenamefield = new JTextField();

    JLabel lastname = new JLabel("Last Name: ");
    JTextField lastnamefield = new JTextField();

    JLabel phone = new JLabel("Phone number: ");
    JTextField phonefield = new JTextField();

    JLabel username = new JLabel("Username: ");
    JTextField usernamefield = new JTextField();

    JLabel password = new JLabel("Password: ");
    JPasswordField passwordfield = new JPasswordField();

    JLabel confirmpassword = new JLabel("Confirm Password: ");
    JPasswordField confirmpasswordfield = new JPasswordField();

    JLabel forPassword = new JLabel("Click To View Your Password");

    JFrame frame = new JFrame();
    JButton resetButton = new JButton("Reset");
    JButton submitButton = new JButton("Submit");
    JButton viewPassword = new JButton("Click");

        SignUp()
        {
            System.out.println("SignUp");
        }


        void signUpClass(){

            // First name
            firstname.setBounds(65,40,110,25);
            firstname.setFont(new Font("", 10, 15));
            firstnamefield.setBounds(185,40,250,25);
            // middle name
            middlename.setBounds(65, 100, 110, 25);
            middlename.setFont(new Font("", 10, 15));
            middlenamefield.setBounds(185, 100, 250, 25);
            // last name
            lastname.setBounds(65, 160, 110, 25);
            lastname.setFont(new Font("", 10, 15));
            lastnamefield.setBounds(185, 160, 250, 25);
            // phone number
            phone.setBounds(65, 220, 110, 25);
            phone.setFont(new Font("", 10, 15));
            phonefield.setBounds(185, 220, 250, 25);
            // username CREATE
            username.setBounds(65, 280, 110, 25);
            username.setFont(new Font("", 10, 15));
            usernamefield.setBounds(185, 280, 250, 25);
            // password NEW
            password.setBounds(65, 340, 110, 25);
            password.setFont(new Font("", 10, 15));
            passwordfield.setBounds(185, 340, 250, 25);
            // confirm Password NEW
            confirmpassword.setBounds(35, 400, 150, 25);
            confirmpassword.setFont(new Font("", 10, 15));
            confirmpasswordfield.setBounds(185, 400, 250, 25);

            // submit button
            submitButton.setBounds(335, 500, 100, 25);
            submitButton.setFocusable(false);
            submitButton.addActionListener(this);
            // cancel button
            // reset button
            resetButton.setBounds(185, 500, 100, 25);
            resetButton.setFocusable(false);
            resetButton.addActionListener(this);

            forPassword.setBounds(65, 440, 200, 25);
            forPassword.setFont(new Font("", 10, 15));

            viewPassword.setBounds(275, 442, 80, 20);
            viewPassword.setFocusable(false);
            viewPassword.addActionListener(this);


            frame.add(firstname);
            frame.add(firstnamefield);
            frame.add(middlename);
            frame.add(middlenamefield);
            frame.add(lastname);
            frame.add(lastnamefield);
            frame.add(username);
            frame.add(usernamefield);
            frame.add(phone);
            frame.add(phonefield);
            frame.add(password);
            frame.add(passwordfield);
            frame.add(confirmpassword);
            frame.add(confirmpasswordfield);
            frame.add(resetButton);
            frame.add(submitButton);
            frame.add(forPassword); // label to inform the user to view their password.
            frame.add(viewPassword); // This is the button to view the password entered by the user
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500,600);
            frame.setLayout(null);
            frame.setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent send) {
        if(send.getSource() == resetButton)
        {
            firstnamefield.setText("");
            middlenamefield.setText("");
            lastnamefield.setText("");
            phonefield.setText("");
            usernamefield.setText("");
            passwordfield.setText("");
            confirmpasswordfield.setText("");
            System.out.println("Here, All the Inputs by the user will be get erased and are lost");
        }
        else if(send.getSource() == submitButton)
        {

            firstPassword = String.valueOf(passwordfield.getPassword());
            secondPassword = String.valueOf(confirmpasswordfield.getPassword());
            boolean checker;


            checker = !firstnamefield.getText().equals("") && !middlenamefield.getText().equals("") && !lastnamefield.getText().equals("") && !phonefield.getText().equals("") && !usernamefield.getText().equals("") && !firstPassword.equals("") && !secondPassword.equals("");
            if(checker)
            {
                if(firstPassword.equals(secondPassword))
                {
                    firstname__ = firstnamefield.getText();
                    middlename__ = middlenamefield.getText();
                    lastname__ = lastnamefield.getText();
                    phonenumber__ = phonefield.getText();
                    username__ = usernamefield.getText();
                    password__ = firstPassword;
                    toInsertDataIntoDataBase();
//                    finalUsername = usernamefield.getText();
                    Toolkit.getDefaultToolkit().beep();

                    JOptionPane.showMessageDialog(null, "Your Account Is Created Successfully.");
                    Password_Id passwordId = new Password_Id();
                    HashMap<String, String> data = new HashMap<>(passwordId.map);

                    data.put(usernamefield.getText(), firstPassword);
                    System.out.println(data.keySet() + " " + data.values());

                    frame.dispose();
                    LoginPage log = new LoginPage();
                    log.logicPageClass(data);
                }
                else {
                    // Error, For Retry or else exit
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Password Doesn't Match!");
                }

            }
            else {
                System.out.println("Incomplete Form Validation");
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Please, Enter Your Details.");
            }
        }

        else if(send.getSource() == viewPassword) // This is Button for activation
        {
            // Here User can check his password, directly
//            System.out.println("click");
            String firstPassword;
            String secondPassword;
            firstPassword = String.valueOf(passwordfield.getPassword());
            secondPassword = String.valueOf(confirmpasswordfield.getPassword());
            System.out.println("Your <1> Password is: " + firstPassword);
            System.out.println("Your <2> Password is: " + secondPassword);
        }
    }
    public void toInsertDataIntoDataBase()
    {

        char value = '"';
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/SE_Project"; // replace "testdb" with your database name
        String username = "root"; // replace with your MySQL username
        String password = "kunn"; // replace with your MySQL password

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();

//            String sql = "insert into contents(" + firstname + ", " + middlename + ", " + lastname + ", " + phone.getText() + ", " + usernamefield.getText() + ", " + firstPassword + ")";
//            String sql = "insert into contents(FirstName, MiddleName, LastName, Gender, PhoneNumber, E_mail, Income, BirthDate, UserName, passwords) values(" +  value + firstname__ + value+ ", " + value + middlename__ + value + ", " + value + lastname__ + value + ", " + value + gender__ + value + ", " + value + phonenumber__ + value + ", " + value + email__ + value + ", " + value + income__ + value + ", " + value + birthday__ + value + ", " + value + username__ + value + ", " + value + password__ + value + ")";
            String sql = "insert into firstTable(FirstName, MiddleName, LastName, PhoneNumber, UserName, Passwords) values(" + value + firstname__ + value+ ", " + value + middlename__ + value + ", " + value + lastname__ + value + ", " + value + phonenumber__ + value + ", " + value + username__ + value + ", " + value + password__ + value + ")";

            stmt.executeUpdate(sql);

            System.out.println("Values inserted into table successfully!");
//            Toolkit.getDefaultToolkit().beep();
//            JOptionPane.showMessageDialog(null, "Username & Password are created Successfully");

        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt != null) {
                    conn.close();
                }
            } catch(SQLException se) {
            }
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
