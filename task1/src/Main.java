import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n = 0;
        int m = 0;
        int i = 1;
        String total = "";

        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();

        while (true) {
            total = total + i;
            i = 1 + (i + m - 2) % n;
            if (i == 1) {
                break;
            }
        }

        System.out.println(total);
    }

}