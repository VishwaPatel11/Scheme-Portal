import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardSelectionPage implements ActionListener {
    JFrame frame = new JFrame();
    JLabel content = new JLabel("Select a Card");
    JButton acard = new JButton("Amrtam-card");
    JButton vcard = new JButton("Vatsalya-card");

    public void selectcard()
    {
        acard.setBounds(25, 250, 150, 50);
        acard.setFocusable(false);
        acard.addActionListener(this);

        vcard.setBounds(225, 250, 150, 50);
        vcard.setFocusable(false);
        vcard.addActionListener(this);

        content.setBounds(100, 10, 400, 50);
        content.setFont(new Font("", 10, 35));


        frame.add(content);
        frame.add(acard);
        frame.add(vcard);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent alpha) {
        if(alpha.getSource() == acard)
        {
            // total logic of Amrutam card
            frame.dispose();
            AmrutamCard amrutamCard = new AmrutamCard();
            amrutamCard.amrutam();
        }

        if(alpha.getSource() == vcard)
        {
            // total logic of vatsalya card
            frame.dispose();
            VatsalyaCard vatsalyaCard = new VatsalyaCard();
            vatsalyaCard.vatsalya();
        }
    }
}
