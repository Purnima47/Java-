import java.util.*;
import java.util.LinkedList;

public class Graphs2 {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        // if graph doesn't have cycle then it is a BIPARTITE GRAPH
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));

    }

    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0;
                while (!q.isEmpty()) {
                    int cur = q.remove();
                    for (int j = 0; j < graph[cur].size(); j++) {
                        Edge e = graph[cur].get(j);
                        if (col[e.dest] == -1) {
                            int nextCol = col[cur] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if (col[e.dest] == col[cur]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    static void createGraphCycleDetDirGr(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], int cur, boolean vis[], boolean stack[]) {
        vis[cur] = true;
        stack[cur] = true;

        for (int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);
            if (stack[e.dest]) { // cycle exists
                return true;
            }
            if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[cur] = false;
        return false;
    }

    public static boolean isCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    static void createGraphTopologicalSort(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    public static void topSortUtil(ArrayList<Edge> graph[], int cur, boolean vis[], Stack<Integer> s) {
        // DAG(Directed Acyclic Graph)--> We can find topological sort
        vis[cur] = true;
        for (int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(cur);
    }

    public static void topologicalSort(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void calInDegree(ArrayList<Edge> graph[], int inDeg[]) {
        // FACT: A DAG has at least one vertex with in-degree 0 and one vertex with
        // out-degree 0
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                inDeg[e.dest]++;
            }
        }

    }

    public static void topSortBFS(ArrayList<Edge> graph[]) {
        int inDeg[] = new int[graph.length];
        calInDegree(graph, inDeg);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        // BFS
        while (!q.isEmpty()) {
            int cur = q.remove();
            System.out.print(cur + " ");

            for (int i = 0; i < graph[cur].size(); i++) {
                Edge e = graph[cur].get(i);
                inDeg[e.dest]--;
                if (inDeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    public static void createGraphForPathsSrcToDst(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    public static void printAllPaths(ArrayList<Edge> graph[], int src, int dst, String path) {
        // Exponential T.C.
        if (src == dst) {
            System.out.println(path + dst);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPaths(graph, e.dest, dst, path + src);
        }
    }

    public static void main(String[] args) {
        // ArrayList<Edge> graph[] = new ArrayList[5];
        // createGraph(graph);
        // System.out.println(isBipartite(graph));

        // ArrayList<Edge> graph[]=new ArrayList[4];
        // createGraphCycleDetDirGr(graph);
        // System.out.println(isCycle(graph));

        // ArrayList<Edge> graph[] = new ArrayList[6];
        // createGraphTopologicalSort(graph);
        // topologicalSort(graph);
        // topSortBFS(graph);

        ArrayList<Edge> graph[] = new ArrayList[7];
        createGraphForPathsSrcToDst(graph);
        printAllPaths(graph, 5, 1, "");

    }
}
