package challenges;

import java.util.LinkedList;

public class GraphDFS {
	int v;
	LinkedList<Integer> adj[];
	
	GraphDFS(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for(int i=0; i<=v; i++) {
			adj[i] = new LinkedList();
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	void DFS(int s) {
		
	}
	
	public static void main(String[] args) {
		GraphDFS g = new GraphDFS(5);
		
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
		
		
	}
}
