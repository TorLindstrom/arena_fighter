package se.lexicon.tor.graphics;

import se.lexicon.tor.Dice;
import se.lexicon.tor.Player;
import se.lexicon.tor.graphics.Colours;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {

    Player player;

    JLabel nameTitle = new JLabel();
    JTextArea filler = new JTextArea();
    JButton fight = new JButton("Fight");
    JButton continueButton = new JButton("Continue");

    Shop shop;

    public MainWindow(Player player) {

        this.player = player;

        setLayout(new FlowLayout());
        setSize(new Dimension(900, 500));

        add(nameTitle);
        nameTitle.setText("\t<===| " + this.player.getName() + " |===>\t");
        nameTitle.setFont(new Font("sansSerif", Font.PLAIN, 30));
        nameTitle.setPreferredSize(new Dimension(900, 50));
        nameTitle.setHorizontalAlignment(SwingConstants.CENTER);

        add(filler);
        filler.setBorder(new EtchedBorder());
        filler.setPreferredSize(new Dimension(900, 280));
        filler.setBackground(Colours.sand);
        filler.setRows(7);
        filler.setFont(new Font("sansSerif", Font.ITALIC, 20));
        filler.setEditable(false);

        add(continueButton);
        continueButton.setPreferredSize(new Dimension(120, 40));
        continueButton.setHorizontalAlignment(SwingConstants.CENTER);
        continueButton.addActionListener(this);

        add(fight);
        fight.setPreferredSize(new Dimension(90, 40));
        fight.setHorizontalAlignment(SwingConstants.CENTER);
        fight.addActionListener(this);

        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==fight){
            FightWindow fightWindow = new FightWindow(player);
            setVisible(false);
        }
    }
}
