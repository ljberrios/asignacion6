/**
 * University of Puerto Rico at Bayamon
 * Department of Computer Science
 * SICI 4036 - Data Structures, Spring 2021
 * Luis J. Berríos Negrón
 * 802-18-1607
 * luis.berrios17@upr.edu
 */


package edu.uprb.datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a JUnit test case for the IntBinarySearchTree class.
 *
 * @author Antonio F. Huertas {@literal <antonio.huertas@upr.edu>}
 * @author Luis J. Berríos Negrón
 */
public class IntBinarySearchTreeTest {

    /**
     * Reference to class under test.
     */
    private IntBinarySearchTree bst;

    /**
     * Creates a binary search tree for testing.
     */
    @BeforeEach
    public void setUp() {
        bst = new IntBinarySearchTree();

        bst.addRecursive(30);
        bst.addRecursive(10);
        bst.addRecursive(40);
        bst.addRecursive(20);
    }

    /**
     * Tests the product of a non-empty tree is computed as expected.
     */
    @Test
    public void testProductElements() {
        assertEquals(240000, bst.productElements());
    }

    /**
     * Tests the product of an empty tree is computed as expected.
     */
    @Test
    public void testProductElementsForEmptyTree() {
        IntBinarySearchTree empty = new IntBinarySearchTree();
        try {
            int product = empty.productElements();
            fail("Test failure with empty tree: product=" + product);
        } catch (NoSuchElementException ex) {
            assertEquals("empty tree", ex.getMessage());
        }
    }

    /**
     * Tests the average of a non-empty tree is computed as expected.
     */
    @Test
    public void testAverageElement() {
        assertEquals(25, bst.averageElement());
    }

    /**
     * Tests the average of an empty tree is computed as expected.
     */
    @Test
    public void testAverageElementForEmptyTree() {
        IntBinarySearchTree empty = new IntBinarySearchTree();
        try {
            int average = empty.averageElement();
            fail("Test failure with empty tree: average=" + average);
        } catch (NoSuchElementException ex) {
            assertEquals("empty tree", ex.getMessage());
        }
    }

    /**
     * Tests the minimum of a non-empty tree is computed as expected.
     */
    @Test
    public void testMinimumElement() {
        assertEquals(10, bst.minimumElement());
    }

    /**
     * Tests the minimum of a non-empty tree is computed as expected.
     */
    @Test
    public void testMinimumElementForEmptyTree() {
        IntBinarySearchTree empty = new IntBinarySearchTree();
        try {
            int minimum = empty.minimumElement();
            fail("Test failure with empty tree: minimum=" + minimum);
        } catch (NoSuchElementException ex) {
            assertEquals("empty tree", ex.getMessage());
        }
    }

    /**
     * Tests the depth of a non-empty tree is computed as expected.
     */
    @Test
    public void testDepth() {
        assertEquals(3, bst.depth());
    }

    /**
     * Tests the depth of an empty tree is computed as expected.
     */
    @Test
    public void testDepthForEmptyTree() {
        IntBinarySearchTree empty = new IntBinarySearchTree();
        assertEquals(0, empty.depth());
    }

    /**
     * Tests that a non-empty tree is equal to itself.
     */
    @Test
    public void testEqualsWithSelf() {
        assertEquals(bst, bst);
    }

    /**
     * Tests that a non-empty tree is equal to a copy of itself.
     */
    @Test
    public void testEqualsWithCopy() {
        IntBinarySearchTree copy = new IntBinarySearchTree();
        copy.addRecursive(30);
        copy.addRecursive(10);
        copy.addRecursive(40);
        copy.addRecursive(20);

        assertEquals(bst, copy);
    }

    /**
     * Tests that a non-empty tree isn't equal to a different tree.
     */
    @Test
    public void testEqualsWithDifferent() {
        IntBinarySearchTree other = new IntBinarySearchTree();
        other.addRecursive(10);
        other.addRecursive(30);
        other.addRecursive(20);
        other.addRecursive(40);

        assertNotEquals(bst, other);
    }

    /**
     * Tests the length of a non-empty tree is computed as expected.
     */
    @Test
    public void testSize() {
        assertEquals(4, bst.size());
    }

    /**
     * Tests the size of an empty tree is computed as expected.
     */
    @Test
    public void testSizeForEmptyTree() {
        IntBinarySearchTree empty = new IntBinarySearchTree();
        assertEquals(0, empty.size());
    }

    /**
     * Tests the sum of a non-empty tree is computed as expected.
     */
    @Test
    public void testSumElements() {
        assertEquals(100, bst.sumElements());
    }

    /**
     * Tests the sum of an empty tree is computed as expected.
     */
    @Test
    public void testSumElementsForEmptyTree() {
        IntBinarySearchTree empty = new IntBinarySearchTree();
        assertEquals(0, empty.sumElements());
    }

    /**
     * Tests the maximum of a non-empty tree is computed as expected.
     */
    @Test
    public void testMaximumElement() {
        assertEquals(40, bst.maximumRecursive());
    }

    /**
     * Tests the maximum of an empty tree is computed as expected.
     */
    @Test
    public void testMaximumElementForEmptyTree() {
        IntBinarySearchTree empty = new IntBinarySearchTree();

        try {
            int max = empty.maximumRecursive();
            fail("Test failure with empty tree: max=" + max);
        } catch (NoSuchElementException ex) {
            assertEquals("empty tree", ex.getMessage());
        }
    }

    /**
     * Tests a non-empty tree has the expected string representation.
     */
    @Test
    public void testToString() {
        assertEquals("[10, 20, 30, 40]", bst.toString());
    }

    /**
     * Tests an empty tree has the expected string representation.
     */
    @Test
    public void testToStringForEmptyTree() {
        IntBinarySearchTree empty = new IntBinarySearchTree();
        assertEquals("[]", empty.toString());
    }

    /**
     * Tests searching for a valid value in a non-empty tree.
     */
    @Test
    public void testContains() {
        assertTrue(bst.containsRecursive(10));
    }

    /**
     * Tests searching for an invalid value in a non-empty tree.
     */
    @Test
    public void testContainsInvalidValue() {
        assertFalse(bst.containsRecursive(5));
    }

    /**
     * Tests searching in an empty tree.
     */
    @Test
    public void testContainsForEmptyTree() {
        IntBinarySearchTree empty = new IntBinarySearchTree();
        assertFalse(empty.containsRecursive(5));
    }

}