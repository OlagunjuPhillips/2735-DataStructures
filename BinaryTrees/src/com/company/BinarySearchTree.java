package com.company;

import java.lang.reflect.Type;
import java.util.*;
import java.lang.String;

/*
Thanks to GeeksForGeeks for their template tree code
 */

public class BinarySearchTree {
    class Node<Type>{
        Type key;
        Node<Type> left, right;

        public Node(Type node){
            key = node;
            left = right = null;
        }

    }

    Node root;


    BinarySearchTree(){
        root = null;
    }

    public Node insertRec(Node<Integer> root, int node){
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

    public void postorder(Node node){
        if(node != null){
            postorder(node.left);

            postorder(node.right);

            System.out.print(node.key + " ");
        }
    }

    public void printPostorder(){
        postorder(this.root);
    }

    public int sumInt(Node<Integer> node){
        if(node == null){
            return 0;
        }
        return node.key + sumInt(node.left) + sumInt(node.right);
    }

    public int sum(){
        return sumInt(this.root);
    }

    public int searchKey(Node<Integer> node, int findKey){
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
        largest = (int) root.key;
        return largest;
    }

    public ArrayList<Integer> values(Node<Integer> node, ArrayList<Integer> value){
        if(node != null){
            values(node.right, value);

            value.add(node.key);

            values(node.left, value);
        }
        return value;
    }

    public int nthLargest(int n){
        ArrayList<Integer> value = new ArrayList<>();
        return (int) values(root, value).get(n - 1);
    }



    public Node<String> insertStr(Node<String> root, String node){
        if(root == null){
            root = new Node(node);
            return root;
        }

        if(root.key.compareTo(node) < 0){
            root.left = insertStr(root.left, node);
        } else if(root.key.compareTo(node) > 0){
            root.right = insertStr(root.right, node);
        }
        return root;
    }

    public void insert(String key){
        root = insertStr(root, key);
    }


    public boolean search(Node<String> node, String findKey){
        if (node.key.equals(findKey)){
            return true;
        }
        if(node.key.compareTo(findKey) > 0){
            return search(node.left, findKey);
        }
        return search(node.right, findKey);
    }


}