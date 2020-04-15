package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

class Node<Type>
{
    Type key;
    Node<Type> left, right;

    public Node(Type item)
    {
        key = item;
        left = right = null;
    }
}

class BinaryTree<Type> {
    Node<Type> root;

    BinaryTree(){
        root = null;

    }

    /* Given a binary tree, print its nodes according to the
      "bottom-up" postorder traversal. */
    void printPostorder(Node<Type> node)
    {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.key + " ");
    }

    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node<Type> node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node<Type> node)
    {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.key + " ");

        /* then recur on left sutree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }

    // Wrappers over above recursive functions
    void printPostorder()  {     printPostorder(root);  }
    void printInorder()    {     printInorder(root);   }
    void printPreorder()   {     printPreorder(root);  }

    /*
    A full binary tree is a tree in which every node other than the leaves has two children.
     */
    boolean isTreeFull(Node<Type> node)
    {
        if(node == null)
            return true;

        if(node.left == null && node.right == null )
            return true;

        if((node.left!=null) && (node.right!=null))
            return (isTreeFull(node.left) && isTreeFull(node.right));

        return false;
    }

     int getCount(Node root)
    {
        if (root == null)
            return 0;

        return 1 + getCount(root.left) + getCount(root.right);
    }

    /*
    A complete binary tree is a binary tree in which every level, expect possibly the last is completely filled, and
    all nodes are as far left as possible
     */
    boolean isComplete(Node<Type> root, int index, int number_nodes)
    {
        if (root == null)
            return true;

        if (index >= number_nodes)
            return false;

        return (isComplete(root.left, 2 * index + 1, number_nodes)
                && isComplete(root.right, 2 * index + 2, number_nodes));

    }

    /*
    A tree where for each parent node, there is only one associated chile node. Is unbalanced.
     */
    boolean isDegenerate(Node<Type> root) {
        if (root.left != null) {
            if (root.right != null) {
                return false; //two children
            } else {
                return isDegenerate(root.left);
            }
        } else {
            if (root.right != null) {
                return isDegenerate(root.right);
            } else {
                return true;
            }
        }
    }

    // Returns depth of leftmost leaf.
    int findADepth(Node<Type> node)
    {
        int depth = 0;
        while (node != null)
        {
            depth++;
            node = node.left;
        }
        return depth;
    }

/*
A perfect binary tree is a binary tree in which all interior nodes have two children and all leaves have the same depth.
 */
    boolean isPerfectRecursion(Node<Type> root, int depth, int level)
    {
        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return (depth == level+1);

        if (root.left == null || root.right == null)
            return false;

        return isPerfectRecursion(root.left, depth, level+1) && isPerfectRecursion(root.right, depth, level+1);
    }

     boolean isPerfectWrapper(Node<Type> root)
    {
        int d = findADepth(root);
        return isPerfectRecursion(root, d, 0);
    }

    /*
    A tree where no lead is much further away from the root than any other leaf.
     */
    boolean isBalanced(Node<Type> node)
    {
        int leftSubTreeHeight;

        int rightSubTreeHeight;

        /* If tree is empty then return true */
        if (node == null)
            return true;

        /* Get the height of left and right sub trees */
        leftSubTreeHeight = height(node.left);
        rightSubTreeHeight = height(node.right);

        return Math.abs(leftSubTreeHeight - rightSubTreeHeight) <= 1
                && isBalanced(node.left)
                && isBalanced(node.right);

        /* If we reach here then tree is not height-balanced */
    }


    int height(Node<Type> node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;

        /* If tree is not empty then height = 1 + max of left
         height and right heights */
        return 1 + Math.max(height(node.left), height(node.right));
    }

    void insert(Node temp, Type key)
    {
        Queue<Node<Type>> q = new LinkedList<>();
        q.add(temp);

        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new Node<>(key);
                break;
            } else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new Node<>(key);
                break;
            } else
                q.add(temp.right);
        }
    }

    public BinaryTree<String> randomBinaryTreeOfNames (List<String> listOfNames){
        BinaryTree<String> treeOfNames = new BinaryTree<>();
        Random random = new Random();

        treeOfNames.root = new Node<>(listOfNames.get(0));

        //Starting i at 1 because index 0 is root, already added.
        for(int i = 1; i < listOfNames.size(); i++){
            int num = random.nextInt(2); // 0 heads 1 tales
            if(num == 0){
                if(treeOfNames.root.left == null){
                    treeOfNames.root.left = new Node<>(listOfNames.get(i));
                }else{
                    insert(treeOfNames.root.left, (Type) listOfNames.get(i));
                }
            }else{
                if(treeOfNames.root.right == null){
                    treeOfNames.root.right = new Node<>(listOfNames.get(i));
                }else{
                    insert(treeOfNames.root.right, (Type) listOfNames.get(i));
                }
            }
        }
        return treeOfNames;
    }
}
