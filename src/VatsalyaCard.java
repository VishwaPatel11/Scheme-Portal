import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class VatsalyaCard implements ActionListener {
    JFrame frame = new JFrame();
    JButton info = new JButton("information");
    JButton apply = new JButton("Apply");

    JButton scheme = new JButton("Scheme");
    JButton pdfButton = new JButton("Document");


    public void vatsalya()
    {
        apply.setBounds(150, 120, 100, 50);
        apply.setFocusable(false);
        apply.addActionListener(this);


        pdfButton.setBounds(340, 300, 100, 25);
        pdfButton.setFocusable(false);
        pdfButton.addActionListener(this);


        info.setBounds(150, 170, 100, 50);
        info.setFocusable(false);
        info.addActionListener(this);

        scheme.setBounds(150, 220, 100, 50);
        scheme.setFocusable(false);
        scheme.addActionListener(this);

        frame.add(scheme);
        frame.add(apply);
        frame.add(info);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent beta) {
        // actions for another page, information, submit, scheme
        if(beta.getSource() == scheme)
        {
            JFrame frame = new JFrame();

            JLabel title = new JLabel("Vatsalya-Card Scheme");
            title.setBounds(255, 5, 500, 40);
            title.setFont(new Font(null, Font.ITALIC, 25));


            JLabel line1 = new JLabel("1. Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores, in iure dolorem ex eligendi cumque.");
            JLabel line2 = new JLabel("2. Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores, in iure dolorem ex eligendi cumque.");
            JLabel line3 = new JLabel("3. Lorem ipsum dolor sit, amet consectetur adipisicing elit. Est nulla tenetur earum delectus recusandae ");
            JLabel line4 = new JLabel("4. Lorem ipsum dolor sit, amet consectetur adipisicing elit. Est nulla tenetur earum delectus recusandae iras");
            JLabel line5 = new JLabel("5. Under the Amrutam Card Scheme, eligible individuals are provided with a health insurance cover of up to ");
            JLabel line6 = new JLabel("Rs. 2 lakh per year for critical illnesses such as cancer, heart disease, kidney disease, and neurological.");

            line1.setBounds(5, 55, 750, 15);
            line1.setFont(new Font(null, Font.ITALIC, 15));

            line2.setBounds(5, 75, 750, 15);
            line2.setFont(new Font(null, Font.ITALIC, 15));

            line3.setBounds(5, 95, 750, 15);
            line3.setFont(new Font(null, Font.ITALIC, 15));

            line4.setBounds(5, 115, 750, 15);
            line4.setFont(new Font(null, Font.ITALIC, 15));

            line5.setBounds(5, 135, 750, 15);
            line5.setFont(new Font(null, Font.ITALIC, 15));

            line6.setBounds(5, 155, 750, 15);
            line6.setFont(new Font(null, Font.ITALIC, 15));


            frame.add(title);
            frame.add(line1);
            frame.add(line2);
            frame.add(line3);
            frame.add(line4);
            frame.add(line5);
            frame.add(line6);
            frame.setSize(770, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        }
        if(beta.getSource() == info)
        {
            JFrame frame = new JFrame();
            JLabel title = new JLabel("Vatsalya-Card Details");
            title.setBounds(255, 5, 500, 40);
            title.setFont(new Font(null, Font.ITALIC, 25));
            JLabel line1 = new JLabel("1. Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores, in iure dolorem ex eligendi cumque.");
            JLabel line2 = new JLabel("2. Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores, in iure dolorem ex eligendi cumque.");
            JLabel line3 = new JLabel("3. Lorem ipsum dolor sit, amet consectetur adipisicing elit. Est nulla tenetur earum delectus recusandae ");
            JLabel line4 = new JLabel("4. Lorem ipsum dolor sit, amet consectetur adipisicing elit. Est nulla tenetur earum delectus recusandae iras");

            line1.setBounds(5, 55, 750, 15);
            line1.setFont(new Font(null, Font.ITALIC, 15));

            line2.setBounds(5, 75, 750, 15);
            line2.setFont(new Font(null, Font.ITALIC, 15));

            line3.setBounds(5, 95, 750, 15);
            line3.setFont(new Font(null, Font.ITALIC, 15));

            pdfButton.setBounds(340, 300, 100, 25);
            pdfButton.setFocusable(false);
            pdfButton.addActionListener(this);

            frame.add(pdfButton);
            frame.add(title);
            frame.add(line3);
            frame.add(line2);
            frame.add(line1);
            frame.add(line4);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(770, 400);
            frame.setLayout(null);
            frame.setVisible(true);

        }

        if(beta.getSource() == apply)
        {
            // fill details.....
            frame.dispose();
            VatsalyaForm form = new VatsalyaForm();
            form.vatsalyaAction();
        }
        if(beta.getSource() == pdfButton){

            String filePath = "src/docs.pdf";

            // Create a File object for the PDF file
            File file = new File(filePath);

            Desktop hello = Desktop.getDesktop();
            if(file.exists()){
                try {
                    hello.open(file);
                } catch (IOException e) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Document Error!!");
                }
            }
            else
            {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Document Error!!");
            }
        }
    }

}
