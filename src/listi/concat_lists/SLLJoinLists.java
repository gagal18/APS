package listi.concat_lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SLLJoinLists {
    public static void main(String[] args) throws IOException {
        SLL lista1 = new SLL();
        SLL lista2 = new SLL();
        //Add nodes to the list
        lista1.addNodeEnd(1);
        lista1.addNodeEnd(2);
        lista1.addNodeEnd(3);
        lista1.addNodeEnd(4);
        lista1.addNodeStart(5);

        lista2.addNodeEnd(10);
        lista2.addNodeEnd(20);
        lista2.addNodeEnd(30);
        lista2.addNodeEnd(40);
        lista2.addNodeStart(50);


        //Displays the nodes present in the list
        lista1.display();
        lista2.display();
        System.out.println(lista1.size());
        System.out.println(lista2.size());
        lista1.mergeSLL(lista2);
        System.out.println("-----------------x---------");
        lista1.display();
        System.out.println(lista1.size());

        SLLNode find_1 = lista1.find(1);
        System.out.println(find_1.data);
        lista2.mirror();
        lista2.display();
    }
}

