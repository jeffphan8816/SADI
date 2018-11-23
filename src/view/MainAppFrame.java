package view;

import javax.swing.*;
import model.interfaces.*;

public class MainAppFrame extends JFrame {
    private GameEngine newGE;

    public MainAppFrame() {
        setBounds(250, 250, 640, 480);
        setJMenuBar(new MainMenuBar(this));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
