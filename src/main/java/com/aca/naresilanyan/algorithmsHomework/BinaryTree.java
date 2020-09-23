package com.aca.naresilanyan.algorithmsHomework;

public class BinaryTree {
    Node root;

//    EX. 1


    public  Boolean isBalanced(Node root){
        if (root == null) return true;
        Integer a = height(root.left);
        Integer b = height(root.right);

        if(a-b<=1 && a-b >= -1  && isBalanced(root.left) && isBalanced(root.right)) return true;
        return false;

    }



//    EX. 3

    public Boolean isFull(Node root){
        if (root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(root.left != null && root.right != null) return isFull(root.left) && isFull(root.right);
        return false;
    }

//    Ex. 4

    public Boolean isPerfect(Node root){
        if (root == null) return true;
        if(isFull(root) && height(root.left) == height(root)-1 && height(root.right) == height(root)-1)
            return isPerfect(root.left) && isPerfect(root.right);
        return false;

    }

//    Ex. 5


    public Integer depthByKey(Integer key, Node root, Integer step){
        if(root == null) return 0;

        if(root.key == key)return step;

        Integer depth = depthByKey(key,root.left, step+1);

        if (depth == 0){

            depth = depthByKey(key,root.right, step+1);
        }

        return depth;

    }

//    Ex. 6

    public Integer sumOfKeys(Node root){
        Integer leftSum =0;
        Integer rightSum =0;


        if (root == null){
          return 0;
        }
        else {

            if(root.left != null) {
                leftSum = sumOfKeys(root.left);
            }
            if(root.right != null) {
                rightSum = sumOfKeys(root.right);
            }


        }

        return root.key + leftSum + rightSum;


    }








    public Integer nodesCount(Node root){
        if(root == null) return 0;
        return 1+ nodesCount(root.left) + nodesCount(root.right);
    }
    public Boolean existsLeftChild(Node root){
        if(root == null) return false;
        if(root.left == null){
            return false;
        }else return true;
    }
    public Boolean existsRightChild(Node root){
        if(root == null) return false;
        if(root.right == null){
            return false;
        }else return true;
    }


    public Integer height(Node node){
        if(node == null) return 0;

        return 1+ max(height(node.right), height(node.left));
    }

    public Integer max(Integer x, Integer y ){

        return x > y ? x : y;
    }
}
