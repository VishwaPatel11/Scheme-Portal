import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

public class AmrutamForm implements ActionListener {
    JFrame frame = new JFrame();
    JButton button = new JButton("Submit");
    JButton resetButton = new JButton("Reset");
    JButton cancelbtn = new JButton("Cancel"); // To cancel the ongoing proccess for Card Printing.
    JLabel title = new JLabel("Welcome to Amrutam-card Page");
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
    JTextField incomefield = new JTextField();
    String first, middle, last, gender_, income_, phone_, bday_;
   public void formAmrutam()
   {

       button.setBounds(300, 400, 100, 25);
       button.setFocusable(false);
       button.addActionListener(this);


       resetButton.setBounds(75, 400, 100, 25);
       resetButton.setFocusable(false);
       resetButton.addActionListener(this);


//       cancelbtn.setbounds()


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


       frame.add(resetButton);
       frame.add(button);
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
    JFrame frame_ = new JFrame();
    JLabel label = new JLabel("Do you want to print your card");
    JButton _button = new JButton("Print");



    @Override
    public void actionPerformed(ActionEvent e) {
        File Amrutam_Card_Printing = new File("Amrutam-Card.txt");

        if(e.getSource() == button)
        {
            first = firstnamefield.getText();
            middle = middlenamefield.getText();
            last = lastnamefield.getText();
            gender_ = genderfield.getText();
            phone_ = phonefield.getText();
            income_ = incomefield.getText();
            bday_ = bdayfield.getText();

         // after submitting, The Frame will get closed ( No Need ).
            frame.dispose();

            label.setBounds(110, 0, 300, 25);
            label.setFont((new Font("Arial",Font.PLAIN, 20)));

            _button.setBounds(200, 400, 100, 25);
            _button.setFocusable(false);
            _button.addActionListener(this);



            frame_.add(label);
            frame_.add(_button);
            frame_.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame_.setSize(500, 500);
            frame_.setLayout(null);
            frame_.setVisible(true);
        }
        if(e.getSource() == _button)
        {
            frame_.dispose();
            try
            {
                FileWriter type = new FileWriter(Amrutam_Card_Printing);
                Amrutam_Card_Printing.createNewFile();

                type.write("\n\t__________________________________________________________");
                type.write("\n\t                         Amrutam-Card                            ");
                type.write("\n\t----------------------------------------------------------");
                type.write("\n\t            Name --> " + first +  " " + middle + " " + last + "                                  ");
                type.write("\n\t            Gender --> " + gender_  + "                                        ");
                type.write("\n\t            BirthDate --> " + bday_+ "                              ");
                type.write("\n\t            Phone Number --> " + phone_ + "                                ");
                type.write("\n\t___________________________________________________________\n\n");

                Desktop hello = Desktop.getDesktop();
                if(Amrutam_Card_Printing.exists())
                {
                    hello.open(Amrutam_Card_Printing);
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
}
