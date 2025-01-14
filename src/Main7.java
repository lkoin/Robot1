import java.awt.*;
import java.awt.event.MouseEvent;

public class Main7 {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();

        Util.openProgram(robot,"mspaint");

        int x = 300;
        int y = 600;

        robot.mouseMove(x,y);
        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(x+300,y); //prawo
        robot.delay(500);
        robot.mouseMove(x,y-200); //przekotna w lewo
        robot.delay(500);
        robot.mouseMove(x+300,y-200); // gora prawo
        robot.delay(500);
        robot.mouseMove(x+150,y-300);//top
        robot.delay(500);
        robot.mouseMove(x,y-200); //lewy gorny rog
        robot.delay(500);
        robot.mouseMove(x,y); //domkniecie lewej strony
        robot.delay(500);
        robot.mouseMove(x+300,y-200); //druga przekatna
        robot.delay(500);
        robot.mouseMove(x+300,y); //prawy bok
        robot.delay(500);
        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);

    }
}
