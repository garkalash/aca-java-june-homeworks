package com.aca.naresilanyan.algorithmsHomework;

public class AlgorithmsTesting {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(5);
        binaryTree.root.left = new Node(4);
        binaryTree.root.left.left = new Node(3);
        binaryTree.root.left.left.left = new Node(2);
        binaryTree.root.right = new Node(7);
        binaryTree.root.right.left = new Node(6);
        binaryTree.root.right.right = new Node(10);
        binaryTree.root.right.right.right = new Node(12);
        binaryTree.root.right.right.right.right = new Node(13);

//        System.out.println( binaryTree.isBalanced(binaryTree.root));

//        System.out.println(binaryTree.sumOfKeys(binaryTree.root));
//        System.out.println(binaryTree.depthByKey(13,binaryTree.root,0));




    }
}
