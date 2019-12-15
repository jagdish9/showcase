package oij;

import java.util.HashMap;
import java.util.Map;

class TreeWithExtraNode{
    int data;
    TreeWithExtraNode left;
    TreeWithExtraNode right;
    TreeWithExtraNode random;

    public TreeWithExtraNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.random = null;
    }
}

public class ClonedBinaryTreeWithExtraNode {

    TreeWithExtraNode root;
    public static void main(String[] args) {
        ClonedBinaryTreeWithExtraNode tree = new ClonedBinaryTreeWithExtraNode();
        tree.root = new TreeWithExtraNode(1);
        tree.root.left = new TreeWithExtraNode(2);
        tree.root.right = new TreeWithExtraNode(3);
        tree.root.left.left = new TreeWithExtraNode(4);
        tree.root.left.right = new TreeWithExtraNode(5);
        tree.root.right.left = new TreeWithExtraNode(6);
        tree.root.right.right = new TreeWithExtraNode(7);

        tree.root.random = tree.root.right.left.random;
        tree.root.left.left.random = tree.root.right;
        tree.root.left.right.random = tree.root;
        tree.root.right.left.random = tree.root.left.left;
        //tree.root.random = tree.root.left;

        System.out.println("PreOrder Traversal of the original tree");
        tree.preOrder(tree.root);

        TreeWithExtraNode cloneNode = tree.cloneSpecialBinaryTree(tree.root);
        System.out.println("\nPreOrder Traversal of the cloned tree");
        tree.preOrder(cloneNode);
    }

    public void preOrder(TreeWithExtraNode root){
        if(root == null)
            return;

            if(root.left != null)
                System.out.print(+root.left.data+" ");
            if(root.right != null)
                System.out.print(+root.right.data+" ");
            if(root.random != null)
                System.out.print(+root.random.data+" ");
            preOrder(root.left);
            preOrder(root.right);
    }

    public TreeWithExtraNode cloneSpecialBinaryTree(TreeWithExtraNode root){

        Map<TreeWithExtraNode, TreeWithExtraNode> map = new HashMap<TreeWithExtraNode, TreeWithExtraNode>();

        cloneLeftAndRightPointer(root, map);

        updateRandomPointers(root, map);

        return map.get(root);
    }

    public TreeWithExtraNode cloneLeftAndRightPointer(TreeWithExtraNode root, Map<TreeWithExtraNode, TreeWithExtraNode> map){
        if(root == null)
            return null;

        map.put(root, new TreeWithExtraNode(root.data));
        map.get(root).left = cloneLeftAndRightPointer(root.left, map);
        map.get(root).right = cloneLeftAndRightPointer(root.right, map);

        return map.get(root);
    }

    public void updateRandomPointers(TreeWithExtraNode root, Map<TreeWithExtraNode, TreeWithExtraNode> map){
        if(map.get(root) == null)
            return;

        map.get(root).random = map.get(root.random);

        updateRandomPointers(root.left, map);
        updateRandomPointers(root.right, map);
    }
}
