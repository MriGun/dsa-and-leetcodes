package com.mricode.leetcode.dsa.tree;

import com.mricode.leetcode.dsa.tree.structure.Node;
import com.mricode.leetcode.dsa.tree.structure.TreeNode;

import java.util.*;

public class TreeQuestions {



    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevelList = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {

                 TreeNode currentNode = queue.poll();
                 currentLevelList.add(currentNode.val);
                 if (currentNode.left != null) {
                     queue.offer(currentNode.left);
                 }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevelList);
        }

        return result;

    }

    //https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
    //google question
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum= 0;

            for (int i = 0; i < levelSize; i++) {

                TreeNode currentNode = queue.poll();

                levelSum = levelSum + currentNode.val;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(levelSum / levelSize);
        }

        return result;
    }


    public TreeNode findSuccessor(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }

            if (currentNode.val == key) {
                break;
            }

        }
        return queue.peek();
    }

    //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

         List<List<Integer>> result = new ArrayList<>();
         if (root == null) {
             return result;
         }

         Deque<TreeNode> dequeue = new LinkedList<>();
         dequeue.offer(root);
         boolean isOppositeDirection = false;

         while (!dequeue.isEmpty()) {
             int levelSize = dequeue.size();
             List<Integer> levelValueList = new ArrayList<>(levelSize);
             for (int i = 0; i < levelSize; i++) {

                 TreeNode currentNode;
                 if (isOppositeDirection) {
                      currentNode = dequeue.pollLast();
                     if (currentNode.right != null) {
                         dequeue.offerFirst(currentNode.right);
                     }
                     if (currentNode.left != null) {
                         dequeue.offerFirst(currentNode.left);
                     }

                 }
                 else {
                     currentNode = dequeue.pollFirst();

                     if (currentNode.left != null) {
                         dequeue.offerLast(currentNode.left);
                     }
                     if (currentNode.right != null) {
                         dequeue.offerLast(currentNode.right);
                     }
                 }

                 levelValueList.add(currentNode.val);


             }
             isOppositeDirection = isOppositeDirection ? false : true;
             result.add(levelValueList);
         }
         return result;
     }


     //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
     public List<List<Integer>> levelOrderBottom(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();

         if (root == null) {
             return result;
         }

         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);

         while (!queue.isEmpty()) {
             int levelSize = queue.size();
             List<Integer> currentLevelList = new ArrayList<>(levelSize);
             for (int i = 0; i < levelSize; i++) {

                 TreeNode currentNode = queue.poll();
                 currentLevelList.add(currentNode.val);
                 if (currentNode.left != null) {
                     queue.offer(currentNode.left);
                 }

                 if (currentNode.right != null) {
                     queue.offer(currentNode.right);
                 }
             }
             result.add(0, currentLevelList);
         }

         return result;
     }

     //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
     public Node connect(Node root) {

        if (root == null) {
            return root;
        }

         Node leftNode = root;

        while (leftNode.left != null) {
            linkNode(leftNode);
            Node currentNode = leftNode;

            while (currentNode.next != null) {
                currentNode.right.next = currentNode.next.left;
                currentNode = currentNode.next;
                linkNode(currentNode);

            }
            leftNode = leftNode.left;

        }
        return root;

     }

     private Node linkNode(Node node) {
        if (node.left != null) {
            node.left.next = node.right;
        }
        return node;
     }

     //https://leetcode.com/problems/binary-tree-right-side-view/description/
     public List<Integer> rightSideView(TreeNode root) {
         List<Integer> result = new ArrayList<>();

         if (root == null) {
             return result;
         }

         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);

         while (!queue.isEmpty()) {
             int levelSize = queue.size();
             List<Integer> currentLevelList = new ArrayList<>(levelSize);
             for (int i = 0; i < levelSize; i++) {

                 TreeNode currentNode = queue.poll();
                 currentLevelList.add(currentNode.val);
                 if (currentNode.left != null) {
                     queue.offer(currentNode.left);
                 }

                 if (currentNode.right != null) {
                     queue.offer(currentNode.right);
                 }
             }
             result.add(currentLevelList.get(levelSize-1));
         }

         return result;
     }
}
