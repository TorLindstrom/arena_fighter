package se.lexicon.tor;

import se.lexicon.tor.graphics.MainWindow;
import se.lexicon.tor.graphics.NameWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Coordinator implements ActionListener {

    Player player = new Player(1);

    NameWindow askName;
    MainWindow main;

    public Coordinator(){
    }

    public void actionPerformed(ActionEvent e){

    }

    public void useName(){
        String name = askName.nameInput.getText();
        askName.setVisible(false);
        player.setName(name);
    }

}
