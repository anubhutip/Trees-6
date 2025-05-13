

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

 //Brute force
 //TC: O(N)
 /*
class Solution {
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        helper(root,low,high);
        return sum;
    }

    private void helper(TreeNode root, int low, int high){
        if(root==null){
            return;
        }
        //logic
        helper(root.left,low,high);
        //can be done in inorder and postorder also.
        if(root.val>=low && root.val<=high){
            sum=sum+root.val;
        }
        helper(root.right,low,high);
    }
}*/

/*
class Solution {
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        return helper(root,low,high);
        
    }

    private int helper(TreeNode root, int low, int high){
        if(root==null){
            return 0;
        }
        //1  logic
        int sum=0;
        // int left = helper(root.left,low,high);
        // //can be done in inorder and postorder also.
        // if(root.val>=low && root.val<=high){
        //     sum=  root.val;
        // }
        // int right = helper(root.right,low,high);
        // return sum+left+right;


        // 2 logic 
        // sum=sum+ helper(root.left,low,high);
        // //can be done in inorder and postorder also.
        // if(root.val>=low && root.val<=high){
        //     sum=  sum+root.val;
        // }
        // sum=sum+helper(root.right,low,high);
        // return sum;

        int left = helper(root.left,low,high);
        int right = helper(root.right,low,high);
        if(root.val>=low && root.val<=high){
            return left+right+ root.val;
        }
        
         return left+right;
    }
}

*/


//Condition based recursion
/*
class Solution {
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
         helper(root,low,high);
         return sum;
        
    }

    private void helper(TreeNode root, int low, int high){
        if(root==null ){
            return;
        }
        //logic
        if(root.val>=low){
            helper(root.left,low,high);
        }
        if(root.val<=high){
            helper(root.right,low,high);
        }
        //can be done in inorder and postorder also.
        if(root.val>=low && root.val<=high){
            sum=sum+root.val;
        }
        
    }
}
*/
/*
class Solution {
   
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        return helper(root,low,high);
        
    }

    private int helper(TreeNode root, int low, int high){
        if(root==null ){
            return 0;
        }
        //logic
        int sum=0;
        if(root.val>=low){
            sum=sum+helper(root.left,low,high);
        }
        if(root.val<=high){
            sum=sum+helper(root.right,low,high);
        }
        //can be done in inorder and postorder also.
        if(root.val>=low && root.val<=high){
            sum=sum+root.val;
        }
        return sum;
    }
}
*/

//DFS
//O(N)
//O(H)
/*
class Solution {
   
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        Stack<TreeNode> stk=new Stack<>();
        stk.push(root);
        int sum=0;
        while(!stk.isEmpty()){
            TreeNode curr=stk.pop();
            if(curr.val>=low && curr.val<=high){
                sum=sum+curr.val;
            }
            if(curr.right!=null){
                stk.push(curr.right);
            }
            if(curr.left!=null){
                stk.push(curr.left);
            }
        }
        return sum;
    }
}
*/

//conditional preorder
/*
class Solution {
   
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        Stack<TreeNode> stk=new Stack<>();
        stk.push(root);
        int sum=0;
        while(!stk.isEmpty()){
            TreeNode curr=stk.pop();
            if(curr.val>=low && curr.val<=high){
                sum=sum+curr.val;
            }
            if(curr.right!=null && curr.val<=high){
                stk.push(curr.right);
            }
            if(curr.left!=null && curr.val>=low){
                stk.push(curr.left);
            }
        }
        return sum;
    }
}
*/


//inorder iterative LVR
/*
class Solution {
   
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        Stack<TreeNode> stk=new Stack<>();
        int sum=0;
        while(root!=null || !stk.isEmpty()){
            while(root!=null){
                stk.push(root);
                root=root.left;
            }
            root=stk.pop();
            if(root.val>=low && root.val<=high){
                sum=sum+root.val;
            }
            root=root.right;
        }
        return sum;
    }
}
*/

//conditional inorder iterative LVR
class RangeSumOfBST {
   
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        Stack<TreeNode> stk=new Stack<>();
        int sum=0;
        while(root!=null || !stk.isEmpty()){
            
            while(root!=null && root.val>=low && root.val<=high ){
                
                    stk.push(root);
                    root=root.left;
            }
            if(root!=null && root.val<=high){
                stk.push(root);
            }
                if(!stk.isEmpty())
                    root=stk.pop();
                //System.out.println(root.val);
                if(root!=null && root.val>=low && root.val<=high){
                    sum=sum+root.val;
                }
                if(root.val<high)
                    root=root.right;
                else
                    root=null;
            
                
        }
        return sum;
    }
}