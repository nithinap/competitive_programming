package practice;

//Initial Template for Java
// INITIAL CODE
import java.util.*;
import java.lang.*;
import java.io.*;


class Mirror_Tree
{
    void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");

        inOrder(node.right);
    }

    // driver function to test the above functions
    public static void main(String args[])
    {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        Mirror_Tree mt = new Mirror_Tree();
        int t = sc.nextInt();
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root = null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }
            MirrorBT g = new MirrorBT();
            g.mirror(root);
            mt.inOrder(root);
            System.out.println();
            t--;
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
//function Template for Java
// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)
   {
        data = item;
        left = right = null;
    }
} */
public class MirrorBT
{
    void mirror(Node node)
    {
        if (node != null) {
            Node left = node.left;
            node.left = node.right;
            node.right = left;
            mirror(node.left);
            mirror(node.right);
        }
    }
}