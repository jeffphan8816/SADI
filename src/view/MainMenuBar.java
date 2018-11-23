package view;

import controller.ExitActionListener;
import controller.NewActionListener;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MainMenuBar extends JMenuBar {
    public MainMenuBar(MainAppFrame mainAppFrame) {

        JMenu fileMenu = new JMenu("File");

        fileMenu.setMnemonic(KeyEvent.VK_I);
        this.add(fileMenu);

        JMenuItem addPlayer = new JMenuItem("New", KeyEvent.VK_N);
        addPlayer.addActionListener(new NewActionListener(mainAppFrame));


        JMenuItem save = new JMenuItem("Save", KeyEvent.VK_S);
        save.addActionListener(new SaveActionListener(mainAppFrame));

        JMenuItem exitItem = new JMenuItem("Exit", KeyEvent.VK_X);
        exitItem.addActionListener(new ExitActionListener());
        exitItem.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.ALT_MASK));

        fileMenu.add(addPlayer);
        fileMenu.add(save);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
    }

}
