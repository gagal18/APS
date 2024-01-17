//package labs.lab11.organization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Edge{
    private double weight;
    private Vertex start;
    private Vertex end;
    public Edge(double weight, Vertex start, Vertex end) {
        this.weight = weight;
        this.start = start;
        this.end = end;
    }
    public double getWeight() {
        return weight;
    }
    public Vertex getStart() {
        return start;
    }
    public Vertex getEnd() {
        return end;
    }
}
class Vertex{
    private String data;
    private ArrayList<Edge> edges;
    public Vertex(String data) {
        this.data = data;
        this.edges = new ArrayList<Edge>();
    }
    public void addEdge(Vertex end, double weight){
        Edge newEdge = new Edge(weight, this, end);
        this.edges.add(newEdge);
    }
    public void removeEdge(Vertex end){
        this.edges.removeIf(edge -> edge.getEnd().equals(end));
    }
    public String getData() {
        return data;
    }
    public ArrayList<Edge> getEdges() {
        return edges;
    }
    public void print() {
        String message = "";
        if (this.edges.size() == 0) {
            System.out.println(this.data + " -->");
            return;
        }
        for(int i = 0; i < this.edges.size(); i++) {
            if (i == 0) {
                message += this.edges.get(i).getStart().data + " -->  ";
            }
            message += this.edges.get(i).getEnd().data;
            message += " (" + this.edges.get(i).getWeight() + ")";
            if (i != this.edges.size() - 1) {
                message += ", ";
            }
        }
        System.out.println(message);
    }
}
class DijkstraResult {
    private Map<Vertex, Vertex> previousVertices;
    private Map<Vertex, Double> distances;

    public DijkstraResult(Map<Vertex, Vertex> previousVertices, Map<Vertex, Double> distances) {
        this.previousVertices = previousVertices;
        this.distances = distances;
    }

    public Map<Vertex, Vertex> getPreviousVertices() {
        return previousVertices;
    }

    public Map<Vertex, Double> getDistances() {
        return distances;
    }
}

class Graph {
    private Map<String, Vertex> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    public Vertex addVertex(String data) {
        return vertices.computeIfAbsent(data, Vertex::new);
    }

    public void removeVertex(Vertex vertex) {
        vertices.remove(vertex.getData());
    }

    public Collection<Vertex> getVertices() {
        return vertices.values();
    }

    public void addEdge(Vertex start, Vertex end, double weight) {
        start.addEdge(end, weight);
    }

    public void removeEdge(Vertex start, Vertex end) {
        start.removeEdge(end);
    }

    public void print() {
        for (Vertex v : vertices.values()) {
            v.print();
        }
    }
    public DijkstraResult dijkstra(Vertex start) {
        Map<Vertex, Double> distances = new HashMap<>();
        Map<Vertex, Vertex> previousVertices = new HashMap<>();
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        for (Vertex vertex : vertices.values()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
            previousVertices.put(vertex, null);
        }

        distances.put(start, 0.0);
        priorityQueue.offer(start);

        while (!priorityQueue.isEmpty()) {
            Vertex current = priorityQueue.poll();

            for (Edge edge : current.getEdges()) {
                Vertex neighbor = edge.getEnd();
                double newDistance = distances.get(current) + edge.getWeight();

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    previousVertices.put(neighbor, current);
                    priorityQueue.offer(neighbor);
                }
            }
        }

        return new DijkstraResult(previousVertices, distances);
    }
    public double getShortestDistance(String start, String destination) {
        Map<Vertex, Double> distances = dijkstra(vertices.get(start)).getDistances();
        return distances.get(vertices.get(destination));
    }
    public List<Vertex> getShortestPath(String start, String destination) {
        Map<Vertex, Vertex> previousVertices = dijkstra(vertices.get(start)).getPreviousVertices();

        List<Vertex> path = new ArrayList<>();
        Vertex current = vertices.get(destination);

        while (current != null) {
            path.add(current);
            current = previousVertices.get(current);
        }

        Collections.reverse(path);

        return path;
    }
}

public class Organization {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_cities = Integer.parseInt(br.readLine());
        int num_paths = Integer.parseInt(br.readLine());
        Graph graph = new Graph();

        for (int i = 0; i < num_paths; i++) {
            String[] line = br.readLine().split(" ");

            Vertex road1 = graph.addVertex(line[1]);
            Vertex road2 = graph.addVertex(line[3]);
            Double weightRoad = Double.parseDouble(line[4]);
            graph.addEdge(road1, road2, weightRoad);
        }

        String startCityName = br.readLine();
        String destinationCityName = br.readLine();
        List<Vertex> shortestPath = graph.getShortestPath(startCityName, destinationCityName);

        for (Vertex vertex : shortestPath) {
            System.out.print(vertex.getData() + " ");
        }
        System.out.println("");
        Collections.reverse(shortestPath);
        for (Vertex vertex : shortestPath) {
            System.out.print(vertex.getData() + " ");
        }
        System.out.println("");
        System.out.println(graph.getShortestDistance(startCityName, destinationCityName) + graph.getShortestDistance(destinationCityName, startCityName));

    }
}