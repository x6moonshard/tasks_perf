import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float pointX, pointY;
        float circleX = 0, circleY = 0, radius = 0;
        double hypotenuse;
        String content = "";
        String file1 = "", file2 = "";

        Scanner in = new Scanner(System.in);
        file1 = args[0];
        file2 = args[1];

        try (BufferedReader br = new BufferedReader(new FileReader(file1)))
        {
            String line;

            while ((line = br.readLine()) != null) {
                content = content + line;
                content = content + " ";
            }

            String[] words = content.split(" ");
            circleX = Float.parseFloat(words[0]);
            circleY = Float.parseFloat(words[1]);
            radius = Float.parseFloat(words[2]);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file2)))
        {
            String line;
            content = "";

            while ((line = br.readLine()) != null) {
                content = content + line;
                content = content + " ";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] pointsCoordinates = content.split(" ");

        for(int i = 0; i < pointsCoordinates.length; i = i + 2){
            pointX = Float.parseFloat(pointsCoordinates[i]);
            pointY = Float.parseFloat(pointsCoordinates[i + 1]);

            hypotenuse = Math.pow(circleX - pointX, 2) + Math.pow(circleY - pointY, 2);

            if(hypotenuse == Math.pow(radius, 2)){
                System.out.println("0");
            }
            else if(hypotenuse < Math.pow(radius, 2)){
                System.out.println("1");
            }
            else {
                System.out.println("2");
            }
        }
    }
}