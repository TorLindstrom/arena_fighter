package se.lexicon.tor.graphics;

import se.lexicon.tor.App;
import se.lexicon.tor.Player;
import se.lexicon.tor.graphics.Colours;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameWindow extends JFrame implements ActionListener {
    public JLabel enterName = new JLabel("We'll start by giving your character a name");
    public JTextField nameInput = new JTextField();
    public JButton enter = new JButton("Done");

    public NameWindow(){
        setLayout(new FlowLayout());
        addTitle();
        addInput();
        addEnter();
        setColors();

        setSize(new Dimension(500, 190));
        setResizable(false);
        setLocation(500, 300);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }

    public void addTitle(){
        add(enterName);
        enterName.setHorizontalAlignment(SwingConstants.CENTER);
        enterName.setPreferredSize(new Dimension(500, 80));
        enterName.setFont(new Font("SansSerif", Font.ITALIC+Font.BOLD, 15));
    }
    public void addInput(){
        add(nameInput);
        nameInput.setPreferredSize(new Dimension(200, 30));
        nameInput.setHorizontalAlignment(SwingConstants.CENTER);
    }
    public void addEnter(){
        add(enter);
        nameInput.addActionListener(this);
        enter.addActionListener(this);
    }
    public void setColors(){
        getContentPane().setBackground(Colours.sand);
    }

    public void actionPerformed(ActionEvent e){
        Player player = new Player();
        player.setName(nameInput.getText());
        App.main = new MainWindow(player);
        setVisible(false);
    }

}
