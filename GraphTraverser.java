import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTraverser {
    public static void depthFirstTraversal(Vertex start, ArrayList<Vertex> visitedVerices) {
        System.out.println(start.getData());

        for (Edge e : start.getEdges()) {
            Vertex neighbor = e.getEnd();

            if (!visitedVerices.contains(neighbor)) {
                visitedVerices.add(neighbor);
                GraphTraverser.depthFirstTraversal(neighbor, visitedVerices);
            }
        }
    }

    public static void breadthFirstTraversal(Vertex start, ArrayList<Vertex> visitedVertices) {
        Queue<Vertex> visitQueue = new LinkedList<>();
        visitQueue.offer(start);

        while (!visitQueue.isEmpty()) {
            Vertex current = visitQueue.poll();
            System.out.println(current.getData());

            for (Edge e : current.getEdges()) {
                Vertex neighbor = e.getEnd();
                if (!visitedVertices.contains(neighbor)) {
                    visitedVertices.add(neighbor);
                    visitQueue.offer(neighbor);
                }
            }
        }

    }

    public static void main(String[] args) {
        TestGraph test = new TestGraph();
        Vertex startingVertex = test.getStartingVertex();
        ArrayList<Vertex> visitedVertex1 = new ArrayList<Vertex>();
        ArrayList<Vertex> visitedVertex2 = new ArrayList<Vertex>();
        visitedVertex1.add(startingVertex);
        visitedVertex2.add(startingVertex);
        System.out.println("DFS: ");
        GraphTraverser.depthFirstTraversal(startingVertex, visitedVertex1);
        System.out.println("BFS: ");
        GraphTraverser.breadthFirstTraversal(startingVertex, visitedVertex2);
    }
}
