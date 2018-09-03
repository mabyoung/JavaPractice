package Company.Envision;

import java.util.LinkedList;

/**
 * Created by rui on 2018/8/27.
 */
public class Tree {
    public void connect(TreeLinkNode root) {
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeLinkNode treeLinkNode = queue.pollFirst();
        }
    }
}
