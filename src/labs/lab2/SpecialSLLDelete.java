package labs.lab2;

import java.util.Scanner;

@SuppressWarnings("unchecked")
public class SpecialSLLDelete<E> {

    //TODO: implement method
    public void specialDelete(SLL<E> list, int m) {
        SLLNode head = list.getFirst();
        int index = 1;
        while(head != null){
            if(index % m == 0){
                list.delete(head);
            }
            head = head.succ;
            index++;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        SLL<Integer> list = new SLL<>();
        for(int i=0;i<n;i++) {
            list.insertLast(input.nextInt());
        }

        int m = input.nextInt();

        SpecialSLLDelete<Integer> tmp = new SpecialSLLDelete<>();

        tmp.specialDelete(list, m);

        System.out.println(list);
    }

}
