package practice;

import java.util.Scanner;

class ConstructTreeFromPreOrderTraversal
{
    public static void inorder(Node root)
    {
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []pre=new int[n];
            char []preLN=new char[n];
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                pre[i]=b;
            }
            for(int i=0;i<n;i++)
            {
                char c=sc.next().charAt(0);
                preLN[i]=c;
            }
            Test obj=new Test();
            Node root=obj.constructTree(n,pre,preLN);
            inorder(root);
            System.out.println();
        }
    }
}

class Test {
    Node constructTree(int n, int pre[], char preLN[]) {
        Node prev = null;
        for (int i=0; i<n; i++) {
            Node node = new Node(pre[i]);
            if (preLN[i] == 'N') {
                if (prev != null) {
                    node.left = prev;
                    prev = node;
                } else {
                    node.left = null;
                }
            } else if (preLN[i] == 'L') {
                if (prev != null) {
                    prev.right = node;
                } else {

                }
                node.left = null;
                node.right = null;
            }
        }
        return null;
    }
}
