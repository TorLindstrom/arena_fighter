package se.lexicon.tor.graphics;

import se.lexicon.tor.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelUp extends JFrame implements ActionListener {

    Player player;

    int speedPoints;
    int strengthPoints;
    int precisionPoints;
    int points;

    JLabel title = new JLabel("<===|=() Level up! ()=|===>");
    JPanel statPanel = new JPanel(new FlowLayout());
    JLabel strength = new JLabel("Strength:");
    JLabel speed = new JLabel("Speed:");
    JLabel precision = new JLabel("Precision:");
    JLabel strengthStat = new JLabel();
    JLabel speedStat = new JLabel();
    JLabel precisionStat = new JLabel();
    JLabel available = new JLabel("Available points:");
    JButton done = new JButton("Done");
    JButton plus1 = new JButton("+");
    JButton plus2 = new JButton("+");
    JButton plus3 = new JButton("+");
    JButton minus1 = new JButton("-");
    JButton minus2 = new JButton("-");
    JButton minus3 = new JButton("-");

    public LevelUp(Player player1, int round) {

        player = player1;

        strengthPoints = player.getStrength();
        speedPoints = player.getSpeed();
        precisionPoints = player.getPrecision();

        add(title);
        title.setFont(new Font("sansSerif", Font.BOLD, 30));
        title.setPreferredSize(new Dimension(600, 300));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        add(statPanel);
        statPanel.add(strength);
        strength.setPreferredSize(new Dimension(200, 40));
        statPanel.add(strengthStat);
        strengthStat.setText(String.valueOf(strengthPoints));
        statPanel.add(plus1);
        statPanel.add(minus1);
        statPanel.add(speed);
        statPanel.add(speedStat);
        speed.setPreferredSize(new Dimension(200, 40));
        speedStat.setText(String.valueOf(speedPoints));
        statPanel.add(plus2);
        statPanel.add(minus2);
        statPanel.add(precision);
        statPanel.add(precisionStat);
        precision.setPreferredSize(new Dimension(200, 40));
        precisionStat.setText(String.valueOf(precisionPoints));
        statPanel.add(plus3);
        statPanel.add(minus3);

        plus1.addActionListener(this);
        plus2.addActionListener(this);
        plus3.addActionListener(this);
        minus1.addActionListener(this);
        minus2.addActionListener(this);
        minus3.addActionListener(this);

        add(available);
        points = (int) (round * 1.2);
        available.setText("Available points: " + points);
        available.setPreferredSize(new Dimension(600, 60));
        available.setFont(new Font("sansSerif", Font.BOLD, 20));

        add(done);
        done.addActionListener(this);
        done.setEnabled(false);
        done.setPreferredSize(new Dimension(100, 30));

        setSize(new Dimension(600, 800));
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == done) {
            player.setStrength(strengthPoints);
            player.setSpeed(speedPoints);
            player.setPrecision(precisionPoints);
        } else if (e.getSource() == plus1) {
            strengthPoints++;
            points--;
        } else if (e.getSource() == minus1) {
            strengthPoints--;
            points++;
        } else if (e.getSource()==plus2){
            speedPoints++;
            points--;
        }

        if (points<=0){
            plus1.setEnabled(false);
            plus2.setEnabled(false);
            plus3.setEnabled(false);
        } else {
            minus1.setEnabled(false);
            minus2.setEnabled(false);
            minus3.setEnabled(false);
        }
    }
}

