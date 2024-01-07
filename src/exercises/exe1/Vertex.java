package exercises.exe1;

import java.util.ArrayList;

class Vertex{
    private String data;
    private ArrayList<Edge> edges;

    public Vertex(String data) {
        this.data = data;
        this.edges = new ArrayList<Edge>();
    }

    public void addEdge(Vertex end, int weight){
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