package oij;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
public class MirrorTree {
    TreeNode root;

    public static void main(String[] args) {
        MirrorTree mirrorTree = new MirrorTree();
//        mirrorTree.root = new TreeNode(1);
//        mirrorTree.root.left = new TreeNode(2);
//        mirrorTree.root.right = new TreeNode(2);
//        mirrorTree.root.left.left = new TreeNode(3);
//        mirrorTree.root.left.right = new TreeNode(4);
//        mirrorTree.root.right.left = new TreeNode(4);
//        mirrorTree.root.right.right = new TreeNode(3);

        mirrorTree.root = new TreeNode(1);
        mirrorTree.root.left = new TreeNode(2);
        mirrorTree.root.right = new TreeNode(2);
        mirrorTree.root.left.left = new TreeNode(3);
        mirrorTree.root.left.right = new TreeNode(4);
        mirrorTree.root.right.left = new TreeNode(4);
        mirrorTree.root.right.right = new TreeNode(5);

        boolean isMirror = mirrorTree.isMirror(mirrorTree.root);
        if(isMirror)
            System.out.println("Tree having mirror");
        else
            System.out.println("Tree doesn't having mirror");
    }

    public boolean isMirror(TreeNode root){
        return checkMirror(root, root);
    }

    public boolean checkMirror(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null)
            return true;
        if(node1 != null && node2 != null && node1.data == node2.data){
            return (checkMirror(node1.left, node2.right) && checkMirror(node1.right, node2.left));
        }
        return false;
    }
}
