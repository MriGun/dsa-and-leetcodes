package com.mricode.leetcode.dsa.tree;

import java.util.Scanner;

public class BinaryTree {

    private Node root;

    //insert elements
    public void populate (Scanner scanner) {
        System.out.println("Enter the root node : ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want enter left of " + node.val);
        boolean left = scanner.nextBoolean();

        if (left) {
            System.out.println("Enter the value of left of " + node.val);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("Do you want enter right of " + node.val);
        boolean right = scanner.nextBoolean();

        if (right) {
            System.out.println("Enter the value of right of " + node.val);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent +  node.val);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level+1);

        if (level != 0) {
            for (int i = 0; i < level -1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------>" + node.val);
        }
        else {
            System.out.println(node.val);
        }

        prettyDisplay(node.left, level+1);
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node node) {

        if (node == null) {
            return;
        }

        System.out.println(node.val + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {

        if (node == null) {
            return;
        }

        preOrderTraversal(node.left);
        System.out.println(node.val + " ");
        preOrderTraversal(node.right);
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node node) {

        if (node == null) {
            return;
        }

        preOrderTraversal(node.left);
        preOrderTraversal(node.right);

        System.out.println(node.val + " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(scanner);
        binaryTree.display();
        binaryTree.prettyDisplay();
    }
}
