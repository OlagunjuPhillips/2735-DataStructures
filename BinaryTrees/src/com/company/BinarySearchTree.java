package com.company;

import java.util.*;
import java.lang.String;

public class BinarySearchTree {
    class Node{
        int key;
        Node left, right;

        public Node(int node){
            key = node;
            left = right = null;
        }

    }

    Node root;

    BinarySearchTree(){
        root = null;
    }

    public Node insertRec(Node root, int node){
        if(root == null){
            root = new Node(node);
            return root;
        }

        if(node < root.key){
            root.left = insertRec(root.left, node);
        }else if(node > root.key){
            root.right = insertRec(root.right, node);
        }
        return root;
    }

    public void insert(int key){
        root = insertRec(root, key);
    }

    public void inorder(Node node){
        if(node != null){
            inorder(node.left);

            System.out.print(node.key + " ");

            inorder(node.right);
        }
    }

    public void printInorder(){
        inorder(root);
    }

    public int sumInt(Node node){
        if(node == null){
            return 0;
        }
        return node.key + sumInt(node.left) + sumInt(node.right);
    }

    public int sum(){
        return sumInt(this.root);
    }

    public int searchKey(Node node, int findKey){
        if (node == null || node.key == findKey){
            return node.key;
        }
        if(findKey < node.key){
            return searchKey(node.left, findKey);
        }
        return searchKey(node.right, findKey);
    }

    public int search(int findKey){
        return  searchKey(this.root, findKey);
    }

    public int largest(){
        int largest = 0;
        while(root.right != null){
            root = root.right;
        }
        largest = root.key;
        return largest;
    }

    public ArrayList<Integer> values(Node node, ArrayList<Integer> value){
        if(node != null){
            values(node.right, value);

            value.add(node.key);

            values(node.left, value);
        }
        return value;
    }

    public int nthLargest(int n){
        ArrayList<Integer> value = new ArrayList<>();
        return values(root, value).get(n - 1);
    }


}