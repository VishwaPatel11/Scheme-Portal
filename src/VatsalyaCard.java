import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VatsalyaCard implements ActionListener {
    JFrame frame = new JFrame();
    JButton info = new JButton("information");
    JButton apply = new JButton("Apply");

    JButton scheme = new JButton("Scheme");

    public void vatsalya()
    {
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
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent beta) {
        // actions for another page, information, submit, scheme
        if(beta.getSource() == scheme)
        {

        }
        if(beta.getSource() == info)
        {

        }

        if(beta.getSource() == apply)
        {
            // fill details.....
            frame.dispose();
            VatsalyaForm form = new VatsalyaForm();
            form.vatsalyaAction();
        }
    }
}
