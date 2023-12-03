//package labs.lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShakerSort {

    static void shakerSort(int a[], int n) {
        boolean swapped = true;
        int start = 0;
        for(int j = 0; j < (n + 1) / 2; j++) {
            swapped = false;
            for (int i = n - 1; i > start; i--) {
                if (a[i] < a[i - 1]) {
                    int temp = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = temp;
                    swapped = true;
                }
            }

            for (int num: a) {
                System.out.print(num+" ");
            }
            System.out.println();


            for (int i = start; i < n - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }
            start++;
            for (int num: a) {
                System.out.print(num+" ");
            }
            System.out.println();
            if(!swapped) break;
        }

    }
    public static void main(String[] args) throws IOException{
        int i;
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String [] pom = s.split(" ");
        int [] a = new int[n];
        for(i=0;i<n;i++)
            a[i]=Integer.parseInt(pom[i]);
        shakerSort(a,n);
    }
}