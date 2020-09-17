package com.aca.arsen.algorithms.trees;

public class BinaryTree {
    Node root;


    int max(int a, int b) {
        return a > b ? a : b;
    }

    int height(Node node) {
        if (node == null) return 0;
        return max(height(node.left), height(node.right)) + 1;
    }

    //1.function to know, is binary tree balanced or not
    boolean isBalanced(Node node) {
        if (node == null) return true;
        int heightRight = height(node.right);
        int heightLeft = height(node.left);
        return heightLeft - heightRight <= 1 && heightLeft - heightRight >= -1
                && isBalanced(node.right) && isBalanced(node.left);
    }

    //2.function to know, is the binary tree completed or not
    boolean isCompleted(Node node) {
        if (node == null) return true;
        if (node.left == null && node.right != null) return false;
        return isCompleted(node.left) && isCompleted(node.right);

    }

    //3. function to know is the binary tree full or not
    boolean isFull(Node node) {
        if (node == null) return true;
        if (node.left == null && node.right == null) return true;
        if (node.left != null && node.right != null)
            return isFull(node.left) && isFull(node.right);
        return false;
    }

    //4. function to know is binary tree perfect or not
    boolean isPerfect(Node node) {
        return isCompleted(node) && isFull(node);
    }

    //5. Pass key and find the depth of the node in the binary tree
    int findDepth(Node node, int key, int depth) {
        if (node == null)
            return 0;
        if (key != node.key) {
            int tmpDepth = findDepth(node.left, key, depth + 1);
            if (tmpDepth != 0) return tmpDepth;
            else return findDepth(node.right, key, depth + 1);
        }
        return depth;
    }

    //6. Count the sum of integers located in the binary tree.
    int sumOfIntegers(Node node) {
        if (node == null) return 0;
        return node.key + sumOfIntegers(node.left) + sumOfIntegers(node.right);
    }

    //7. Function, are two binary trees equal
    boolean isEqual(Node node1, Node node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 != null && node2 != null)
            return node1.key == node2.key && isEqual(node1.left, node2.left) && isEqual(node1.right, node2.right);
        return false;
    }

    //8. Find the depth of the key in the BST
    int depthOfBST(Node node, int key, int depth) {
        if (node == null) return 0;
        if (node.key > node.left.key && node.key < node.right.key) {
            if (key > node.key) return depthOfBST(node.right, key, depth + 1);
            else if (key < node.key) return depthOfBST(node.left, key, depth + 1);
            else return depth;
        }
        return 0;
    }

}
