import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class HouseRobber3 {
    public int rob(TreeMap root) {
        return rob(root, new HashMap<>());
    }

    public int rob(TreeNode root, Map<TreeNode, Integer> map)
    {
        if(root == null) return 0;

        if(map.containsKey(root)) return map.get(root);

        int ans = 0;

        if(root.left != null)
        {
            ans += rob(root.left.left, map) + rob(root.left.right, map);
        }
        if(root.right!=null)
        {
            ans += rob(root.right.left, map) + rob(root.right.right, map);
        }

        ans = Math.max(root.val + ans, rob(root.left, map) + rob(root.right, map));

        map.put(root, ans);
        

        return ans;
    }
}