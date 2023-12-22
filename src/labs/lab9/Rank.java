package labs.lab9;

import java.util.Scanner;

public class Rank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        int N = scanner.nextInt();
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = scanner.nextInt();
        }
        int M = scanner.nextInt();

        int result = findRank(N, scores, M);
        System.out.println(result);

        scanner.close();
    }

    public static int findRank(int N, int[] scores, int M) {
        int rank = 1;

        for (int score : scores) {
            if (score > M) {
                rank++;
            }
        }

        return rank;
    }
}

