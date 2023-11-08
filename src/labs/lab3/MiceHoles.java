package labs.lab3;

import java.util.*;

public class MiceHoles {

    //TODO: implement function
    public static int minTime(int mice[], int holes[]) {
        int[] sortedMices = Arrays.stream(mice).sorted().toArray();
        int[] sortedHoles = Arrays.stream(holes).sorted().toArray();
        int maxSteps = 0;
        for (int i = 0; i < sortedHoles.length; i++) {
            int currentStep = Math.abs(sortedMices[i] - sortedHoles[i]);
            if(currentStep > maxSteps){
                maxSteps = currentStep;
            }
        }
        return maxSteps;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String line = input.nextLine();
        String parts[] = line.split(" ");
        int mice[] = new int[parts.length];
        for(int i=0;i<parts.length;i++) {
            mice[i] = Integer.parseInt(parts[i]);
        }

        line = input.nextLine();
        parts = line.split(" ");
        int holes[] = new int[parts.length];
        for(int i=0;i<parts.length;i++) {
            holes[i] = Integer.parseInt(parts[i]);
        }

        System.out.println(minTime(mice, holes));
    }
}
