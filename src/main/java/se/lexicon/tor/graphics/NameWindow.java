package se.lexicon.tor.graphics;

import se.lexicon.tor.Coordinator;
import se.lexicon.tor.graphics.Colours;

import javax.swing.*;
import java.awt.*;

public class NameWindow extends JFrame{
    public JLabel enterName = new JLabel("We'll start by giving your character a name");
    public JTextField nameInput = new JTextField();
    public JButton enter = new JButton("Done");

    public NameWindow(Coordinator coordinator){
        setLayout(new FlowLayout());
        add(enterName);
        enterName.setHorizontalAlignment(SwingConstants.CENTER);
        enterName.setPreferredSize(new Dimension(500, 80));
        enterName.setFont(new Font("SansSerif", Font.ITALIC+Font.BOLD, 15));
        add(nameInput);
        nameInput.setPreferredSize(new Dimension(200, 30));
        nameInput.setHorizontalAlignment(SwingConstants.CENTER);
        add(enter);
        nameInput.addActionListener(coordinator);
        enter.addActionListener(coordinator);
        getContentPane().setBackground(Colours.sand);


        setSize(new Dimension(500, 190));
        setResizable(false);
        setLocation(500, 300);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }

}
