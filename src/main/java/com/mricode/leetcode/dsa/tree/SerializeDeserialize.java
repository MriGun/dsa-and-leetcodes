package com.mricode.leetcode.dsa.tree;

import com.mricode.leetcode.dsa.tree.structure.TreeNode;

import java.util.*;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
public class SerializeDeserialize {

    public List<String> serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        serializeHelper(root, list);
        return list;
    }

    private void serializeHelper(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("null");
            return;
        }

        list.add(String.valueOf(node.val));

        serializeHelper(node.left, list);
        serializeHelper(node.right, list);
    }

    public TreeNode deserilize(List<String> list) {
        Collections.reverse(list);
        TreeNode node = deserilizeHelper(list);
        return node;
    }

    private TreeNode deserilizeHelper(List<String> list) {
        String val = list.remove(list.size() - 1);

        if (val.charAt(0) == 'n') {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left = deserilizeHelper(list);
        node.right = deserilizeHelper(list);

        return node;


    }

    public static String serialize2(TreeNode root) {
         String serString = "";
         serString = serializeHelper2(root, serString);
         return serString;
    }


    private static String serializeHelper2(TreeNode node, String str) {
        if (node == null) {
            str = str + "n,";
            return str;
        }

        str = str + String.valueOf(node.val) + ",";

        str = serializeHelper2(node.left, str);
        str = serializeHelper2(node.right, str);

        return str;
    }

    public static TreeNode deserialize2(String data) {
        if (data == null) {
            return null;
        }
        String[] vals = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(vals));
        int[] index = new int[1];
        TreeNode node =  deserializeHelper2(vals, index);
        TreeNode newNode = deserializeHelper3(queue);

        int indexL = 0;
        TreeNode newNodeT = deserializeHelper4(vals, indexL);
        return newNodeT;
    }

    public static TreeNode deserializeHelper3(Queue<String> queue) {
        String val = queue.poll();

        if (val.equals("n")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper3(queue);
        node.right = deserializeHelper3(queue);

        return node;
    }

    public static TreeNode deserializeHelper2(String[] vals, int[] index) {

        if (index[0] >= vals.length) {
            return null;
        }

        String strVal = vals[index[0]];
        index[0]++;

        if (strVal.equals("n")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(strVal));

        node.left = deserializeHelper2(vals, index);
        node.right = deserializeHelper2(vals, index);
        return node;
    }

    public static TreeNode deserializeHelper4(String[] vals, int indexL) {

        if (indexL >= vals.length) {
            return null;
        }

        String strVal = vals[indexL];
        indexL++;

        if (strVal.equals("n")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(strVal));

        node.left = deserializeHelper4(vals, indexL);
        node.right = deserializeHelper4(vals, indexL);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = null;
        root.left.right = null;

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        root.right.left.left = null;
        root.right.left.right = null;

        root.right.right.left = null;
        root.right.right.right = null;

        String str = serialize2(root);
        System.out.println(str);

        deserialize2(str);
    }

}
