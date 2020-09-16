package com.aca.armine.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Ex2 {

    public boolean isComplete(Node root) {

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
}
