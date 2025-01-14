import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz fraze do wyszukiwania");
        String fraza = scanner.nextLine();
        char[] chars = fraza.toCharArray();

        String website = "chrome";

        Util.openProgram(robot,website);

        robot.delay(500);

        Util.typetext(chars,robot);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.delay(1000);


        getScreenShot(robot,"youtube");

    }

    public static void getScreenShot(Robot robot,String name) {
        Rectangle rectangle = new Rectangle(1920,1080);
        BufferedImage image = robot.createScreenCapture(rectangle);
        try {
            ImageIO.write(image,"jpg",new File(name+".jpg"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
