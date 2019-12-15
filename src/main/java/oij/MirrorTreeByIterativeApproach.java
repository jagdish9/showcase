package oij;

import java.util.LinkedList;
import java.util.Queue;

class TreeNodeByIterative{
    int data;
    TreeNodeByIterative left;
    TreeNodeByIterative right;

    TreeNodeByIterative(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class MirrorTreeByIterativeApproach {

    TreeNodeByIterative root;

    public static void main(String[] args) {
        MirrorTreeByIterativeApproach mirrorTree = new MirrorTreeByIterativeApproach();
        mirrorTree.root = new TreeNodeByIterative(1);
        mirrorTree.root.left = new TreeNodeByIterative(2);
        mirrorTree.root.right = new TreeNodeByIterative(2);
        mirrorTree.root.left.left = new TreeNodeByIterative(3);
        mirrorTree.root.left.right = new TreeNodeByIterative(4);
        mirrorTree.root.right.left = new TreeNodeByIterative(4);
//        mirrorTree.root.right.right = new TreeNodeByIterative(5);
        mirrorTree.root.right.right = new TreeNodeByIterative(3);

        boolean isMirror = mirrorTree.isMirror(mirrorTree.root);
        if(isMirror)
            System.out.println("Tree having mirror");
        else
            System.out.println("Tree doesn't having mirror");
    }

    public boolean isMirror(TreeNodeByIterative root){
        Queue<TreeNodeByIterative> queue = new LinkedList<TreeNodeByIterative>();

        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()){
            TreeNodeByIterative leftTree = queue.remove();
            TreeNodeByIterative rightTree = queue.remove();

            if(leftTree == null && rightTree == null)
                continue;

            if((leftTree != null && rightTree == null) || (leftTree == null && rightTree != null) ){
                return false;
            }

            if(leftTree.data != rightTree.data)
                return false;

            queue.add(leftTree.left);
            queue.add(rightTree.right);
            queue.add(leftTree.right);
            queue.add(rightTree.left);
        }

        return true;
    }
}
