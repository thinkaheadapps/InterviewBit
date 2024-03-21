package interviewbit365daysofcode.Trees;

import java.util.*;

public class InorderTraversal {

    public int[] inorderTraversal(TreeNode A) {
        Stack<TreeNode> stack = new Stack<>();
        int[] result = new int[countNodes(A)];
        int index = 0;
        while (A != null || !stack.isEmpty()) {
            while (A != null) {
                stack.push(A);
                A = A.left;
            }
            A = stack.pop();
            result[index++] = A.val;
            A = A.right;
        }
        return result;
    }

    private int countNodes(TreeNode node) {
        if (node == null)
            return 0;
        return countNodes(node.left) + countNodes(node.right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Testing inorderTraversal function
        InorderTraversal main = new InorderTraversal();
        int[] result = main.inorderTraversal(root);
        System.out.print("Inorder traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

}
