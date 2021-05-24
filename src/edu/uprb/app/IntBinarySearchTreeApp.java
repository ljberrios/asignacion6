/**
 * University of Puerto Rico at Bayamon
 * Department of Computer Science
 * SICI 4036 - Data Structures, Spring 2021
 * Luis J. Berríos Negrón
 * 802-18-1607
 * luis.berrios17@upr.edu
 */


package edu.uprb.app;

import edu.uprb.datastructure.IntBinarySearchTree;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Luis J. Berríos Negrón
 */
public class IntBinarySearchTreeApp {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name of input file: ");
        String inputFileName = scanner.nextLine();

        System.out.print("Name of output file: ");
        String outputFileName = scanner.nextLine();

        IntBinarySearchTree tree = new IntBinarySearchTree();
        tree.readFromFile(inputFileName);

        System.out.println("Creating binary search tree from input file...");
        System.out.println("Binary search tree statistics:");
        System.out.println();
        System.out.println("Depth: " + tree.depth());
        System.out.printf("Min: %d, Max: %d\n",
                tree.minimumElement(), tree.maximumRecursive());
        System.out.println("Size: " + tree.size());
        System.out.println("Sum: " + tree.sumElements());
        System.out.println();
        System.out.println("Storing tree to output file...");
        tree.storeToFile(outputFileName);

        scanner.close();
        System.exit(0);
    }

}
