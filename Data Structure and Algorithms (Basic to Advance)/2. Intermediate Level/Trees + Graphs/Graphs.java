import java.util.*;
import java.util.LinkedList;

public class Graphs {
    // network of nodes-->graph
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraphAdjacencyList() {
        int V = 5;
        // array of array list.
        ArrayList<Edge>[] graph = new ArrayList[V];

        /*
         * (5)
         * 0---------1
         * / \
         * (1) / \ (3)
         * / \
         * 2---------3
         * | (1)
         * (2)|
         * |
         * 4
         */

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 (vertex)
        graph[0].add(new Edge(0, 1, 5));

        // 1 (vertex)
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2 (vertex)
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        // 3 (vertex)
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // 4 (vertex)
        graph[4].add(new Edge(4, 2, 2));

        // 2's neighbors
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.print(e.dest + " ");
        }
    }

    /*
     * Applications of Graphs -->
     * 1. Maps (Shortest Path)
     * 2. Social Network
     * 3. Delivery Network (Shorted Cyclic Route)
     * 4. Physics and Chemistry
     * 5. Routing Algorithms
     * 6. Machine Learning
     * 7. Dependency Graph
     * 8. Computer Vision
     * 9. Graph Databases
     * 10. Research
     */

    static void createGraph(ArrayList<Edge> graph[]) { // O(V+E)
        /*
         * 1--3
         * / | \
         * 0 | 5 --6
         * \ | /
         * 2-- 4
         */
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    static void createGraphCycleDet(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        // graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 3, 1));
    }

    // GRAPH TRAVERSALS --> BFS(breadth first search), DFS(depth first search)

    public static void bfs(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                bfsUtil(graph, visited);
            }
        }
    }

    // Go to immediate neighbors first.
    // O(V + E)
    public static void bfsUtil(ArrayList<Edge> graph[], boolean visited[]) { // O(n)
        Queue<Integer> q = new LinkedList<>();

        q.add(0); // -->we assumed source as 0

        while (!q.isEmpty()) {
            int cur = q.remove();
            if (!visited[cur]) {
                System.out.print(cur + " ");
                visited[cur] = true;
                for (int i = 0; i < graph[cur].size(); i++) {
                    Edge e = graph[cur].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // Keep going to the 1st neighbor
    public static void dfs(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfsUtil(graph, i, visited);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge> graph[], int cur, boolean visited[]) { // O(V+E)
        // stack is used otherwise we can make program using recursion
        System.out.print(cur + " ");
        visited[cur] = true;

        for (int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);
            if (!visited[e.dest]) {
                dfsUtil(graph, e.dest, visited);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean visited[]) {
        if (src == dest) {
            return true;
        }

        visited[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!visited[e.dest] && hasPath(graph, e.dest, dest, visited)) {
                return true;
            }
        }
        return false;
    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (detectCycleUtil(graph, visited, i, -1)) {
                    return true;
                    // cycle exists in one of the part if it is disjoint graph
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean visited[], int cur, int par) {
        visited[cur] = true;
        for (int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);

            // case 3:
            if (!visited[e.dest]) {
                if (detectCycleUtil(graph, visited, e.dest, cur)) {
                    return true;
                }
            }
            // case 1:
            else if (visited[cur] && e.dest != par) {
                return true;
            }
            // case 2:(do nothing... continue)

        }
        return false;
    }

    public static void main(String[] args) {

        // int V = 7;
        // ArrayList<Edge> graph[] = new ArrayList[7];
        // createGraph(graph);
        // // bfs(graph);
        // // dfs(graph, 0, new boolean[V]);
        // System.out.println(hasPath(graph, 0, 5, new boolean[V]));

        ArrayList<Edge> graph[] = new ArrayList[5];
        createGraphCycleDet(graph);
        System.out.println(detectCycle(graph));

    }
}
