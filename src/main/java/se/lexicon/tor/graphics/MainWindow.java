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

    int round = 0;
    boolean playing = false;
    Player player;
    Player opponent;
    boolean isFight = false;

    int yourHp;
    int theirHp;

    JPanel left = new JPanel();
    JPanel right = new JPanel();
    JLabel nameTitle = new JLabel();
    JLabel dieRoll =new JLabel();
    JTextArea filler = new JTextArea();
    JButton rollDice = new JButton("Roll the dice!");
    JButton continueButton = new JButton("Continue");
    RightStats rightPane1;

    Shop shop;

    public MainWindow(Player player) {

        this.player = player;

        rightPane1 = new RightStats(this, this.player);

        setLayout(new FlowLayout());
        setSize(new Dimension(1200, 600));
        left.setLayout(new FlowLayout());
        left.setPreferredSize(new Dimension(850, 600));
        add(left);
        add(rightPane1);
        left.setBorder(new EtchedBorder());
        right.setBorder(new EtchedBorder());
        left.add(nameTitle);
        nameTitle.setText("\t<===| " + this.player.getName() + " |===>\t");
        nameTitle.setFont(new Font("sansSerif", Font.PLAIN, 30));
        nameTitle.setPreferredSize(new Dimension(500, 50));
        nameTitle.setHorizontalAlignment(SwingConstants.CENTER);
        left.add(dieRoll);
        dieRoll.setPreferredSize(new Dimension(850, 70));
        dieRoll.setFont(new Font("sansSerif", Font.BOLD, 30));
        dieRoll.setHorizontalAlignment(SwingConstants.CENTER);
        left.add(filler);
        filler.setBorder(new EtchedBorder());
        filler.setPreferredSize(new Dimension(850, 280));
        filler.setBackground(Colours.sand);
        filler.setRows(7);
        filler.setFont(new Font("sansSerif", Font.ITALIC, 20));
        filler.setEditable(false);
        left.add(rollDice);
        rollDice.setPreferredSize(new Dimension(230, 40));
        rollDice.setHorizontalAlignment(SwingConstants.CENTER);
        left.add(continueButton);
        continueButton.setPreferredSize(new Dimension(120, 40));
        continueButton.setHorizontalAlignment(SwingConstants.CENTER);

        rollDice.addActionListener(this);
        continueButton.addActionListener(this);
        rollDice.setEnabled(false);

        setResizable(false);
        setVisible(true);
    }

    public void run(Player player) {
        filler.setText("Welcome " + player.getName() + ", I hope you'll get further than the last guy, hehe\n\nTo the right are stats, both yours and the opponent's\n\nBelow is the buttons, they are going to get well used");

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rollDice) {

            if (!playing) {
                yourHp = player.getHp();
                theirHp = opponent.getHp();
            }
            playing = true;
            int yourDie = Dice.rollDice();
            int theirDie = Dice.rollDice();
            String outcome;
            if (yourDie < theirDie) {
                yourHp -= opponent.getStrength();
                outcome = "you got hit...";
            } else if (yourDie > theirDie) {
                theirHp -= player.getStrength();
                outcome = "you hit them!";
            } else {
                outcome = "you both missed";
            }
            dieRoll.setText(yourDie + "  vs  " + theirDie);
            filler.setText("That means that " + outcome + "\n\nRemaining hp: " + yourHp + " Your opponent's remaining hp: " + theirHp);
            if (yourHp <= 0) {
                new DeathScreen(round);
            } else if (theirHp <= 0) {
                playing = false;
                continueButton.setEnabled(true);
                rollDice.setEnabled(false);
            }
        } else if (e.getSource() == continueButton) {
            if (isFight) {
                isFight = false;
            } else {
                round++;
                continueButton.setEnabled(false);
                rightPane1.shop.setEnabled(false);
                rollDice.setEnabled(true);
                opponent = new Player(round);
                filler.setText("It's fight time!\n\nYour opponent is: " + opponent.getName());
                isFight = true;
            }
        } else if (e.getSource() == rightPane1.shop) {
            shop = new Shop(this, player);
            this.setVisible(false);
        } else if (e.getSource() == shop.done) {
            shop.setVisible(false);
            this.setVisible(true);
        }
    }
}
