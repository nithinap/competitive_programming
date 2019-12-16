package practice;

import java.util.*;

class Pair
{
    //static ArrayList<Integer> list = new ArrayList<Integer>();
    public static Node insert(Node root, int data)
    {
        if(root == null)
        {
            return (new Node(data));
        }
        if(data < root.data)
        {
            root.left = insert(root.left, data);
        }
        else if(data > root.data)
        {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            //list.clear();
            int n = sc.nextInt();
            int sum = sc.nextInt();
            Node root = null;
            for(int i = 0; i  < n; i++)
            {
                int data = sc.nextInt();
                root = insert(root, data);
            }

            //inorderWalk(root);
            PairBT gfg = new PairBT();
            // int sum = sc.nextInt();
            boolean pairExists = gfg.findPair(root, sum);
            if(pairExists == true)
                System.out.println("1");
            else
                System.out.println("0");
        }

    }
     /*public static void inorderWalk(Node root)
    {
        if(root == null)
            return;

        inorderWalk(root.left);
        list.add(root.data);
        inorderWalk(root.right);
    }*/



}

/*This is a function problem.You only need to complete the function given below*/

public class PairBT
{
    public static boolean findPair(Node root, int target)
    {
        if (root == null) return false;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Set<Integer> s = new HashSet<Integer>();
        // System.out.println(root.data);
        while(q != null){
            Node node = q.poll();
            if (node == null) return false;
            if (s.contains(target - node.data))
                return true;
            // System.out.println(s);
            s.add(node.data);
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        return false;
    }


}