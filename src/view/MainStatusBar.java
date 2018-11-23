package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class MainStatusBar extends JPanel {
    public MainStatusBar(MainAppFrame mainAppFrame) {

        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusBar.setBorder(new CompoundBorder(new LineBorder(Color.DARK_GRAY),
                new EmptyBorder(4, 4, 4, 4)));
        final JLabel status = new JLabel();
        statusBar.add(status);
    }
}

