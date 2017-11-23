import view.Led;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by User on 23.11.2017.
 */
public class Base {

    private String base = "LEDPROGRAMMER";
    private String password = "ijcnbqrehc";

    public ArrayList<Led> getLeds() {

        ArrayList<Led> leds = new ArrayList<>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = null;
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", base, password);

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from Leds order by LEDSID");
            while (rs.next()) {
                leds.add(new Led(rs.getInt("LEDSID"), rs.getInt("X"), rs.getInt("Y"), rs.getInt("RADIUS"), rs.getInt("R"), rs.getInt("G"), rs.getInt("B")));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return leds;
    }

    public void setLeds(ArrayList<Led> leds) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = null;
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", base, password);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select max(LEDSID) from LEDS");
            int size = 0;
            if(rs.next()) {    //if have some records
                size = rs.getInt("max(LEDSID)") + 1;
            }
            for(int i = 0; i < size; i++) {
                statement.executeUpdate("UPDATE LEDS " +
                                        "SET X = " + leds.get(i).getX() +
                                        ", Y = " + leds.get(i).getY() +
                                        ", RADIUS = " + leds.get(i).getRadius() +
                                        ", R = " + leds.get(i).getR() +
                                        ", G = " + leds.get(i).getG() +
                                        ", B = " + leds.get(i).getB() +
                                        "WHERE LEDSID = " + i);
            }
            for(int i = size; i < leds.size(); i++) {
                statement.execute("insert into LEDS(LEDSID, X, Y, RADIUS, R, G, B)" +
                                    "values(" + i + ", " +
                                    leds.get(i).getX() + ", " +
                                    leds.get(i).getY() + ", " +
                                    leds.get(i).getRadius() + ", " +
                                    leds.get(i).getR() + ", " +
                                    leds.get(i).getG() + ", " +
                                    leds.get(i).getB() + ")");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
