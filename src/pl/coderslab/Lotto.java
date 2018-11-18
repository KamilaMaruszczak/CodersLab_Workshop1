package pl.coderslab;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        Lottery(GiveNumbers());

    }

    static int[] GiveNumbers() {
        System.out.println("TO JEST LOTTO");
        System.out.println("Podaj swoje 6 liczb z zakresu od 1 do 49");
        Scanner scan = new Scanner(System.in);
        int[] tab = new int[6];
        int num = 0;
        for (int i = 0; i < 6; i++) {
            while (!scan.hasNextInt()) {
                String err = scan.next();
                System.out.println(err + " to nie jest poprawna liczba. Podaj jeszcze raz");
            }
            num = scan.nextInt();
            for (int j = 0; j < i; j++) {
                while (tab[j] == num || num >= 50) {
                    System.out.println(num + " to nie jest poprawna liczba. Podaj jeszcze raz");
                    num = scan.nextInt();
                }
            }
            tab[i] = num;
        }
        scan.close();
        Arrays.sort(tab);
        System.out.print("Twoje wybrane liczby to: ");
        System.out.println(Arrays.toString(tab));

        return tab;
    }

    static void Lottery(int[] tab) {
        Random generator = new Random();
        int[] result = new int[6];
        int counter = 0;
        for (int i = 0; i < 6; i++) {
            result[i] = generator.nextInt(49) + 1;
            for (int j = 0; j < 6; j++) {
                if (result[i] == tab[j]) {
                    counter++;
                }
            }
        }
        Arrays.sort(result);
        System.out.println("Wylosowane liczby to: " + Arrays.toString(result));

        switch (counter) {
            case 6:
                System.out.println("Hurraaaaay!! Trafiłeś szóstkę! Jesteś milionerem");
                break;
            case 5:
                System.out.println("Brawo!! Trafiłeś piątkę! Duża wygrana jest twoja");
                break;
            case 4:
                System.out.println("Trafiłeś czwórkę! Jesteś szczęściarzem");
                break;
            case 3:
                System.out.println("Trafiłeś trójkę! Przynajmniej nic nie straciłeś");
                break;
            default:
                System.out.println("Nic nie wygrałeś. Straciłeś tylko 2,50 pln");
        }

    }

}
