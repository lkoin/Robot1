import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.security.Key;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) throws AWTException {
        Scanner scanner = new Scanner(System.in);
        Robot robot = new Robot();
        System.out.println("Podaj nazwe pliku do zapisu");
        String name = scanner.nextLine();
        System.out.println("Podaj dlugosc boku:");
        int side = scanner.nextInt();
        scanner.nextLine();
        robot.delay(500);


        Util.openProgram(robot,"mspaint");

        int x = 400;
        int y = 300;

        robot.mouseMove(x,y);
        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(x+side,y);
        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(x+side,y+side);
        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(x,y+side);
        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(x,y);
        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);

        Util.saveInprogram(robot, name);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);



        robot.delay(300);

        Util.closeProgram(robot);


    }
}
