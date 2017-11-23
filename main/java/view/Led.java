package view;

import java.awt.*;
import java.math.BigInteger;

/**
 * Created by User on 23.11.2017.
 */
public class Led {
    private int id;
    private int x;
    private int y;  //coordinates of the center
    private static int radius = 10;
    private int R;  //color (RGB)
    private int G;
    private int B;
    private boolean selected = false;

    public Led(int id, int x, int y, int radius, int R, int G, int B) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.R = R;
        this.G = G;
        this.B = B;
    }

    /**
     * checks whether the dot belongs to the diode field
     * @param x
     * @param y
     * @return true if the dot belongs to the diode field
     */
    public boolean inArea(int x, int y) {
        if(x >= this.x - radius && x <=this.x + radius && y >= this.y - radius && y <= this.y + radius) {
            return true;
        }
        return false;
    }

    public void setCoordinates(int x, int y) {
        if(selected) {
            this.x = x;
            this.y = y;
        }
    }

    public void setColor(int R, int G, int B) {
        this.R = R;
        this.G = G;
        this.B = B;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getRadius() {
        return radius;
    }

    public int getR() {
        return R;
    }

    public int getG() {
        return G;
    }

    public int getB() {
        return B;
    }

    public void draw(Graphics2D graphics2D) {
        if(selected) {
            graphics2D.setColor(Color.BLACK);
        }
        else {
            graphics2D.setColor(Color.WHITE);
        }
        int halfHeight = (int)(radius / 0.88);
        graphics2D.fillRect(x - halfHeight, y - halfHeight, halfHeight * 2, halfHeight * 2);
        graphics2D.setColor(new Color(R, G, B));
        graphics2D.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected(){
        return selected;
    }

    public int getId() {
        return id;
    }
}
