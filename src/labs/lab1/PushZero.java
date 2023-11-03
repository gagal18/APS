package labs.lab1;
import java.util.Scanner;

public class PushZero {

    static void pushZerosToBeginning(int arr[], int n) {
        int zero_counter = 0;
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if(num == 0){
                for (int j = i; j > zero_counter; j--) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                arr[zero_counter] = 0;
                zero_counter++;
            }
        }
        System.out.println("Transformiranata niza e:");
        for (int num: arr) {
            System.out.print(num+" ");
        }
    }

    public static void main (String[] args) {
        int ARR_LENGTH = 12;
        int[] arr = new int[]{1,9,8,4,0,0,2,7,0,6,0,9};
        pushZerosToBeginning(arr, ARR_LENGTH);
    }

//    public static void main (String[] args) {
//        int ARR_LENGTH;
//        Scanner newScanner = new Scanner(System.in);
//        ARR_LENGTH = newScanner.nextInt();
//        int[] arr = new int[ARR_LENGTH];
//
//        for (int i = 0; i < ARR_LENGTH; i++) {
//            arr[i] = newScanner.nextInt();
//        }
//        pushZerosToBeginning(arr, ARR_LENGTH);
//    }
}