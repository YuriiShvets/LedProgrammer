import view.ControllPanel;
import view.GraphicsPanel;
import view.Led;
import view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Created by User on 23.11.2017.
 */
public class Controller {

    private LinkedList<Led> Leds;

    Controller() {
        MainFrame mainFrame = new MainFrame("Led Programmer");

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int delta = 80; //for OS borders
        GraphicsPanel graphicsPanel = new GraphicsPanel((int)screen.getHeight() - delta, (int)screen.getHeight() - delta);
        mainFrame.add(graphicsPanel, BorderLayout.WEST);

        JButton addLedButton = new JButton("Add");
        ControllPanel controllPanel = new ControllPanel(addLedButton);
        mainFrame.add(controllPanel, BorderLayout.EAST);

        mainFrame.pack();
        mainFrame.setVisible(true);

        addLedButton.addActionListener(new ActionListener() {                                   //������ ������� ��� ������ �� ��������� ��������� �����
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
