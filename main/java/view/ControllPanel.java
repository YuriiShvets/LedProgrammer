package view;

import javax.swing.*;

/**
 * Created by User on 23.11.2017.
 */
public class ControllPanel extends JPanel {

    public ControllPanel(JButton addLedButton, JButton saveLedButton) {
        Box verticalBox = Box.createVerticalBox();
        add(verticalBox);
        verticalBox.add(addLedButton);
        verticalBox.add(saveLedButton);
    }
}
