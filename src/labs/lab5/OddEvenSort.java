package labs.lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class OddEvenSort {

    static void oddEvenSort(int a[], int n) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(a[i] % 2 == 0){
                even.add(a[i]);
            }else{
                odd.add(a[i]);
            }
        }
        Collections.sort(odd);
        even.sort(Collections.reverseOrder());
        for (int i = 0; i < odd.size(); i++) {
            a[count] = odd.get(i);
            count++;
        }
        for (int i = 0; i < even.size(); i++) {
            a[count] = even.get(i);
            count++;
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
        oddEvenSort(a,n);
        for(i=0;i<n-1;i++)
            System.out.print(a[i]+" ");
        System.out.print(a[i]);
    }
}