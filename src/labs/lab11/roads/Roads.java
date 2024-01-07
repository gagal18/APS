package labs.lab11.roads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Roads {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_cities = Integer.parseInt(br.readLine());
        int num_paths = Integer.parseInt(br.readLine());

        Graph graph = new Graph();

        for (int i = 0; i < num_paths; i++) {
            String[] line = br.readLine().split(" ");
            Vertex road1 = new Vertex(line[1]);
            Vertex road2 = new Vertex(line[3]);
            Double weightRoad = Double.parseDouble(line[4]);
            graph.addEdge(road2, road1, weightRoad);
        }

        String startCityName = br.readLine();
        String destinationCityName = br.readLine();
        graph.print();

    }

}
