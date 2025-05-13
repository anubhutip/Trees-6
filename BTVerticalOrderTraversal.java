import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
//TC: O(n)
class BTVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        Queue<Integer> colq=new LinkedList<>();
        Map<Integer,List<Integer>> map=new HashMap<>();
        q.add(root);
        colq.add(0);
        int min=0;
        int max=0;
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            int currwid=colq.poll();
            if(!map.containsKey(currwid)){
                map.put(currwid,new ArrayList<>());
            }
            map.get(currwid).add(curr.val);
            if(curr.left!=null){
                q.add(curr.left);
                colq.add(currwid-1);
                min=Math.min(min,currwid-1);
            }
            if(curr.right!=null){
                q.add(curr.right);
                colq.add(currwid+1);
                max=Math.max(max,currwid+1);
            }
        }
        for(int i=min;i<=max;i++){
            res.add(map.get(i));
        }
        return res;
    }
}


