package practice;

import java.util.ArrayList;

class Node
{
    int data;
    Node left, right;
    Node(int data)
    {
        this.data = data;
        this.left =  null;
        this.right = null;
    }
}

public class MedianBST {
    static ArrayList<Integer> list;
    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root.data);
        inOrder(root.right);
    }

    static float findMedian(Node root, int data)
    {
        list = new ArrayList<>();
        inOrder(root);
        int len = list.size();
        int mid = len/2;
        if (len%2 == 0) {
            return (list.get(mid) + list.get(mid- 1))/2.0F;
        } else
            return list.get(mid);
    }

    public static void main(String[] args) {
        Node n1 = new Node(6);
        Node n2 = new Node(3);
        Node n3 = new Node(8);
        Node n4 = new Node(1);
        Node n5 = new Node(4);
        Node n6 = new Node(7);
        Node n7 = new Node(9);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

//        float res = findMedian(n1, 6);
        System.out.println(11/2);
    }
}
