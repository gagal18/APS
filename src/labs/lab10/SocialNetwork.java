//package labs.lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Graph<T> {
    int num_nodes;
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

class Profile {
    public String name;

    public Profile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class SocialNetwork {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numUsers = Integer.parseInt(br.readLine());
        Profile[] profiles = new Profile[numUsers];

        Graph<String> graph = new Graph<>();

        for (int i = 0; i < numUsers; i++) {
            String name = br.readLine();
            profiles[i] = new Profile(name);

            int numFriends = Integer.parseInt(br.readLine());

            for (int j = 0; j < numFriends; j++) {
                String friend = br.readLine();

                Profile friendProfile = new Profile(friend);
                graph.addEdge(profiles[i].getName(), friendProfile.getName());
            }
        }
        String user1 = br.readLine();
        String user2 = br.readLine();
        System.out.println(graph.findDegreeOfSeparation(user1, user2));
    }
}