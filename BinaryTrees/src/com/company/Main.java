package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        System.out.println("Joshua Lewis Binary Tree Assignment \n");

        System.out.println("TODO 1 Creating a Binary Tree");

        BinaryTree<Integer> tree1 = new BinaryTree<>();

        /*create root*/
        tree1.root = new Node<>(1);

        /* following is the tree after above statement

              1
            /   \
          null  null     */

        tree1.root.left = new Node<>(2);
        tree1.root.right = new Node<>(3);

        /* 2 and 3 become left and right children of 1
               1
             /   \
            2      3
          /    \    /  \
        null null null null  */


        tree1.root.left.left = new Node<>(4);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */

        System.out.println("Preorder traversal of binary tree1 is: ");
        tree1.printPreorder();
        System.out.println("\nComplete \n");

        BinaryTree<Integer> tree2 = new BinaryTree<>();
        tree2.root = new Node<>(1);
        tree2.root.left = new Node<>(2);
        tree2.root.right = new Node<>(3);
        tree2.root.left.left = new Node<>(4);
        tree2.root.left.right = new Node<>(5);
        tree2.root.right.left = new Node<>(6);
        tree2.root.right.right = new Node<>(7);
        tree2.root.left.left.left = new Node<>(8);
        tree2.root.left.left.right = new Node<>(9);
        tree2.root.left.right.left = new Node<>(10);

        System.out.println("Inorder traversal of binary tree2 is: ");
        tree2.printInorder();
        System.out.println("\nComplete \n");

        BinaryTree<String> tree3 = new BinaryTree<>();

        tree3.root = new Node<>("apple");
        tree3.root.left = new Node<>("banana");
        tree3.root.right = new Node<>("cherry");
        tree3.root.left.left = new Node<>("dates");
        tree3.root.left.right = new Node<>("elderberry");

        System.out.println("Postorder traversal of binary tree3 is: ");
        tree3.printPostorder();
        System.out.println("\nComplete \n");

        System.out.println("========================");


        System.out.println("Checking if Tree 1 is Full");
        if(tree1.isTreeFull(tree1.root)){
            System.out.println("Tree 1 is Full \n");
        }else{
            System.out.println("Tree 1 is Not Full \n");
        }

        System.out.println("Checking if Tree 1 is Complete");
        if(tree1.isComplete(tree1.root, 0, tree1.getCount(tree1.root))){
            System.out.println("Tree 1 is Complete \n");
        }else{
            System.out.println("Tree 1 is Not Complete \n");
        }

        System.out.println("Checking if Tree 1 is Degenerate");
        if(tree1.isDegenerate(tree1.root)){
            System.out.println("Tree 1 is Degenerate \n");
        }else{
            System.out.println("Tree 1 is Not Degenerate \n");
        }

        System.out.println("Checking if Tree 1 is Perfect");
        if(tree1.isPerfectWrapper(tree1.root)){
            System.out.println("Tree 1 is Perfect \n");
        }else{
            System.out.println("Tree 1 is Not Perfect \n");
        }

        System.out.println("Checking if Tree 1 is Balanced");
        if(tree1.isBalanced(tree1.root)){
            System.out.println("Tree 1 is Balanced \n");
        }else{
            System.out.println("Tree 1 is Not Balanced \n");
        }

        System.out.println("========================");

        System.out.println("Checking if Tree 2 is Full");
        if(tree2.isTreeFull(tree2.root)){
            System.out.println("Tree 2 is Full \n");
        }else{
            System.out.println("Tree 2 is Not Full \n");
        }

        System.out.println("Checking if Tree 2 is Complete");
        if(tree2.isComplete(tree1.root, 0, tree2.getCount(tree2.root))){
            System.out.println("Tree 2 is Complete \n");
        }else{
            System.out.println("Tree 2 is Not Complete \n");
        }

        System.out.println("Checking if Tree 2 is Degenerate");
        if(tree2.isDegenerate(tree2.root)){
            System.out.println("Tree 2 is Degenerate \n");
        }else{
            System.out.println("Tree 2 is Not Degenerate \n");
        }

        System.out.println("Checking if Tree 2 is Perfect");
        if(tree2.isPerfectWrapper(tree2.root)){
            System.out.println("Tree 2 is Perfect \n");
        }else{
            System.out.println("Tree 2 is Not Perfect \n");
        }

        System.out.println("Checking if Tree 2 is Balanced");
        if(tree2.isBalanced(tree2.root)){
            System.out.println("Tree 2 is Balanced \n");
        }else{
            System.out.println("Tree 2 is Not Balanced \n");
        }

        System.out.println("========================");

        System.out.println("Checking if Tree 3 is Full");
        if(tree3.isTreeFull(tree3.root)){
            System.out.println("Tree 3 is Full \n");
        }else{
            System.out.println("Tree 3 is Not Full \n");
        }

        System.out.println("Checking if Tree 3 is Complete");
        if(tree3.isComplete(tree3.root, 0, tree3.getCount(tree3.root))){
            System.out.println("Tree 3 is Complete \n");
        }else{
            System.out.println("Tree 3 is Not Complete \n");
        }

        System.out.println("Checking if Tree 3 is Degenerate");
        if(tree3.isDegenerate(tree3.root)){
            System.out.println("Tree 3 is Degenerate \n");
        }else{
            System.out.println("Tree 3 is Not Degenerate \n");
        }

        System.out.println("Checking if Tree 3 is Perfect");
        if(tree3.isPerfectWrapper(tree3.root)){
            System.out.println("Tree 3 is Perfect \n");
        }else{
            System.out.println("Tree 3 is Not Perfect \n");
        }

        System.out.println("Checking if Tree 3 is Balanced");
        if(tree3.isBalanced(tree3.root)){
            System.out.println("Tree 3 is Balanced \n");
        }else{
            System.out.println("Tree 3 is Not Balanced \n");
        }

        System.out.println("Random Name Binary Tree");
        BinaryTree<String> randomNameT = new BinaryTree<>();

        BinaryTree<String> randomNameTree = randomNameT.randomBinaryTreeOfNames(getNames());

        System.out.println("Preorder traversal of binary tree is: ");
        randomNameTree.printPreorder();
        System.out.println("\nComplete \n");

        System.out.println("Inorder traversal of binary tree is: ");
        randomNameTree.printInorder();
        System.out.println("\nComplete \n");

        System.out.println("Postorder traversal of binary tree is: ");
        randomNameTree.printPostorder();
        System.out.println("\nComplete \n");

        System.out.println("TODO 2 Creating a Binary Search Tree");

        System.out.println("=== Binary Search Program ===");
        System.out.println("Creating tree4...");
        BinarySearchTree tree4 = new BinarySearchTree();
        int[] tree = {3, 1, 2, 4};
        for(int num : tree){
            tree4.insert(num);
        }
        System.out.println("Done.");

        System.out.println("\nChecking that search method exists...");
        System.out.println(tree4.search(4));
        System.out.println("Done.");


        System.out.println("Creating tree5...");
        BinarySearchTree tree5 = new BinarySearchTree();
        int[] trees5 = {3, 1, 2, 4, 10, 8, 9, 7, 6, 5};

        for(int num : trees5){
            tree5.insert(num);
        }
        System.out.println("Done");
        System.out.println("\nChecking that sum method exists...");
        tree5.printInorder();
        System.out.println("\n"+tree5.sum());
        System.out.println("Done.");


        System.out.println("\nChecking that nth greatest value method exists...\nFind the 4th greatest value of tree5.");
        tree5.printInorder();
        System.out.println("\n"+tree5.nthLargest(4));



    }

    private static List<String> getNames(){
        return Arrays.asList("Bobby", "Diaz","John","Otto","Posty", "Gilbert","Greg","Phillips");
    }
}
