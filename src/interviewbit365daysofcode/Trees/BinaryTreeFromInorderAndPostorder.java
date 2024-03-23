package interviewbit365daysofcode.Trees;



public class BinaryTreeFromInorderAndPostorder {

    public TreeNode buildTree(int[] A, int[] B) {

        return subArray(A,0,A.length-1,B,0,B.length-1);

    }

    public TreeNode subArray(int[] a, int as, int ae, int[] b, int bs, int be){

        if(as>ae || bs>be){return null;}
        int root=search(a, as, ae,b[be]);
        TreeNode node=new TreeNode(b[be]);
        int size=root-as;
        node.left=subArray(a,as,root-1,b,bs,bs+size-1);
        node.right=subArray(a,root+1,ae,b,bs+size,be-1);
        return node;
    }


    public int search(int[]a, int as, int ae, int x){
        for(int i=as;i<=ae;i++){
            if(a[i]==x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Example inorder and postorder arrays
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        // Create an instance of BinaryTreeFromInorderAndPostorder
        BinaryTreeFromInorderAndPostorder binaryTreeBuilder = new BinaryTreeFromInorderAndPostorder();

        // Build the binary tree
        TreeNode root = binaryTreeBuilder.buildTree(inorder, postorder);

        // Print the inorder traversal of the constructed tree to verify
        System.out.println("Inorder traversal of the constructed tree:");
        printInorder(root);
    }

    // Utility method to print inorder traversal of a binary tree
    public static void printInorder(TreeNode node) {
        if (node == null)
            return;

        // Traverse the left subtree
        printInorder(node.left);

        // Visit the root
        System.out.print(node.val + " ");

        // Traverse the right subtree
        printInorder(node.right);
    }
}
