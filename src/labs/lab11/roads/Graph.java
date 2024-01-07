package labs.lab11.roads;
import java.util.ArrayList;

public class Graph {

    private ArrayList<Vertex> vertices;

    public Graph() {
        this.vertices = new ArrayList<Vertex>();
    }

    public Vertex addVertex(String data) {
        Vertex nV = new Vertex(data);
        this.vertices.add(nV);
        return nV;
    }

    public void removeVertex(Vertex vertex) {
        this.vertices.remove(vertex);
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public void addEdge(Vertex start, Vertex end, double weight) {
        start.addEdge(end, weight);
    }

    public void removeEdge(Vertex start, Vertex end) {
        start.removeEdge(end);
    }

    public void print() {
        for (Vertex v : this.vertices) {
            v.print();
        }
    }
}
