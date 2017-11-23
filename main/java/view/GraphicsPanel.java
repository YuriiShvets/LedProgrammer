package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by User on 23.11.2017.
 */
public class GraphicsPanel extends JPanel implements Runnable{

    private int width;
    private int height;
    private Graphics2D graphics2D;
    private BufferedImage bufferedImage;
    private Thread thread;
    private ArrayList<Led> leds;

    public GraphicsPanel(int width, int height, ArrayList<Led> leds, LedListener ledListener) {
        this.width = width;
        this.height = height;
        this.leds = leds;
        addMouseListener(ledListener);
        addMouseMotionListener(ledListener);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(width, height));
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        graphics2D = (Graphics2D)bufferedImage.getGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        thread = new Thread(this, "GraphicsPanelThread");
        thread.setDaemon(true);
        thread.start();
    }
    public void run() {
        Image backGroundImage = null;
        try {
            backGroundImage = ImageIO.read(new File("BackGround.jpeg"));
            backGroundImage = backGroundImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true) {
            if(backGroundImage != null) {
                graphics2D.drawImage(backGroundImage, 0, 0, null);
            }
            for(Led led: leds) {
                led.draw(graphics2D);
            }
            Graphics g2 = getGraphics();
            g2.drawImage(bufferedImage, 0, 0, null);                                        //�������� ��� �� �����
            g2.dispose();
        }
    }
}
