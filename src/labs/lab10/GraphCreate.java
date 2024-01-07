package labs.lab10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class GraphSet<T> {
    int num_nodes;
    Map<T, Set<T>> matrix;

    GraphSet() {
        matrix = new HashMap<>();
    }

    public void addVertex(T s) {
        matrix.put(s, new HashSet<T>());
    }

    public void addEdge(T source, T destination) {
        if (!matrix.containsKey(source))
            addVertex(source);

        if (!matrix.containsKey(destination))
            addVertex(destination);

        matrix.get(source).add(destination);
        matrix.get(destination).add(source);
    }

    public void getVertexCount() {
        System.out.println("The graph has " + matrix.keySet().size() + " vertices");
    }

    public boolean areAdjacent(T vertex1, T vertex2) {
        if (matrix.containsKey(vertex1) && matrix.containsKey(vertex2)) {
            return matrix.get(vertex1).contains(vertex2) || matrix.get(vertex2).contains(vertex1);
        }
        return false;
    }

    public void removeEdge(T source, T destination) {
        if (matrix.containsKey(source) && matrix.containsKey(destination)) {
            matrix.get(source).remove(destination);
            matrix.get(destination).remove(source);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T v : matrix.keySet()) {
            builder.append(v.toString()).append(": ");
            builder.append("[");


            int size = matrix.get(v).size();
            int count = 0;
            for (Object w : matrix.get(v)) {
                builder.append(w.toString());
                count++;
                if (count < size) {
                    builder.append(", ");
                }
            }
            builder.append("]");
            builder.append("\n");
        }

        return builder.toString();
    }
}

public class GraphCreate {
    public static void main(String args[]) throws Exception {
        GraphSet<Integer> graph = new GraphSet<Integer>();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String[] command = line.split(" ");
            switch (command[0]) {
                case "ADDEDGE":
                    graph.addEdge(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;

                case "DELETEEDGE":
                    graph.removeEdge(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;

                case "ADJACENT":
                    System.out.println(graph.areAdjacent(Integer.parseInt(command[1]), Integer.parseInt(command[2])));
                    break;

                case "PRINTGRAPH":
                    System.out.println(graph);
                    break;
            }
        }
    }
}
