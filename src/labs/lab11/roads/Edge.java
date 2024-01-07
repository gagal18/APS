package labs.lab11.roads;


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
