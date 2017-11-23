package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * Created by User on 23.11.2017.
 */
public class LedListener implements MouseListener, MouseMotionListener {

    private int selectedLed = -1;
    private ArrayList<Led> leds;

    public LedListener(ArrayList<Led> leds) {
        this.leds = leds;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (selectedLed == -1 || !leds.get(selectedLed).inArea(e.getX(), e.getY())) {
            for (Led led : leds) {
                led.setSelected(false);
            }
            for (Led led : leds) {
                if (led.inArea(e.getX(), e.getY())) {
                    led.setSelected(true);
                    selectedLed = led.getId();
                    break;
                }
                selectedLed = -1;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (selectedLed == -1 || !leds.get(selectedLed).inArea(e.getX(), e.getY())) {
            for (Led led : leds) {
                led.setSelected(false);
            }
            for (Led led : leds) {
                if (led.inArea(e.getX(), e.getY())) {
                    led.setSelected(true);
                    selectedLed = led.getId();
                    break;
                }
                selectedLed = -1;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        if (selectedLed != -1) {
            leds.get(selectedLed).setCoordinates(e.getX(), e.getY());

        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
//        for(Led led: leds) {
//            if(led.isSelected()) {
//                led.setCoordinates(e.getX(), e.getY());
//            }
//        }
    }
}
