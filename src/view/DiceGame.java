package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import org.jdesktop.observablecollections.*;



/**
 * @author unknown
 */
public class DiceGame extends JFrame {
    public DiceGame() {
        initComponents();
    }



    private void addPlayerActionPerformed(ActionEvent e) {

    }

    private void removePlayerActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void placeBetActionPerformed(ActionEvent e) {
        int betpoints = Integer.parseInt(betPoints.getText());
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jeff Phan
        statusBar = new JTextField();
        panel1 = new JPanel();
        splitPane1 = new JSplitPane();
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        addPlayer = new JMenuItem();
        removePlayer = new JMenuItem();
        toolBar1 = new JToolBar();
        label1 = new JLabel();
        betPoints = new JTextField();
        placeBet = new JButton();
        hSpacer18 = new JPanel(null);
        button1 = new JButton();
        playerListScroll = new JScrollPane();
        playerList = new JList();
        panel3 = new JPanel();
        panel2 = new JPanel();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(statusBar, BorderLayout.SOUTH);

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new BorderLayout());

            //======== splitPane1 ========
            {
                splitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);

                //======== menuBar1 ========
                {

                    //======== menu1 ========
                    {
                        menu1.setText("Game");

                        //---- addPlayer ----
                        addPlayer.setText("Add player");
                        addPlayer.addActionListener(e -> addPlayerActionPerformed(e));
                        menu1.add(addPlayer);

                        //---- removePlayer ----
                        removePlayer.setText("Remove player");
                        removePlayer.addActionListener(e -> removePlayerActionPerformed(e));
                        menu1.add(removePlayer);
                    }
                    menuBar1.add(menu1);
                }
                splitPane1.setTopComponent(menuBar1);

                //======== toolBar1 ========
                {

                    //---- label1 ----
                    label1.setText("Input bet points      ");
                    toolBar1.add(label1);

                    //---- betPoints ----
                    betPoints.setHorizontalAlignment(SwingConstants.CENTER);
                    toolBar1.add(betPoints);

                    //---- placeBet ----
                    placeBet.setText("Place bet");
                    placeBet.addActionListener(e -> placeBetActionPerformed(e));
                    toolBar1.add(placeBet);
                    toolBar1.add(hSpacer18);

                    //---- button1 ----
                    button1.setText("Roll Dice");
                    toolBar1.add(button1);
                }
                splitPane1.setBottomComponent(toolBar1);
            }
            panel1.add(splitPane1, BorderLayout.CENTER);
        }
        contentPane.add(panel1, BorderLayout.NORTH);

        //======== playerListScroll ========
        {
            playerListScroll.setViewportView(playerList);
        }
        contentPane.add(playerListScroll, BorderLayout.EAST);

        //======== panel3 ========
        {
            panel3.setLayout(new BorderLayout());

            //======== panel2 ========
            {
                panel2.setLayout(new GridLayout(1, 4));

                //---- label2 ----
                label2.setText("Player ID:");
                panel2.add(label2);
                panel2.add(textField2);

                //---- label3 ----
                label3.setText("Current Points:");
                panel2.add(label3);
                panel2.add(textField3);
            }
            panel3.add(panel2, BorderLayout.SOUTH);
        }
        contentPane.add(panel3, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jeff Phan
    private JTextField statusBar;
    private JPanel panel1;
    private JSplitPane splitPane1;
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem addPlayer;
    private JMenuItem removePlayer;
    private JToolBar toolBar1;
    private JLabel label1;
    private JTextField betPoints;
    private JButton placeBet;
    private JPanel hSpacer18;
    private JButton button1;
    private JScrollPane playerListScroll;
    private JList playerList;
    private JPanel panel3;
    private JPanel panel2;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
