import java.awt.*;
import java.awt.event.InputEvent;

public class Main4 {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            Color color = new Color(75, 219, 106);

            int x = 500;
            int y = 400;

            while (true) {
                Color pixelcolor = robot.getPixelColor(x,y);
                if (pixelcolor.equals(color)) robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            }
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }
}
