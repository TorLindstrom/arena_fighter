package se.lexicon.tor.graphics;

import se.lexicon.tor.Player;

import javax.swing.*;
import java.awt.*;

public class Shop extends JFrame {

    static int price = 3;

    JButton done = new JButton("Done");

    public Shop(MainWindow mw, Player player){

        add(done);
        done.setPreferredSize(new Dimension(120, 40));
        done.addActionListener(mw);

        setSize(new Dimension(600, 300));
        setAlwaysOnTop(true);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }
}
