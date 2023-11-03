package labs.lab1;

import java.util.Scanner;

public class ReverseWord {

    public static void printReversed(String word) {
        int length = word.length();
        for (int i = length-1; i >= 0 ; i--) {
            System.out.print(word.charAt(i));
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int ARR_LENGTH;
        Scanner newScanner = new Scanner(System.in);
        ARR_LENGTH = newScanner.nextInt();
        newScanner.nextLine();
        String[] arr = new String[ARR_LENGTH];

        for (int i = 0; i < ARR_LENGTH; i++) {
            arr[i] = newScanner.nextLine();
        }
        for (int i = 0; i < ARR_LENGTH; i++) {
            printReversed(arr[i]);
        }
    }
}