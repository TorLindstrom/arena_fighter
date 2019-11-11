package se.lexicon.tor;

import se.lexicon.tor.graphics.MainWindow;
import se.lexicon.tor.graphics.NameWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Coordinator implements ActionListener {

    Player player = new Player(1);

    NameWindow start;
    MainWindow main;

    public Coordinator(){

        start = new NameWindow(this);
    }

    public void actionPerformed(ActionEvent e){
            String name = start.nameInput.getText();
            start.setVisible(false);
            player.setName(name);
            main = new MainWindow(player);
            main.run(player);
    }
}
