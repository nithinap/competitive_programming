package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    int maxSubArraySum;
    int maxPrefixSum;
    int maxSuffixSum;
    int totSum;

    @Override
    public String toString() {
        return "Node{" +
                "maxSubArraySum=" + maxSubArraySum +
                ", maxPrefixSum=" + maxPrefixSum +
                ", maxSuffixSum=" + maxSuffixSum +
                ", totSum=" + totSum +
                '}';
    }
}

class SegmentTree {
    int n;
    int[] arr;
    Node[] st;

    SegmentTree(int n, int[] arr) {
        this.n = n;
        this.arr = arr;
        int p = (int)Math.ceil(Math.log(n)/Math.log(2));
        int size = 2 * (int)Math.pow(2, p);
        st = new Node[size];
        this.buildTree(0, n-1, 0);
    }

    void buildTree(int start, int end, int id) {
//        System.out.println("["+start+"," +end+"]  ** " + id);
        if (start == end) {
            Node node = new Node();
            node.maxPrefixSum = arr[start];
            node.maxSuffixSum = arr[start];
            node.maxSubArraySum = arr[start];
            node.totSum = arr[start];
            st[id] = node;
            return;
        }
        int mid = start + (end -start)/2;
        buildTree(start, mid, 2*id+1);
        buildTree(mid+1, end, 2*id+2);
        mergeNode(start, end, id);
    }

    private void mergeNode(int start, int end, int id) {
        Node left = st[2*id+1];
        Node right = st[2*id+2];
        Node node = new Node();
        node.maxPrefixSum = Math.max(left.maxPrefixSum, left.totSum + right.maxPrefixSum);
        node.maxSuffixSum = Math.max(right.maxSuffixSum, left.maxSuffixSum + right.totSum);
        node.maxSubArraySum = Math.max(left.maxSuffixSum+right.maxPrefixSum, Math.max(left.maxSubArraySum, right.maxSubArraySum));
        node.totSum = right.totSum + left.totSum;
        st[id] = node;
    }

    public int querySegmentTree(int x, int y) {
        Node res = queryTree(0, n-1, x, y, 0);
        if(res == null) return 0;
        return res.maxSubArraySum;
    }

    private Node queryTree(int start, int end, int x, int y, int idx) {
        if (x > end || y < start) { // outside range
            return null;
        } else if (x <= start && y >= end){ // complete overlap
            return st[idx];
        } else { // within range
            int mid = start + (end-start)/2;
            Node left = queryTree(start, mid, x, y, 2*idx+1);
            Node right = queryTree(mid+1, end, x, y, 2*idx+2);
            if (left != null && right != null) {
                return computeRes(left, right);
            } else if (left != null) {
                return left;
            } else {
                return right;
            }
        }
    }

    private Node computeRes(Node left, Node right) {
        Node res = new Node();
        res.totSum = left.totSum + right.totSum;
        res.maxPrefixSum = Math.max(left.maxPrefixSum, left.totSum + right.maxPrefixSum);
        res.maxSuffixSum = Math.max(right.maxSuffixSum, left.maxSuffixSum + right.totSum);
        res.maxSubArraySum = Math.max(left.maxSuffixSum+right.maxPrefixSum, Math.max(left.maxSubArraySum, right.maxSubArraySum));

        return res;
    }
}

public class GSS1 {
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        String[] narr = br.readLine().trim().split(" ");
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(narr[i]);
        }
        int q = Integer.parseInt(br.readLine().trim());
        SegmentTree s = new SegmentTree(n, arr);
//        System.out.println(s.st[0]);
        for (int i=0; i<q; i++) {
            String[] xy = br.readLine().trim().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            System.out.println(s.querySegmentTree(x-1, y-1));
        }
    }
}
