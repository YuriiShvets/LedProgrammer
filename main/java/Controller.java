import view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by User on 23.11.2017.
 */
public class Controller {

    private Base base;
    private ArrayList<Led> leds;

    Controller() {
        base = new Base();
        leds = base.getLeds();

        MainFrame mainFrame = new MainFrame("Led Programmer");

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int delta = 80; //for OS borders
        LedListener ledListener = new LedListener(leds);
        GraphicsPanel graphicsPanel = new GraphicsPanel((int)screen.getHeight() - delta, (int)screen.getHeight() - delta, leds, ledListener);
        mainFrame.add(graphicsPanel, BorderLayout.WEST);

        JButton addLedButton = new JButton("Add");
        JButton saveLedButton = new JButton("Save");
        ControllPanel controllPanel = new ControllPanel(addLedButton, saveLedButton);
        mainFrame.add(controllPanel, BorderLayout.EAST);

        mainFrame.pack();
        mainFrame.setVisible(true);

        addLedButton.addActionListener(new ActionListener() {                                   //������ ������� ��� ������ �� ��������� ��������� �����
            public void actionPerformed(ActionEvent e) {
                addLed();
            }
        });

        saveLedButton.addActionListener(new ActionListener() {                                   //������ ������� ��� ������ �� ��������� ��������� �����
            public void actionPerformed(ActionEvent e) {
                saveLeds();
            }
        });
    }

    private void addLed() {
        leds.add(new Led(leds.size(), Led.getRadius(), Led.getRadius(), Led.getRadius(), 0, 0, 0));
    }

    private void saveLeds() {
        base.setLeds(leds);
    }
}
