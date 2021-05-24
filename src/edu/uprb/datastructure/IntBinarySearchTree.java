/**
 * University of Puerto Rico at Bayamon
 * Department of Computer Science
 * SICI 4036 - Data Structures, Spring 2021
 * Luis J. Berríos Negrón
 * 802-18-1607
 * luis.berrios17@upr.edu
 */


package edu.uprb.datastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Luis J. Berríos Negrón
 */
public class IntBinarySearchTree {

    private static class Node {
        public int data;
        public Node left, right;
    }

    private Node root;

    public IntBinarySearchTree() {
        root = null;
    }

    public void addIterative(int elem) {
        if (root == null)
            addFirst(elem);
        else
            addRest(elem);
    }

    private void addFirst(int elem) {
        root = new Node();
        root.left = root.right = null;
        root.data = elem;
    }

    private void addRest(int elem) {
        // Creo nodo nuevo
        Node temp = new Node();
        temp.left = temp.right = null;
        temp.data = elem;

        // Busco donde le toca conectarse
        Node prev = null;
        Node trav = root;
        while (trav != null) {
            prev = trav;
            if (elem < trav.data)
                trav = trav.left;
            else
                trav = trav.right;
        }
        // prev apunta al anterior
        // Conecto por el lado correcto
        if (elem > prev.data)
            prev.right = temp;
        else
            prev.left = temp;
    }

    public void addRecursive(int elem) {
        root = addRecursive(elem, root);
    }

    private Node addRecursive(int elem, Node curr) {
        if (curr == null) {
            curr = new Node();
            curr.data = elem;
            curr.left = curr.right = null;
        } else if (elem < curr.data)
            curr.left = addRecursive(elem, curr.left);
        else if (elem > curr.data)
            curr.right = addRecursive(elem, curr.right);
        else
            // se remplaza el que habia si es que llega
            // igual
            curr.data = elem;
        return curr;
    }


    public boolean containsIterative(int elem) {
        Node trav = root;
        while (trav != null) {
            if (trav.data == elem)
                return true;
            else if (elem < trav.data)
                trav = trav.left;
            else
                trav = trav.right;
        }
        return false;
    }

    public boolean containsRecursive(int elem) {
        return containsRecursive(elem, root);
    }

    private boolean containsRecursive(int elem, Node curr) {
        if (curr == null)
            return false;
        else if (elem < curr.data)
            return containsRecursive(elem, curr.left);
        else if (elem > curr.data)
            return containsRecursive(elem, curr.right);
        else
            return true;
    }

    public int sizeIterative() {
        // TODO
        return 0;
    }

    public int size() {
        // El Recursivo es el mas facil de entender
        // y construir
        return size(root);
    }

    private int size(Node curr) {
        if (curr == null)
            return 0;
        else
            return 1 + size(curr.left) + size(curr.right);
    }

    public int sumElementsIterative() {
        // TODO ???
        return 0;
    }

    public int sumElements() {
        // El Recursivo es el mas facil de entender
        // y construir
        return sumElements(root);
    }

    private int sumElements(Node curr) {
        if (curr == null)
            return 0;
        else
            return curr.data + sumElements(curr.left) + sumElements(curr.right);
    }

    public int maximumIterative() {
        if (root == null)
            throw new NoSuchElementException("empty tree");
        Node trav = root;
        while (trav.right != null)
            trav = trav.right;
        return trav.data;
    }

    public int maximumRecursive() {
        if (root == null)
            throw new NoSuchElementException("empty tree");
        return maximumRecursive(root);
    }

    private int maximumRecursive(Node curr) {
        if (curr.right == null)
            return curr.data;
        else
            return maximumRecursive(curr.right);
    }

    public int productElements() {
        if (root == null)
            throw new NoSuchElementException("empty tree");
        return productElements(root);
    }

    private int productElements(Node curr) {
        if (curr == null)
            return 1;
        else
            return curr.data
                    * productElements(curr.left)
                    * productElements(curr.right);
    }

    public int averageElement() {
        if (root == null)
            throw new NoSuchElementException("empty tree");
        return sumElements() / size();
    }

    public int minimumElement() {
        if (root == null)
            throw new NoSuchElementException("empty tree");
        return minimumElement(root);
    }

    private int minimumElement(Node curr) {
        if (curr.left == null)
            return curr.data;
        else
            return minimumElement(curr.left);
    }

    public int depth() {
        if (root == null)
            return 0;
        return depth(root);
    }

    private int depth(Node curr) {
        if (curr == null)
            return 0;
        else
            return 1 + Math.max(depth(curr.left), depth(curr.right));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof IntBinarySearchTree))
            return false;

        IntBinarySearchTree other = (IntBinarySearchTree) obj;
        return equals(root, other.root);
    }

    private boolean equals(Node root1, Node root2) {
        if (root1 != null && root2 != null) {
            return root1.data == root2.data
                    && equals(root1.left, root2.left)
                    && equals(root1.right, root2.right);
        }
        return root1 == null && root2 == null;
    }

    public void readFromFile(String fileName) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(fileName));
        while (reader.hasNextInt()) {
            try {
                int num = reader.nextInt();
                addRecursive(num);
            } catch (InputMismatchException ok) {
                // skip, don't bother
            }
        }
        reader.close();
    }

    public void storeToFile(String fileName) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(fileName);
        writer.print("[");
        storeToFile(writer, root);
        writer.print("]");
        writer.close();
    }

    private void storeToFile(PrintWriter writer, Node curr) {
        if (curr != null) {
            writer.print(curr.data);
            if (curr.left != null) {
                writer.print(", ");
            }
            storeToFile(writer, curr.left);
            if (curr.right != null) {
                writer.print(", ");
            }
            storeToFile(writer, curr.right);
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        treeToString(root, str);
        return str.append("]").toString();
    }

    private void treeToString(Node curr, StringBuilder str) {
        // In order traversal
        if (curr != null) {
            treeToString(curr.left, str);
            if (curr.left != null)
                str.append(", ");
            str.append(curr.data);
            if (curr.right != null)
                str.append(", ");
            treeToString(curr.right, str);
        }
    }

}

