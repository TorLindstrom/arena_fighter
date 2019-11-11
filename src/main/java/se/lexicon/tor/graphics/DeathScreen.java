package se.lexicon.tor.graphics;

import javax.swing.*;
import java.awt.*;

public class DeathScreen extends JFrame{

    JLabel title = new JLabel("You died....");
    JLabel round = new JLabel();

    public DeathScreen(int roundNumber){
        setLayout(new FlowLayout());
        add(title);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setPreferredSize(new Dimension(300, 60));
        add(round);
        round.setText("Final round: " + roundNumber);
        round.setPreferredSize(new Dimension(300, 30));
        round.setHorizontalAlignment(SwingConstants.CENTER);
        setBackground(Colours.sand);

        setSize(new Dimension(350, 150));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
