import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class VatsalyaForm implements ActionListener {
    String first, middle, last, gender_, phone_, bday_, email_, income_;
    JButton submitbtn = new JButton("Submit");
    JButton resetbtn = new JButton("Reset");
    JButton printbtn = new JButton("Print");
    JButton nextbtn = new JButton("Next");


    JFrame frame = new JFrame();
    JLabel title = new JLabel("Welcome to Vatsalya-card Page");

    JLabel firstname = new JLabel("First Name: ");
    JTextField firstnamefield = new JTextField();

    JLabel middlename = new JLabel("Middle Name: ");
    JTextField middlenamefield = new JTextField();

    JLabel lastname = new JLabel("Last Name: ");
    JTextField lastnamefield = new JTextField();

    JLabel phone = new JLabel("Phone-No: ");
    JTextField phonefield = new JTextField();

    JLabel gender = new JLabel("Gender: ");
    JTextField genderfield = new JTextField();

    JLabel bday = new JLabel("Birthday: ");
    JTextField bdayfield = new JTextField();

    JLabel email = new JLabel("E-mail: ");
    JTextField emailfield = new JTextField();

    JLabel income = new JLabel("Annual Income: ");

    JLabel aadhar = new JLabel("Aadhar-Card");
    JButton aadharButton = new JButton("Upload");

    JLabel photo = new JLabel("Photo");
    JButton photoButton = new JButton("Upload");

    JLabel incomeCertificate = new JLabel("Income-Certificate");
    JButton incomeCertificateButton = new JButton("Upload");

    JLabel waterIDCard = new JLabel("WaterID-Card");
    JButton waterIDCardButton = new JButton("Upload");

    JLabel panCard = new JLabel("PAN-Card");
    JButton panCardButton = new JButton("Upload");

    JLabel casteCertificate = new JLabel("Caste-Certificate");
    JButton casteCertificateButton = new JButton("Upload");
    JTextField incomefield = new JTextField();


    JButton button = new JButton("Next");
    JButton resetButton = new JButton("Reset");
    public void vatsalyaAction(){
        title.setBounds(110, 0, 300, 25);
        title.setFont((new Font("Arial", Font.PLAIN, 20)));


        firstname.setBounds(40,40,100,25);
        firstname.setFont(new Font("", 10, 15));
        firstnamefield.setBounds(160,40,200,25);


        middlename.setBounds(40, 85, 100, 25);
        middlename.setFont(new Font("", 10, 15));
        middlenamefield.setBounds(160, 85, 200, 25);


        lastname.setBounds(40, 130, 100, 25);
        lastname.setFont(new Font("", 10, 15));
        lastnamefield.setBounds(160, 130, 200, 25);


        phone.setBounds(40, 180, 100, 25);
        phone.setFont(new Font("", 10, 15));
        phonefield.setBounds(160, 180, 200, 25);


        gender.setBounds(40, 220, 100, 25);
        gender.setFont(new Font("", 10, 15));
        genderfield.setBounds(160, 220, 200, 25);


        bday.setBounds(40, 260, 100, 25);
        bday.setFont(new Font("", 10, 15));
        bdayfield.setBounds(160, 260, 200, 25);


        email.setBounds(40, 300, 100, 25);
        email.setFont(new Font("", 10, 15));
        emailfield.setBounds(160, 300, 200, 25);



        income.setBounds(40, 340, 150, 25);
        income.setFont(new Font("", 10, 15));
        incomefield.setBounds(160, 340, 200, 25);

        button.setBounds(300, 400, 100, 25);
        button.setFocusable(false);
        button.addActionListener(this);


        resetButton.setBounds(75, 400, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);


        frame.add(firstnamefield);
        frame.add(middlenamefield);
        frame.add(lastnamefield);
        frame.add(phonefield);
        frame.add(emailfield);
        frame.add(resetButton);
        frame.add(button);
        frame.add(title);
        frame.add(firstname);
        frame.add(middlename);
        frame.add(lastname);
        frame.add(phone);
        frame.add(genderfield);
        frame.add(bdayfield);
        frame.add(email);
        frame.add(incomefield);
        frame.add(gender);
        frame.add(bday);
        frame.add(income);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 550);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    JFrame frame_ = new JFrame();
    JLabel label = new JLabel("Do you want to print your card");
    JButton _button = new JButton("Print");

    @Override
    public void actionPerformed(ActionEvent e) {
        File vatsalya_Card_Printing = new File("vatsalya-Card.txt");

        if(e.getSource() == button) // Next Button, To Enter Into the another page to upload Details
        {
            first = firstnamefield.getText();
            middle = middlenamefield.getText();
            last = lastnamefield.getText();
            gender_ = genderfield.getText();
            phone_ = phonefield.getText();
            income_ = incomefield.getText();
            bday_ = bdayfield.getText();
            email_ = emailfield.getText();
            toInsertDataIntoDataBase();
            System.out.println(first + middle + last + gender_ + phone_ + income_ + bday_ + email_);
            frame.dispose();

            aadhar.setBounds(65, 40, 300, 25);
            aadhar.setFont((new Font("Arial", Font.PLAIN, 16)));
            aadharButton.setBounds(365, 40, 80, 20);
            aadharButton.setFocusable(false);
            aadharButton.addActionListener(this);

            photo.setBounds(65, 100, 300, 25);
            photo.setFont((new Font("Arial", Font.PLAIN, 16)));
            photoButton.setBounds(365, 100, 80, 20);
            photoButton.setFocusable(false);
            photoButton.addActionListener(this);

            incomeCertificate.setBounds(65, 160, 300, 25);
            incomeCertificate.setFont((new Font("Arial", Font.PLAIN, 16)));
            incomeCertificateButton.setBounds(365, 160, 80, 20);
            incomeCertificateButton.setFocusable(false);
            incomeCertificateButton.addActionListener(this);

            waterIDCard.setBounds(65, 220, 300, 25);
            waterIDCard.setFont((new Font("Arial", Font.PLAIN, 16)));
            waterIDCardButton.setBounds(365, 220, 80, 20);
            waterIDCardButton.setFocusable(false);
            waterIDCardButton.addActionListener(this);

            panCard.setBounds(65, 280, 300, 25);
            panCard.setFont((new Font("Arial", Font.PLAIN, 16)));
            panCardButton.setBounds(365, 280, 80, 20);
            panCardButton.setFocusable(false);
            panCardButton.addActionListener(this);

            casteCertificate.setBounds(65, 340, 300, 25);
            casteCertificate.setFont((new Font("Arial", Font.PLAIN, 16)));
            casteCertificateButton.setBounds(365, 340, 80, 20);
            casteCertificateButton.setFocusable(false);
            casteCertificateButton.addActionListener(this);


            printbtn.setBounds(200, 400, 100, 25);
            printbtn.setFocusable(false);
            printbtn.addActionListener(this);


            frame_.add(aadharButton);
            frame_.add(aadhar);
            frame_.add(panCardButton);
            frame_.add(panCard);
            frame_.add(casteCertificate);
            frame_.add(casteCertificateButton);
            frame_.add(incomeCertificate);
            frame_.add(incomeCertificateButton);
            frame_.add(photo);
            frame_.add(photoButton);
            frame_.add(waterIDCard);
            frame_.add(waterIDCardButton);
            frame_.add(printbtn);
            frame_.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame_.setSize(500, 500);
            frame_.setLayout(null);
            frame_.setVisible(true);
        }


        if(e.getSource() == printbtn)
        {
            frame_.dispose();
            try
            {
                FileWriter type = new FileWriter(vatsalya_Card_Printing);
                vatsalya_Card_Printing.createNewFile();

                type.write("\n\t__________________________________________________________");
                type.write("\n\t                         Amrutam-Card                            ");
                type.write("\n\t----------------------------------------------------------");
                type.write("\n\t            Name --> " + first +  " " + middle + " " + last + "                                  ");
                type.write("\n\t            Gender --> " + gender_  + "                                        ");
                type.write("\n\t            BirthDate --> " + bday_+ "                              ");
                type.write("\n\t            Phone Number --> " + phone_ + "                                ");
                type.write("\n\t___________________________________________________________\n\n");

                Desktop hello = Desktop.getDesktop();
                if(vatsalya_Card_Printing.exists())
                {
                    hello.open(vatsalya_Card_Printing);
                }
                else
                {
                    throw new Exception("File not Found");
                }

            }
            catch (Exception evo)
            {
                System.out.println(evo);
            }
        }


        if(e.getSource() == resetButton)
        {
            firstnamefield.setText("");
            middlenamefield.setText("");
            lastnamefield.setText("");
            genderfield.setText("");
            incomefield.setText("");
            phonefield.setText("");
            bdayfield.setText("");
        }
    }
    public void formAmrutam(){
        submitbtn.setBounds(300, 400, 100, 25);
        submitbtn.setFocusable(false);
        submitbtn.addActionListener(this);


        resetbtn.setBounds(75, 420, 100, 25);
        resetbtn.setFocusable(false);
        resetbtn.addActionListener(this);


        nextbtn.setBounds(300, 420, 100, 25);
        nextbtn.setFocusable(false);
        nextbtn.addActionListener(this);



        title.setBounds(110, 0, 300, 25);
        title.setFont((new Font("Arial",Font.PLAIN, 20)));


        firstname.setBounds(40, 40, 100, 25);
        firstname.setFont(new Font("", 10, 15));
        firstnamefield.setBounds(160, 40, 200, 25);


        middlename.setBounds(40, 85, 100, 25);
        middlename.setFont(new Font("", 10, 15));
        middlenamefield.setBounds(160, 85, 200, 25);


        lastname.setBounds(40, 130, 100, 25);
        lastname.setFont(new Font("", 10, 15));
        lastnamefield.setBounds(160, 130, 200, 25);


        phone.setBounds(40, 180, 100, 25);
        phone.setFont(new Font("", 10, 15));
        phonefield.setBounds(160, 180, 200, 25);


        gender.setBounds(40, 220, 100, 25);
        gender.setFont(new Font("", 10, 15));
        genderfield.setBounds(160, 220, 200, 25);


        bday.setBounds(40, 260, 100, 25);
        bday.setFont(new Font("", 10, 15));
        bdayfield.setBounds(160, 260, 200, 25);


        email.setBounds(40, 300, 100, 25);
        email.setFont(new Font("", 10, 15));
        emailfield.setBounds(160, 300, 200, 25);


        income.setBounds(40, 340, 150, 25);
        income.setFont(new Font("", 10, 15));
        incomefield.setBounds(160, 340, 200, 25);


        frame.add(resetbtn);
        frame.add(nextbtn);
        frame.add(firstnamefield);
        frame.add(middlenamefield);
        frame.add(lastnamefield);
        frame.add(phonefield);
        frame.add(emailfield);
        frame.add(title);
        frame.add(firstname);
        frame.add(middlename);
        frame.add(lastname);
        frame.add(phone);
        frame.add(genderfield);
        frame.add(bdayfield);
        frame.add(email);
        frame.add(incomefield);
        frame.add(gender);
        frame.add(bday);
        frame.add(income);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 550);
        frame.setLayout(null);
        frame.setVisible(true);
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

//            String sql = "insert into details(FirstName, MiddleName, LastName, PhoneNumber, UserName, Passwords) values(" + value + firstname__ + value+ ", " + value + middlename__ + value + ", " + value + lastname__ + value + ", " + value + phonenumber__ + value + ", " + value + username__ + value + ", " + value + password__ + value + ")";
            String sql = "insert into secondTable_(FirstName, MiddleName ,LastName,PhoneNumber ,Gender, BirthDate,  E_mail, Income ) values(" +  value + first + value + ", " + value + middle + value + ", " + value + last + value + ", " + value + phone_ + value + ", " + value + gender_ + value + ", " + value + bday_ + value + ", " + value + email_ + value + ", " + value + income_ + value + ")";
            stmt.executeUpdate(sql);

            System.out.println("Values inserted into table successfully!");
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