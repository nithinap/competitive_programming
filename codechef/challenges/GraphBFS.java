package challenges;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphBFS {
	int v;
	LinkedList<Integer> adj[];
	
	public GraphBFS(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; i++)
			adj[i] = new LinkedList<Integer>();
	}
	
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	
	void BFS(int s) {
		boolean visited[] = new boolean[v];
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		
		while(queue.size() != 0) {
			s = queue.poll();
			System.out.print(s+ " ");
			
			Iterator<Integer> it = adj[s].listIterator();
			while(it.hasNext()) {
				int node = it.next();
				if(!visited[node]) {
					visited[node] = true;
					queue.add(node);
				}
			}	
		}
	}
	
	public static void main(String[] args) {
        GraphBFS g = new GraphBFS(4);
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
        g.BFS(2);
	}
}
