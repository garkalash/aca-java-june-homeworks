package com.aca.armine.algoritm.binarytree;

public class Demo {


    public static void main(String[] args) {
        Node root = new Node(10);
        root.setLeft(new Node(6));
        root.setRight(new Node(15));
        root.getLeft().setLeft(new Node(5));
        root.getRight().setRight(new Node(11));
        root.getLeft().getLeft().setLeft(new Node(9));

        Node root1 = new Node(10);
        root1.setLeft(new Node(6));
        root1.setRight(new Node(15));
        root1.getLeft().setLeft(new Node(5));
        root1.getLeft().setRight(new Node(8));
        root1.getRight().setLeft(new Node(11));


        Ex1 ex1 = new Ex1();

        System.out.println(ex1.isBalanced(root));

        Ex2_3_4 ex2 = new Ex2_3_4();
        ex2.isTreeComplete(root);
        System.out.println(ex2.isTreeComplete(root));

        System.out.println(ex2.isTreeFull(root));

        System.out.println(ex2.isTreePerfect(root));
        Ex5 ex5 = new Ex5();

        if (ex5.getNodDepth(8, root).isPresent()) {
            System.out.println(ex5.getNodDepth(8, root).get());
        }
        Ex_6_7_8 ex678 = new Ex_6_7_8();
        System.out.println(ex678.getsNodesKeySum(root));
        System.out.println(ex678.areBinaryTreesEqual(root, root1));
        System.out.println(ex678.getBSTDepth(15, root, 0));


    }
}
