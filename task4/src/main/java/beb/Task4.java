package beb;

import java.io.*;
import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(args[0]));
            while (scanner.hasNext()) nums.add(scanner.nextInt());
        } catch (FileNotFoundException fne) { fne.printStackTrace(); }


        Collections.sort(nums);
        int target;
        if (nums.size() % 2 == 1) target = nums.get(nums.size() / 2);
        else target = (int) Math.round((nums.get(nums.size() / 2) + nums.get(nums.size() / 2 - 1)) / 2.0);
        
        int steps = 0;
        for (int i = 0; i < nums.size(); i++)
            steps += Math.abs(nums.get(i) - target);
        System.out.println(steps);
    }
}