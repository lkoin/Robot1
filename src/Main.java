import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        random.setSeed(9367);
        System.out.println(random.nextLong());
        for (int i=0;i<5;i++) {
            System.out.println(random.nextInt(100));
        }
    }
}
