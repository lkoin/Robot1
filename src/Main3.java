import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wyrazenie");
        String word = scanner.nextLine();

        char[] chars = word.toCharArray();
        try {
            Robot robot = new Robot();
            openNotepad(robot,"notepad");
            robot.delay(500);
            typetext(chars, robot);


            BufferedImage image = robot.createScreenCapture(new Rectangle(1920,1080));
            try {
                ImageIO.write(image,"jpg",new File("image.jpg"));
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } catch (AWTException e) {
            System.err.println(e.getMessage());
        }


//        try {
//            File file = new File("src/eject.bat");
//            Desktop.getDesktop().open(file);
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        }

    }

    private static void typetext(char[] chars, Robot robot) {
        for (int i = 0; i< chars.length; i++) {
            robot.delay(30);
            if (isPolish(chars[i])) {
                System.out.println(getPolsih(chars[i]));
                char temp = getPolsih(chars[i]);
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(temp);
                robot.keyPress(KeyEvent.VK_ALT_GRAPH);
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
                robot.keyRelease(KeyEvent.VK_ALT_GRAPH);
            }
            else {
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(chars[i]);
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
            }
        }
    }

    public static void openNotepad(Robot robot,String program) {
        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
        char[] chars2 = program.toCharArray();
        typetext(chars2,robot);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    private static void openNotepad() {
        try {
            File file = new File("C:\\WINDOWS\\system32\\notepad.exe");
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static char getPolsih(char ch) {
        char[] polish = {'ą','ę','ś','ź','ź','ć','ó','ł','ń'};
        char[] polish2 = {'a','e','s','z','x','c','o','l','n'};
        for (int i =0;i< polish.length;i++) {
            if (ch == polish[i]) return polish2[i];
        }
        return 0;
    }
    public static boolean isPolish(char ch) {
        char[] polish = {'ą','ę','ś','ź','ź','ć','ó','ł','ń'};
        for (char polishchar : polish) {
            if (ch == polishchar) return true;
        }
        return false;
    }

    }
