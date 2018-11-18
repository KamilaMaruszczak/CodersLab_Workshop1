package pl.coderslab;

import java.util.Random;
import java.util.Scanner;

public class GuessANumber {
    public static void main(String[] args) {
        Number(60);

    }

    static void Number(int max) {
        Random generator = new Random();
        int num = generator.nextInt(max) + 1;
        System.out.println("Wylosowałem dla Ciebie liczbę z zakresu od 1 do " + max);
        System.out.println("Zgaduj");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            scan.next();
        }
        int check = scan.nextInt();
        int counter = 1;
        while (num != check) {
            counter++;
            if (num > check) {
                System.out.println("Za mało. Wylosowana liczba jest większa");
            } else {
                System.out.println("Za dużo. Wylosowana liczba jest mniejsza");
            }
            while (!scan.hasNextInt()) {
                scan.next();
            }
            check = scan.nextInt();
        }
        System.out.println("Brawo! Wylosowana liczba to: " + num + " Zgadłeś w " + counter + " krokach.");
    }

}
