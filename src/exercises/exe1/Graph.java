package exercises.exe1;


import java.util.ArrayList;

public class Graph {

    private ArrayList<Vertex> vertices;

    public Graph(){
        this.vertices = new ArrayList<Vertex>();
    }
    public Vertex addVertex(String data){
        Vertex nV = new Vertex(data);
        this.vertices.add(nV);
        return nV;
    }
    public void removeVertex(Vertex vertex){
        this.vertices.remove(vertex);
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public void addEdge(Vertex start, Vertex end, int weight){
        start.addEdge(end, weight);
    }
    public void removeEdge(Vertex start, Vertex end){
        start.removeEdge(end);
    }
    public void print() {
        for(Vertex v: this.vertices) {
            v.print();
        }
    }
    public static void main(String[] args) {
        Graph busNetwork = new Graph();
        Vertex cliftonStation = busNetwork.addVertex("Clifton");
        Vertex capeMayStation = busNetwork.addVertex("Cape May");
        Vertex strugaStation = busNetwork.addVertex("Struga");

        busNetwork.addEdge(cliftonStation, capeMayStation, 1000);
        busNetwork.addEdge(strugaStation, capeMayStation, 3000);
        busNetwork.addEdge(cliftonStation, strugaStation, 300);

        busNetwork.print();
    }
}
