package kol_1.exe3;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bus {

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();


        // Vasiot kod tuka
        if(M == 0){
            System.out.println(N*100);
            System.out.println(N*100);
            return;
        }
        int maxOfBoth = Math.max(N,M);
        int minPrice = maxOfBoth * 100;
        int maxPrice = 100 * M + (N-1)*100;
        System.out.println(minPrice);
        System.out.println(maxPrice);

    }

}