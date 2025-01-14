import java.awt.*;
import java.awt.event.KeyEvent;

public class Util {
    public static void typetext(char[] chars, Robot robot) {
        for (int i = 0; i< chars.length; i++) {
            robot.delay(50);
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

    public static void openProgram(Robot robot, String program) {
        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
        char[] chars2 = program.toCharArray();
        typetext(chars2,robot);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(500);
    }

    public static void closeProgram(Robot robot) {
        robot.keyPress(KeyEvent.VK_ALT);
        robot.delay(300);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_ALT);

    }

    public static void saveInprogram(Robot robot, String name) {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(20);

        char[] word = name.toCharArray();
        Util.typetext(word, robot);
    }
}
