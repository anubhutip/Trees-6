
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*
 //BFS
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr!=null){
                sb.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            }else{
                sb.append("null");
            }
            sb.append("#");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="null"){
            return null;
        }
        String[] arr=data.split("#");
        int i=1;
        if(arr[0].equals("null")){
            return null;
        }
        int rootval=Integer.parseInt(arr[0]);
        TreeNode root=new TreeNode(rootval);
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            //make left baby
            if(!arr[i].equals("null")){
                curr.left=new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.left);
            }
            i++;
            if(!arr[i].equals("null")){
                curr.right=new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.right);
            }
            i++;
            
            //make right baby
        }
        return root;
    }
}
*/

/*
//Preorder DFS
public class Codec {

    // Encodes a tree to a single string.
    StringBuilder sb;
    public String serialize(TreeNode root) {
        this.sb=new StringBuilder();
        serhelper(root);
        System.out.println(sb.toString());
        return sb.toString();
    }

    private void serhelper(TreeNode root){
        if(root==null){
            sb.append("#");
            sb.append(" ");
            return;
        }
        sb.append(root.val);
        sb.append(" ");
        serhelper(root.left);
        serhelper(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr=data.split(" ");
        if(arr[0]=="#"){
            return null;
        }
        TreeNode root= deserhelper(arr);
        return root;
    }

    int idx=0;
    private TreeNode deserhelper(String[] arr){
        if(arr[idx].equals("#")){
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(arr[idx]));
        idx++;
        root.left=deserhelper(arr);
        root.right=deserhelper(arr);
        return root;
    }
}
*/

//Postorder DFS
public class SerializeAndDeserializeBT {
    int idx=0;

    // Encodes a tree to a single string.
    StringBuilder sb;
    public String serialize(TreeNode root) {
        this.sb=new StringBuilder();
        serhelper(root);
        System.out.println(sb.toString());
        return sb.toString();
    }

    private void serhelper(TreeNode root){
        if(root==null){
            sb.append("#");
            sb.append(" ");
            return;
        }
        
        serhelper(root.left);
        serhelper(root.right);
        sb.append(root.val);
        sb.append(" ");
    }

    //Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr=data.split(" ");
        if(arr[0]=="#"){
            return null;
        }
        idx = arr.length-1;
        TreeNode root= deserhelper(arr);
        return root;
    }
   
    private TreeNode deserhelper(String[] arr){
        if(arr[idx].equals("#")){
            idx--;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(arr[idx]));
        idx--;
        root.right=deserhelper(arr);
        root.left=deserhelper(arr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));