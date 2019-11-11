package se.lexicon.tor.graphics;

import se.lexicon.tor.App;
import se.lexicon.tor.Dice;
import se.lexicon.tor.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FightWindow extends JFrame implements ActionListener {

    Player enemy;
    Player player;
    int round = 0;
    int yourHp;
    int theirHp;
    int your;
    int their;

    JLabel title = new JLabel("Fight!");
    JLabel rolls = new JLabel();
    JProgressBar yourHealthBar = new JProgressBar();
    JProgressBar theirHealthBar = new JProgressBar();
    JLabel yourHealth = new JLabel();
    JLabel theirHealth = new JLabel();
    JButton roll = new JButton("Roll!");
    JButton quit = new JButton("Done");

    public FightWindow(Player player){
        enemy = new Player(round);
        addEverything(player);
    }

    public void addEverything(Player player1){

        player = player1;
        yourHp = player.getHp();
        theirHp = enemy.getHp();

        setLayout(new FlowLayout());

        add(title);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("sansSerif", Font.BOLD, 30));
        title.setPreferredSize(new Dimension(400, 100));

        add(rolls);
        rolls.setHorizontalAlignment(SwingConstants.CENTER);
        rolls.setFont(new Font("sansSerif", Font.BOLD, 30));
        rolls.setPreferredSize(new Dimension(400, 80));

        add(yourHealthBar);
        yourHealthBar.setMaximum(player.getHp());
        yourHealthBar.setPreferredSize(new Dimension(200, 30));
        yourHealthBar.setForeground(Colours.blood);

        add(yourHealth);
        yourHealth.setFont(new Font("sansSerif", Font.PLAIN, 15));
        yourHealth.setPreferredSize(new Dimension(200, 30));

        add(theirHealthBar);
        theirHealthBar.setMaximum(enemy.getHp());
        theirHealthBar.setPreferredSize(new Dimension(200, 30));
        theirHealthBar.setForeground(Colours.blood);

        add(theirHealth);
        theirHealth.setFont(new Font("sansSerif", Font.PLAIN, 15));
        theirHealth.setPreferredSize(new Dimension(200, 30));

        renderHealth();

        add(roll);
        roll.setPreferredSize(new Dimension(100, 30));
        roll.addActionListener(this);

        add(quit);
        quit.setEnabled(false);
        quit.setPreferredSize(new Dimension(70, 30));
        quit.addActionListener(this);

        getContentPane().setBackground(Colours.sand);

        setSize(new Dimension(500, 500));
        setVisible(true);
        setResizable(false);
    }

    public void renderHealth(){
        yourHealth.setText("Your health points: " + yourHp);
        theirHealth.setText("Their health points: " + theirHp);
        yourHealthBar.setValue(yourHp);
        theirHealthBar.setValue(theirHp);
    }
    public void renderRolls(){
        rolls.setText(your + "  vs  " + their);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()==roll){
            your = Dice.rollDice();
            their = Dice.rollDice();
            if (your<their){
                yourHp -= enemy.getStrength();
            } else if (your>their){
                theirHp -= player.getStrength();
            }
            renderRolls();
            renderHealth();
            if (yourHp<=0 || theirHp<=0){
                roll.setEnabled(false);
                quit.setEnabled(true);
            }
        } else if (e.getSource()==quit){
            round++;
            if (yourHp<=0){
                DeathScreen dead = new DeathScreen(round);
                setVisible(false);
            } else {
                App.levelUp = new LevelUp(player, round);
                setVisible(false);
            }
        }
    }

}
