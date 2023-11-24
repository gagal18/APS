package kol_1.exe4;

import java.util.Arrays;
import java.util.Scanner;


public class LDS {


    private static int najdolgaOpagackaSekvenca(int[] a) {
        int len = a.length;
        if(len == 1) return 1;
        int arr[] = new int[len];
        Arrays.fill(arr, 1);
        for (int i = 1; i < len; i++)
            for (int j = 0; j < i; j++)
                if (a[i] < a[j] && arr[i] < arr[j] + 1){
                    arr[i] = arr[j] + 1;
                    System.out.printf("Updating %d %d -> current length %d \n ", a[i], a[j], arr[i]);
                }
        return Arrays.stream(arr).max().orElse(1);
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
    }


}

