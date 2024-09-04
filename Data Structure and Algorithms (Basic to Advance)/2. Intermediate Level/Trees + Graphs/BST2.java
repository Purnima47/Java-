import java.util.ArrayList;

public class BST2 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static Node createMirror(Node root) {
        if (root == null) {
            return null;
        }

        Node leftSubTree = createMirror(root.left);
        Node rightSubTree = createMirror(root.right);

        root.left = rightSubTree;
        root.right = leftSubTree;

        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node createBST(int arr[], int si, int ei) {
        if (si > ei) {
            return null;
        }
        int mid = (si + ei) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, si, mid - 1);
        root.right = createBST(arr, mid + 1, ei);

        return root;
    }

    public static void getInOrder(Node root, ArrayList<Integer> inOrder) {
        if (root == null) {
            return;
        }

        getInOrder(root.left, inOrder);
        inOrder.add(root.data);
        getInOrder(root.right, inOrder);
    }

    public static Node createBST2(ArrayList<Integer> inOrder, int si, int ei) {
        if (si > ei) {
            return null;
        }
        int mid = (si + ei) / 2;
        Node root = new Node(inOrder.get(mid));
        root.left = createBST2(inOrder, si, mid - 1);
        root.right = createBST2(inOrder, mid + 1, ei);

        return root;
    }

    public static Node balanceBST(Node root) {
        // IN-ORDER SEQUENCE:
        ArrayList<Integer> inOrder = new ArrayList<>();
        getInOrder(root, inOrder);

        // Sorted InOrder (Balanced BST)
        root = createBST2(inOrder, 0, inOrder.size() - 1);

        return root;
    }

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;

    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(Math.min(leftInfo.min, rightInfo.min), root.data);
        int max = Math.max(Math.max(leftInfo.max, rightInfo.max), root.data);

        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }

        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    public static Node mergeBSTs(Node root1, Node root2) {
        // O(n+m) :LINEAR TIME
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInOrder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInOrder(root2, arr2);

        // merge
        int i = 0, j = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                temp.add(arr1.get(i));
                i++;
            } else {
                temp.add(arr2.get(j));
                j++;
            }
        }

        while (i < arr1.size()) {
            temp.add(arr1.get(i));
            i++;
        }

        while (j < arr2.size()) {
            temp.add(arr2.get(j));
            j++;
        }

        // create a BST
        return createBST2(temp, 0, temp.size() - 1);

    }

    public static void main(String[] args) {
        // Node root = new Node(8);
        // root.left = new Node(5);
        // root.right = new Node(10);
        // root.left.left = new Node(3);
        // root.left.right = new Node(6);
        // root.right.right = new Node(11);

        // root = createMirror(root);
        // preOrder(root);

        // int arr[]={3,5,6,8,10,11,12};

        // Node root=createBST(arr, 0, arr.length-1);
        // preOrder(root);

        // Node root = new Node(8);
        // root.left = new Node(6);
        // root.right = new Node(10);
        // root.left.left = new Node(5);
        // root.left.left.left = new Node(3);
        // root.right.right = new Node(11);
        // root.right.right.right = new Node(12);

        // root=balanceBST(root);
        // preOrder(root);

        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.right = new Node(60);
        // root.left.left = new Node(5);
        // root.left.right = new Node(20);
        // root.right.left = new Node(45);
        // root.right.right = new Node(70);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(80);

        // Info info = largestBST(root);
        // System.out.println("Largest BST size = " + maxBST);
        // System.out.println(maxBST);

        // 2
        // / \
        // 1 4 (BST1)

        // 9
        // / \
        // 3 12 (BST2)

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        /*
         * 3
         * / \
         * 1 9
         * \ / \
         * 2 4 12
         * 
         */

        Node root = mergeBSTs(root1, root2);
        preOrder(root);

    }
}
