package com.aca.armine.algoritm.binarytree;

import com.google.gson.internal.$Gson$Preconditions;

import java.util.ArrayDeque;
import java.util.Queue;

public class Ex2_3_4 {

    //ex2
    public boolean isTreeComplete(Node root) {

        if (root == null) {
            return false;
        }

        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(root);
        Node currentNode;
        boolean isNodeNonFull = false;

        while (!nodes.isEmpty()) {
            currentNode = nodes.poll();

            if (isNodeNonFull && (currentNode.getLeft() != null || currentNode.getRight() != null)) {
                return false;
            }

            if (currentNode.getLeft() == null && currentNode.getRight() != null) {
                return false;
            }

            if (currentNode.getLeft() != null) {
                nodes.add(currentNode.getLeft());
            } else {
                isNodeNonFull = true;
            }

            if (currentNode.getRight() != null) {
                nodes.add(currentNode.getRight());
            } else {
                isNodeNonFull = true;
            }
        }

        return true;
    }

    //ex3
    public boolean isTreeFull(Node root) {
        if (root == null) {
            return true;
        }
        if ((root.getRight() == null && root.getLeft() == null)) {
            return true;
        }
        if (root.getLeft() != null && root.getRight() != null) {
            return isTreeFull(root.getLeft()) && isTreeFull(root.getRight());
        }

        return false;
    }

    //ex4
    public boolean isTreePerfect(Node root) {
        return isTreeComplete(root) && isTreeFull(root);
    }


}
