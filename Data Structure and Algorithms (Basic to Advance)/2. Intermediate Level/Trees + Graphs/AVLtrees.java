import java.util.*;

public class AVLTrees {
    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        return root.height;
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root; // Since duplicate keys are not allowed
        }

        // Update the root height
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // Get the balance factor of root
        int balFact = getBalance(root);

        // LL case
        if (balFact > 1 && key < root.left.data) {
            return rightRotN(root);
        }

        // RR case
        if (balFact < -1 && key > root.right.data) {
            return leftRotN(root);
        }

        // LR case
        if (balFact > 1 && key > root.left.data) {
            root.left = leftRotN(root.left);
            return rightRotN(root);
        }

        // RL case
        if (balFact < -1 && key < root.right.data) {
            root.right = rightRotN(root.right);
            return leftRotN(root);
        }

        return root; // return it if the AVL tree is balanced
    }

    public static int getBalance(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    public static Node leftRotN(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // rotations
        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // return the new node
        return y;
    }

    public static Node rightRotN(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        /*
         * 30
         * / \
         * 20 40
         * / \ \
         * 10 25 50
         */

        preOrder(root);
    }
}
