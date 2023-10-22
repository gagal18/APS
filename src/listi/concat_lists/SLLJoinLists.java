package listi.concat_lists;
public class SLLJoinLists {
    public static void main(String[] args) {
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
        System.out.println("---------------LISTA 1 filling, printing and size of it---------");
        lista1.display();
        System.out.println(lista1.size());
        System.out.println("---------------LISTA 2 filling, printing and size of it---------");
        lista2.display();
        System.out.println(lista2.size());
        System.out.println("---------------MERGE LISTA 2 into Lista1---------");
        lista1.mergeSLL(lista2);
        System.out.println("-----------------PRINT LISTA1 merged---------");
        lista1.display();
        System.out.println(lista1.size());
        System.out.println("-----------------PRINT LISTA1 element with data 1 (using find method)---------");
        SLLNode find_1 = lista1.find(1);
        System.out.println(find_1.data);
        lista2.mirror();
        System.out.println("-----------------PRINT LISTA2 mirrored---------");
        lista2.display();
    }
}

