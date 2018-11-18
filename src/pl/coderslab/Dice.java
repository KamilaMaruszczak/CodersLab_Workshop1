package pl.coderslab;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Dice {

    public static void main(String[] args) {
        System.out.println("Wynik rzutu to: " + ThrowADice());

    }

    public static int ThrowADice() {
        int result = 0, x = 1, y = 0, z = 0;
        System.out.println("Podaj rodzaj rzutu w formie xDy+z");
        Random generator = new Random();

        Scanner scan = new Scanner(System.in);
        String code = scan.next();

        String[] parts = StringUtils.split(code, "D+-");
        int length = parts.length;
        //System.out.println(Arrays.toString(parts));

        boolean plus = code.contains("+");
        boolean minus = code.contains("-");

        try {
            if (length == 1) {
                y = Integer.parseInt(parts[0]);

            } else if (length == 2) {
                if (!plus && !minus) {
                    x = Integer.parseInt(parts[0]);
                    y = Integer.parseInt(parts[1]);

                } else {
                    y = Integer.parseInt(parts[0]);
                    z = Integer.parseInt(parts[1]);
                }
            } else if (length == 3) {
                x = Integer.parseInt(parts[0]);
                y = Integer.parseInt(parts[1]);
                z = Integer.parseInt(parts[2]);

            } else {
                System.out.println("Invalid Dice Throw format");
            }

            for (int i = 0; i < x; i++) {
                result += generator.nextInt(y) + 1;
            }

            if (plus) {
                result += z;
            }
            if (minus) {
                result -= z;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Dice Throw format");
        }

        return result;
    }
}
