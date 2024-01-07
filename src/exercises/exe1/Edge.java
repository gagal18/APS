package exercises.exe1;

class Edge{
    private int weight;
    private Vertex start;
    private Vertex end;

    public Edge(int weight, Vertex start, Vertex end) {
        this.weight = weight;
        this.start = start;
        this.end = end;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex getStart() {
        return start;
    }

    public Vertex getEnd() {
        return end;
    }
}
