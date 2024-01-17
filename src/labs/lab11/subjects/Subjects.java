package labs.lab11.subjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Graph<T> {
    Map<T, ArrayList<T>> matrix;

    Graph() {
        matrix = new HashMap<>();
    }

    public void addVertex(T s) {
        matrix.put(s, new ArrayList<T>());
    }

    public void addEdge(T source, T destination) {
        if (!matrix.containsKey(source))
            addVertex(source);

        if (!matrix.containsKey(destination))
            addVertex(destination);

        matrix.get(source).add(destination);
    }

    public List<T> getDependencies(T vertex) {
        if (matrix.containsKey(vertex)) {
            return matrix.get(vertex);
        }
        return Collections.emptyList();
    }
    public boolean areAdjacent(T vertex1, T vertex2) {
        if (matrix.containsKey(vertex1) && matrix.containsKey(vertex2)) {
            return matrix.get(vertex1).contains(vertex2) || matrix.get(vertex2).contains(vertex1);
        }
        return false;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T v : matrix.keySet()) {
            builder.append(v.toString()).append(": ");
            builder.append("[");

            int size = matrix.get(v).size();
            int count = 0;
            for (T w : matrix.get(v)) {
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
    public int findDegreeOfSeparation(T start, T end) {
        if (!matrix.containsKey(start) || !matrix.containsKey(end)) {
            return 0;
        }

        Queue<T> queue = new LinkedList<>();
        Map<T, Integer> distance = new HashMap<>();
        queue.add(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            T current = queue.poll();
            int currentDistance = distance.get(current);

            if (current.equals(end)) {
                return currentDistance;
            }

            for (T neighbor : matrix.get(current)) {
                if (!distance.containsKey(neighbor)) {
                    queue.add(neighbor);
                    distance.put(neighbor, currentDistance + 1);
                }
            }
        }

        return 0;
    }

}

public class Subjects {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Graph<String> dependencyGraph = new Graph<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String subject = br.readLine().trim();
            dependencyGraph.addVertex(subject);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] dependencies = br.readLine().trim().split("\\s+");
            String subject = dependencies[0];
            for (int j = 1; j < dependencies.length; j++) {
                dependencyGraph.addEdge(subject, dependencies[j]);
            }
        }


        String lastSubject = br.readLine().trim();

        String nextSubject = findNextSubject(dependencyGraph, lastSubject);

        System.out.println(nextSubject);
    }
    private static String findNextSubject(Graph<String> graph, String lastSubject) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(lastSubject);
        visited.add(lastSubject);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            List<String> dependencies = graph.getDependencies(current);

            for (String dependency : dependencies) {
                if (!visited.contains(dependency)) {
                    visited.add(dependency);
                    queue.add(dependency);

                    if (graph.areAdjacent(lastSubject, dependency)) {
                        return dependency;
                    }
                }
            }
        }

        return "";
    }


}
