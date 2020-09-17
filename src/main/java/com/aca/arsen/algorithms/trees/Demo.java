package com.aca.arsen.algorithms.trees;

public class Demo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.root = new Node(5);
        binaryTree.root.left = new Node(3);
        binaryTree.root.right = new Node(10);

        binaryTree.root.left.left = new Node(1);
        binaryTree.root.left.right = new Node(4);
        binaryTree.root.right.left = new Node(6);
        binaryTree.root.right.right = new Node(12);
        binaryTree.root.right.right.right = new Node(13);
        binaryTree.root.right.right.right.right = new Node(14);

        System.out.println(binaryTree.isBalanced(binaryTree.root));
        System.out.println(binaryTree.isCompleted(binaryTree.root));
        System.out.println(binaryTree.isFull(binaryTree.root));
        System.out.println(binaryTree.isPerfect(binaryTree.root));
        System.out.println(binaryTree.height(binaryTree.root.right.right.right.right));
        System.out.println(binaryTree.findDepth(binaryTree.root, 14,0));
        System.out.println(binaryTree.sumOfIntegers(binaryTree.root));
        System.out.println(binaryTree.findDepth(binaryTree.root, 14,0));
    }
}
