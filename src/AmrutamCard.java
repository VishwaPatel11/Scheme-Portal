import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

public class AmrutamCard implements ActionListener {

    JFrame frame = new JFrame();
    JButton info = new JButton("information");
    JButton apply = new JButton("Apply");

    JButton scheme = new JButton("Scheme");

    public void amrutam() {
        apply.setBounds(150, 120, 100, 50);
        apply.setFocusable(false);
        apply.addActionListener(this);

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
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent beta) {
        // actions for another page, information, submit, scheme
        if (beta.getSource() == scheme) {
            frame.dispose();
            JFrame frame = new JFrame();
            JLabel label = new JLabel();



            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 400);
            frame.setLayout(null);
            frame.setVisible(true);
        }

        if (beta.getSource() == info) {
            frame.dispose();
            JFrame frame = new JFrame();
            JLabel title = new JLabel("Amrutam-Card Details");
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
            frame.add(title);
            frame.add(line3);
            frame.add(line2);
            frame.add(line1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(770, 400);
            frame.setLayout(null);
            frame.setVisible(true);
        }

        if (beta.getSource() == apply) {

            // fill details.
            frame.dispose();
            AmrutamForm form = new AmrutamForm();
            form.formAmrutam();
        }
    }
}