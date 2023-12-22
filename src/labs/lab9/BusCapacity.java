package labs.lab9;

import java.util.Scanner;

public class BusCapacity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        int capacity = scanner.nextInt();
        int N = scanner.nextInt();
        int[] events = new int[24 * 60]; // One entry for each minute in a 24-hour day

        // Process boarding and alighting events
        for (int i = 0; i < N; i++) {
            int boardTime = convertToMinutes(scanner.next());
            int alightTime = convertToMinutes(scanner.next());

            // Mark boarding event with +1
            events[boardTime]++;

            // Mark alighting event with -1
            events[alightTime]--;
        }

        // Simulate the bus ride
        int passengersOnBus = 0;
        for (int value : events) {
            passengersOnBus += value;

            // Check if the current capacity is exceeded
            if (passengersOnBus > capacity) {
                System.out.println("false");
                return;
            }
        }

        // If we reach here, the capacity is never exceeded
        System.out.println("true");

        scanner.close();
    }

    // Helper method to convert time to minutes
    private static int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}
