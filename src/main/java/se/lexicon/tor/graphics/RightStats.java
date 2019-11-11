package se.lexicon.tor.graphics;

import se.lexicon.tor.Player;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class RightStats extends JComponent{

    JLabel rightTitle = new JLabel("--- Stats ---");
    JLabel strength = new JLabel();
    JLabel speed = new JLabel();
    JLabel precision = new JLabel();
    JLabel hp = new JLabel();
    JLabel money = new JLabel();
    JLabel levelEquipment = new JLabel("--- Equipment ---");
    JPanel equipment = new JPanel();
    JButton shop = new JButton("Shop");

    JLabel oneone = new JLabel("Armor");
    JLabel onetwo = new JLabel("Weapon");
    JLabel onethree = new JLabel("Shield");
    JLabel twoone = new JLabel();
    JLabel twotwo = new JLabel();
    JLabel twothree = new JLabel();


    public RightStats(MainWindow mw, Player player){
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(300, 600));
        add(rightTitle);
        rightTitle.setFont(new Font("SansSerif", Font.BOLD, 15));
        rightTitle.setPreferredSize(new Dimension(300, 100));
        rightTitle.setBorder(new EtchedBorder());
        rightTitle.setHorizontalAlignment(SwingConstants.CENTER);
        add(strength);
        strength.setPreferredSize(new Dimension(260, 40));
        strength.setText(makeText("Strength", player.getStrength()));
        add(speed);
        speed.setPreferredSize(new Dimension(260, 40));
        speed.setText(" --- Speed:\t" + player.getSpeed() + " --- ");
        add(precision);
        precision.setPreferredSize(new Dimension(260, 40));
        precision.setText(" --- Precision:\t" + player.getPrecision() + " --- ");
        add(hp);
        hp.setPreferredSize(new Dimension(260, 40));
        hp.setText(" --- HP:\t\t" + player.getHp() + " --- ");
        add(money);
        money.setPreferredSize(new Dimension(260, 40));
        money.setText(" --- Money:\t" + player.getMoney() + " --- ");
        add(levelEquipment);
        levelEquipment.setHorizontalAlignment(SwingConstants.CENTER);
        levelEquipment.setBorder(new EtchedBorder());
        levelEquipment.setFont(new Font("SansSerif", Font.BOLD, 15));
        levelEquipment.setPreferredSize(new Dimension(300, 50));
        add(equipment);
        equipment.setPreferredSize(new Dimension(300, 100));
        equipment.setLayout(new GridLayout(2, 3));
        equipment.add(oneone);
        oneone.setHorizontalAlignment(SwingConstants.CENTER);
        equipment.add(onetwo);
        onetwo.setHorizontalAlignment(SwingConstants.CENTER);
        equipment.add(onethree);
        onethree.setHorizontalAlignment(SwingConstants.CENTER);
        equipment.add(twoone);
        twoone.setText("-" + player.getArmor() + " - ");
        twoone.setHorizontalAlignment(SwingConstants.CENTER);
        equipment.add(twotwo);
        twotwo.setText("-" + player.getWeapon() + " - ");
        twotwo.setHorizontalAlignment(SwingConstants.CENTER);
        equipment.add(twothree);
        twothree.setText("-" + player.getShield() + " - ");
        twothree.setHorizontalAlignment(SwingConstants.CENTER);
        add(shop);
        shop.setPreferredSize(new Dimension(120, 40));


        shop.addActionListener(mw);

    }

    public String makeText(String statName, int stat){
        String text = " --- " + statName + ":\t" + stat + " --- ";
        return text;
    }

}
