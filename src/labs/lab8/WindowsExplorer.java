//package labs.lab8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.NoSuchElementException;

interface Tree<E> {
    ////////////Accessors ////////////

    public Node<E> root();

    public Node<E> parent(Node<E> node);

    public int childCount(Node<E> node);

    ////////////Transformers ////////////
    public void makeRoot(E elem);

    public Node<E> addChild(Node<E> node, E elem);

    public void remove(Node<E> node);

    ////////////Iterator ////////////
    public Iterator<E> children(Node<E> node);

}

interface Node<E> {

    public E getElement();

    public void setElement(E elem);
}


class SLLTree<E> implements Tree<E> {

    public SLLNode<E> root;

    public SLLTree() {
        root = null;
    }

    public Node<E> root() {
        return root;
    }

    public Node<E> parent(Node<E> node) {
        return ((SLLNode<E>) node).parent;
    }

    public int childCount(Node<E> node) {
        SLLNode<E> tmp = ((SLLNode<E>) node).firstChild;
        int num = 0;
        while (tmp != null) {
            tmp = tmp.sibling;
            num++;
        }
        return num;
    }

    public void makeRoot(E elem) {
        root = new SLLNode<E>(elem);
    }

    public Node<E> addChild(Node<E> node, E elem) {
        SLLNode<E> tmp = new SLLNode<E>(elem);
        SLLNode<E> curr = (SLLNode<E>) node;
        tmp.sibling = curr.firstChild;
        curr.firstChild = tmp;
        tmp.parent = curr;
        return tmp;
    }

    public void remove(Node<E> node) {
        SLLNode<E> curr = (SLLNode<E>) node;
        if (curr.parent != null) {
            if (curr.parent.firstChild == curr) {
                // The node is the first child of its parent
                // Reconnect the parent to the next sibling
                curr.parent.firstChild = curr.sibling;
            } else {
                // The node is not the first child of its parent
                // Start from the first and search the node in the sibling list and remove it
                SLLNode<E> tmp = curr.parent.firstChild;
                while (tmp.sibling != curr) {
                    tmp = tmp.sibling;
                }
                tmp.sibling = curr.sibling;
            }
        } else {
            root = null;
        }
    }

    class SLLTreeIterator<T> implements Iterator<T> {

        SLLNode<T> start, current;

        public SLLTreeIterator(SLLNode<T> node) {
            start = node;
            current = node;
        }

        public boolean hasNext() {
            return (current != null);
        }

        public T next() throws NoSuchElementException {
            if (current != null) {
                SLLNode<T> tmp = current;
                current = current.sibling;
                return tmp.getElement();
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (current != null) {
                current = current.sibling;
            }
        }
    }

    public Iterator<E> children(Node<E> node) {
        return new SLLTreeIterator<E>(((SLLNode<E>) node).firstChild);
    }

    void printTreeRecursive(Node<E> node, int level) {
        if (node == null)
            return;
        int i;
        SLLNode<E> tmp;

        for (i=0;i<level;i++)
            System.out.print(" ");
        System.out.println(node.getElement().toString());
        tmp = ((SLLNode<E>)node).firstChild;
        while (tmp != null) {
            printTreeRecursive(tmp, level+1);
            tmp = tmp.sibling;
        }
    }

    public void printTree() {
        printTreeRecursive(root, 0);
    }

}

class SLLNode<P> implements Node<P> {

    // Holds the links to the needed nodes
    public SLLNode<P> parent, sibling, firstChild;
    // Hold the data
    public P element;

    public SLLNode(P o) {
        element = o;
        parent = sibling = firstChild = null;
    }

    public P getElement() {
        return element;
    }

    public void setElement(P o) {
        element = o;
    }
}

public class WindowsExplorer {

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String commands[] = new String[N];

        for (i=0;i<N;i++)
            commands[i] = br.readLine();

        br.close();

        SLLTree<String> tree = new SLLTree<String>();
        tree.makeRoot("c:");
        
        // vasiot kod stoi ovde
        SLLNode<String> currentNode = tree.root;

        for (i = 0; i < N; i++) {
            String[] line = commands[i].split(" ");
            switch (line[0]) {
                case "CREATE":
                    String nodeAdd = line[1];

                    SLLNode<String> newNode = new SLLNode<>(nodeAdd);

                    if (currentNode.firstChild == null || nodeAdd.compareTo(currentNode.firstChild.element) < 0) {
                        newNode.sibling = currentNode.firstChild;
                        currentNode.firstChild = newNode;
                    } else {
                        SLLNode<String> prev = null;
                        SLLNode<String> current = currentNode.firstChild;

                        while (current != null && nodeAdd.compareTo(current.element) > 0) {
                            prev = current;
                            current = current.sibling;
                        }

                        prev.sibling = newNode;
                        newNode.sibling = current;
                    }

                    newNode.parent = currentNode;
                    break;
                case "OPEN":
                    SLLNode<String> node = currentNode.firstChild;
                    while (node != null && !node.getElement().equals(line[1])) {
                        node = node.sibling;
                    }
                    if (node != null) {
                        currentNode = node;
                    } else {
                        System.out.println("Directory not found: " + line[1]);
                    }
                    break;
                case "PATH":
                    StringBuilder path = new StringBuilder();
                    SLLNode<String> start = currentNode;
                    Stack<String> pathStck = new Stack<>();
                    while (start != null) {
                        pathStck.push(start.element);
                        start = start.parent;
                    }
                    while(!pathStck.isEmpty()){
                        path.append(pathStck.pop()+"\\");
                    }
                    System.out.println(path);
                    break;
                case "DELETE":
                    SLLNode<String> element = currentNode.firstChild;
                    while(element != null && !element.element.equals(line[1]))  {
                        element = element.sibling;
                    }
                    if(element != null) tree.remove(element);
                    break;
                case "BACK":
                    currentNode = currentNode.parent;
                    break;
                case "PRINT":
                    tree.printTree();
                    break;
                default:
                    System.out.println("Invalidna operacija");
                    break;
            }
        }


    }

}
