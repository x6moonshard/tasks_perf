package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String file;
        int median;
        int sum = 0;
        int number = 0;
        int stepsCounter = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        file = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;

            while ((line = br.readLine()) != null) {
                arr.add(Integer.valueOf(Integer.parseInt(line)));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        arr.sort(Comparator.naturalOrder());

        for (Integer value : arr) {
            sum += value;
        }

        median = Math.round(sum / arr.size());


        for (Integer integer : arr) {
            number = integer;
            while (true) {
                if (number != median) {
                    if (number < median) {
                        number += 1;
                        stepsCounter++;
                    } else {
                        number -= 1;
                        stepsCounter++;
                    }
                } else {
                    break;
                }
            }
        }

        System.out.println(stepsCounter);
    }
}