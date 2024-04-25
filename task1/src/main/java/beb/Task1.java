package beb;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        int i = 1;
        String total = "";

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

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