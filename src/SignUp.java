import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp implements ActionListener  {

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
    JTextField passwordfield = new JTextField();

    JLabel confirmpassword = new JLabel("Confirm Password: ");
    JTextField confirmpasswordfield = new JTextField();

    JFrame frame = new JFrame();
    JButton resetButton = new JButton("Reset");
    JButton submitButton = new JButton("Submit");

        SignUp(){

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
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500,600);
            frame.setLayout(null);
            frame.setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
