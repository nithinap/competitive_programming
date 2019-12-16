package lc.apr19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Graph {
    int v;
    LinkedList<Integer> adj[];
    long[] vs;
    long[] ms;
    Map<Integer, Long> maxMap;

    Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
        maxMap = new TreeMap<>();
    }

    public void setVs(long[] vs) {
        this.vs = vs;
    }

    public void setMs(long[] ms) {
        this.ms = ms;
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void computeMax(List<Integer> path) {
        long res = vs[path.get(0)];
        for(int i=1; i<path.size(); i++) {
            res = gcd(vs[path.get(i)], res);
        }
//        System.out.println("GCD : " + res);
        maxMap.put(path.get(path.size()-1), res);
    }

    private long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    void DFSUtil(int num, boolean[] visited, List<Integer> path) {
        visited[num] = true;
        path.add(num);
//        System.out.print(num + "->");
        if (adj[num].size() == 0) {
            // reached leaf
            computeMax(path);
            path.clear();
            path.add(0);
        }

        Iterator<Integer> i = adj[num].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited, path);
        }
    }

    Map<Integer, Long> DFS(int num) {
        boolean[] visited = new boolean[v];
        List<Integer> path = new LinkedList<>();
        DFSUtil(num, visited, path);
        return maxMap;
    }
}

public class PlayNum {
    private static Long gcd(Long a, Long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            Graph g = new Graph(n);
            for (int i = 1; i<n; i++) {
                String[] xy = br.readLine().split(" ");
                g.addEdge(Integer.parseInt(xy[0])-1, Integer.parseInt(xy[1])-1);
            }

            String[] vs = br.readLine().split(" ");
            String[] ms = br.readLine().split(" ");

            long[] v = new long[n];
            long[] m = new long[n];
            for(int i=0; i<n; i++) v[i] = Long.parseLong(vs[i]);
            for(int i=0; i<n; i++) m[i] = Long.parseLong(ms[i]);
            g.setVs(v);
            g.setMs(m);
            Map<Integer, Long> resMap = g.DFS(0);
            for (Map.Entry<Integer, Long> e : resMap.entrySet()) {
//                System.out.println("val: " + e.getValue());
//                System.out.println("b :"+m[e.getKey()]);
                long max = m[e.getKey()] - gcd(e.getValue(), m[e.getKey()]);
                System.out.print(max + " ");
            }
            System.out.println();
        }
    }
}
/*
1
5
1 2
1 4
1 5
2 3
11 22 2 7 5
10 5 2 14 15
 */