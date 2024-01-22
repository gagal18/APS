 package kol_2.exe1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BNode<E>{
    public E value;
    public BNode<E> left;
    public BNode<E> right;

    public BNode(E value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public BNode(E value, BNode<E> left, BNode<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
class BTree<E extends Comparable<E>>{
    public BNode<E> root;

    public BTree(BNode<E> root) {
        this.root = root;
    }
    public void insert(E value) {
        root = insertRecursive(root, value);
    }

    private BNode<E> insertRecursive(BNode<E> node, E value) {
        if (node == null) {
            return new BNode<>(value);
        }

        if (value.compareTo(node.value) < 0) {
            node.left = insertRecursive(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = insertRecursive(node.right, value);
        }

        return node;
    }
    public void inorderRoot() {
        inorder(root);
    }

    public void inorder(BNode<E> n) {
        if (n != null) {
            inorder(n.left);
            System.out.println(n.value.toString());
            inorder(n.right);
        }
    }
}
public class InorderSuccesor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int rootVal = Integer.parseInt(br.readLine());
        BNode<Integer> root = new BNode<>(rootVal);
        BTree<Integer> tree = new BTree<>(root);
        for (int i = 1; i < N; i++) {
            tree.insert(Integer.parseInt(br.readLine()));
        }
        tree.inorderRoot();
    }
}
