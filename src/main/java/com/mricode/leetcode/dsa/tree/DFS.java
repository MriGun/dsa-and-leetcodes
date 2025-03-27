package com.mricode.leetcode.dsa.tree;

import com.mricode.leetcode.dsa.tree.structure.TreeNode;

import java.util.*;

public class DFS {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter -1;
    }

    int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, dia);

        return Math.max(leftHeight, rightHeight) + 1;
    }


    //https://leetcode.com/problems/invert-binary-tree/description/
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode leftSwap = invertTree(root.left);
        TreeNode rightSwap = invertTree(root.right);

        root.left = rightSwap;
        root.right = leftSwap;

        return root;

    }

    //https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int depth = Math.max(left, right) + 1;

        return depth;
    }

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if (root == null) {
             return null;
         }

         if (root.val == p.val || root.val == q.val) {
             return root;
         }

         TreeNode left = lowestCommonAncestor(root.left, p, q);
         TreeNode right = lowestCommonAncestor(root.right, p, q);

         if (left != null && right != null) {
             return root;
         }

         if (left == null && right != null) {
             return right;
         }
         else {
             return left;
         }
    }

    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/

    int counter = 0;
     public int kthSmallest(TreeNode root, int k) {
        return kthSmallestHelper(root, k).val;
     }

    public TreeNode kthSmallestHelper(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        TreeNode left = kthSmallestHelper(root.left, k);

        if (left != null) {
            return left;
        }

        counter++;

        if (counter == k) {
            return root;
        }

        return kthSmallestHelper(root.right, k);
    }


    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

         if (preorder.length == 0) {
             return null;
         }

         int root = preorder[0];
         int index = 0;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                index = i;
            }
        }

        TreeNode node = new TreeNode(root);

        node.left = buildTree(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));

        return node;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        buildTree(preorder, inorder);
    }


    //https://leetcode.com/problems/path-sum/description/
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (targetSum == root.val && root.left == null && root.right == null) {
            return true;
        }
        targetSum = targetSum - root.val;

        boolean left = hasPathSum(root.left, targetSum);
        boolean right = hasPathSum(root.right, targetSum);

        return left || right;
    }

    //https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
    public int sumNumbers(TreeNode root) {

         return sumNumbersHelper(root,  0);

    }

    public int sumNumbersHelper(TreeNode node, int num) {
        if (node == null) {
            return 0;
        }

        num = node.val + num;

        if (node.left == null && node.right == null) {
            return num;
        }

        int left = sumNumbersHelper(node.left,  num*10 );
        int right = sumNumbersHelper(node.right, num*10);

        return left + right;
    }

    //https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
    int ans  = Integer.MIN_VALUE;
     public int maxPathSum(TreeNode root) {
        helperMaxPathSum(root);
        return ans;
    }

    private int helperMaxPathSum(TreeNode node) {

         if (node == null) {
             return 0;
         }

         int left = helperMaxPathSum(node.left);
         int right = helperMaxPathSum(node.right);

         left = Math.max(0, left);
         right = Math.max(0, right);

         int pathSum = left + right + node.val;

         ans = Math.max(ans, pathSum);

         return Math.max(left, right) + node.val;
    }

    boolean findPath(TreeNode node, int[] arr) {
         if (node == null) {
             return arr.length == 0;
         }

         return findPathHelper(node, arr, 0);
    }

    private boolean findPathHelper(TreeNode node, int[] arr, int index) {
         if (node == null) {
             return false;
         }

         if (index >= arr.length || node.val != arr[index]) {
             return false;
         }

         if (node.left == null && node.right == null && index == arr.length -1) {
             return true;
         }

        boolean left = findPathHelper(node.left, arr, index+1);
        boolean right = findPathHelper(node.right, arr, index+1);

        return left || right;
    }

    int countPaths(TreeNode node, int sum) {
        List<Integer> path = new ArrayList<>();
        return countPathsHelper(node, sum, path);
    }

    private int countPathsHelper(TreeNode node, int sum, List<Integer> path) {

         if (node == null) {
             return 0;
         }

         path.add(node.val);
         int count = 0;
         int s = 0;

          //how many paths i can make
        ListIterator<Integer> itr = path.listIterator(path.size());
        while (itr.hasPrevious()) {
            s += itr.previous();
            if (s == sum) {
                count++;
            }
        }

        count += countPathsHelper(node.left, sum, path) + countPathsHelper(node.right, sum, path);

        //backtrack
        path.remove(path.size() -1);

        return count;

    }

    List<List<Integer>>  printAllPaths(TreeNode node, int sum) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();
        printAllPathsHelper(node, sum, paths, path);
        return paths;
    }

    private void   printAllPathsHelper(TreeNode node, int sum, List<List<Integer>> paths, List<Integer> path) {

        if (node == null) {
            return;
        }

        path.add(node.val);

        if (node.left == null && node.right == null && node.val == sum) {
            paths.add(new ArrayList<>(path));
        }
        else {
            printAllPathsHelper(node.left, sum - node.val, paths, path);
            printAllPathsHelper(node.right, sum - node.val, paths, path);
        }

        //backtrack
        path.remove(path.size() -1);


    }

    //dfs using stack
    void dfsStack(TreeNode node) {
         if (node == null) {
             return;
         }

         Stack<TreeNode> stack = new Stack<>();
         stack.push(node);

         while (!stack.isEmpty()) {
             TreeNode removedNode =  stack.pop();
             System.out.println(removedNode.val);

             if (removedNode.right != null) {
                 stack.push(removedNode.right);
             }
             if (removedNode.left != null) {
                 stack.push(removedNode.left);
             }
         }
    }


}
