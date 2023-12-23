package labs.lab9;

import java.util.Scanner;

public class BusCapacity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();
        int N = scanner.nextInt();
        int[] events = new int[24 * 60];

        for (int i = 0; i < N; i++) {
            int boardTime = convertToMinutes(scanner.next());
            int alightTime = convertToMinutes(scanner.next());

            events[boardTime]++;

            events[alightTime]--;
        }

        int passengersOnBus = 0;
        for (int value : events) {
            passengersOnBus += value;

            if (passengersOnBus > capacity) {
                System.out.println("false");
                return;
            }
        }

        System.out.println("true");

        scanner.close();
    }

    private static int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}
