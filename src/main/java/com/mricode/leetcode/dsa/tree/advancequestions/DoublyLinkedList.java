package com.mricode.leetcode.dsa.tree.advancequestions;

import com.mricode.leetcode.dsa.tree.structure.TreeNode;
import org.apache.naming.TransactionRef;

public class DoublyLinkedList {

    LLNode head;
    LLNode tail;

    public TreeNode convert(TreeNode root) {

        if (root == null) {
            return null;
        }
        convertHelper(root);
        return root;

    }

    private void convertHelper(TreeNode node) {

        if (node == null) {
            return;
        }

        convertHelper(node.left);

        LLNode newNode = new LLNode(node.val);

        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
            newNode.prev = tail;
        }

        convertHelper(node.right);
    }


    private class LLNode {
        int val;
        LLNode next;
        LLNode prev;

        public LLNode(int val) {
            this.val = val;
        }

        public LLNode(int val,LLNode next, LLNode prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

}
