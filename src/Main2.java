import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

public class Main2 {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_1);
            robot.keyRelease(KeyEvent.VK_1);
            robot.delay(300);
            robot.keyPress(KeyEvent.VK_1);
            robot.keyRelease(KeyEvent.VK_1);
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_2);
            robot.keyRelease(KeyEvent.VK_2);


        } catch (AWTException e) {
            System.err.println(e.getMessage());
        }
    }
}
