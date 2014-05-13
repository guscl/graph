import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Graph<String> graph = new AdjacencyListGraph<String>();
        graph.addNode("Arad", 366);
        graph.addNode("Bucharest", 0);
        graph.addNode("Craiova", 160);
        graph.addNode("Dobreta", 242);
        graph.addNode("Eforie", 161);
        graph.addNode("Fagaras", 178);
        graph.addNode("Giurgiu", 77);
        graph.addNode("Hirsova", 151);
        graph.addNode("Iasi", 226);
        graph.addNode("Lugoj", 244);
        graph.addNode("Mehadia", 241);
        graph.addNode("Neamt", 234);
        graph.addNode("Oradea", 380);
        graph.addNode("Pitesti", 98);
        graph.addNode("Rimnicu Vilcea", 193);
        graph.addNode("Sibiu", 253);
        graph.addNode("Timisoara", 329);
        graph.addNode("Urziceni", 80);
        graph.addNode("Vaslui", 199);
        graph.addNode("Zerind", 374);

        addLink(graph, "Arad", "Zerind", 75);
        addLink(graph, "Arad", "Timisoara", 118);
        addLink(graph, "Arad", "Sibiu", 140);
        addLink(graph, "Bucharest", "Pitesti", 101);
        addLink(graph, "Bucharest", "Fagaras", 211);
        addLink(graph, "Bucharest", "Urziceni", 85);
        addLink(graph, "Bucharest", "Giurgiu", 90);
        addLink(graph, "Craiova", "Pitesti", 138);
        addLink(graph, "Craiova", "Rimnicu Vilcea", 146);
        addLink(graph, "Craiova", "Dobreta", 120);
        addLink(graph, "Dobreta", "Mehadia", 75);
        addLink(graph, "Eforie", "Hirsova", 86);
        addLink(graph, "Fagaras", "Sibiu", 99);
        addLink(graph, "Hirsova", "Urziceni", 98);
        addLink(graph, "Iasi", "Neamt", 87);
        addLink(graph, "Iasi", "Vaslui", 92);
        addLink(graph, "Lugoj", "Mehadia", 70);
        addLink(graph, "Lugoj", "Timisoara", 111);
        addLink(graph, "Oradea", "Sibiu", 151);
        addLink(graph, "Oradea", "Zerind", 71);
        addLink(graph, "Pitesti", "Rimnicu Vilcea", 97);
        addLink(graph, "Rimnicu Vilcea", "Sibiu", 80);
        addLink(graph, "Urziceni", "Vaslui", 142);

        try {
            ArrayList<String> path = graph.bfs("Timisoara", "Bucharest",
                    new Comparator<String>() {

                        @Override
                        public int compare(String arg0, String arg1) {
                            // TODO Auto-generated method stub
                            return 0;
                        }
                    });
            //ArrayList<String> path2 = graph.aStar("Timisoara", "Bucharest");
            
            System.out.println(path.toString());
           // System.out.println(path2.toString());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    static void addLink(Graph graph, String a, String b, int weight) {
        try {
            graph.addEdge(a, b, weight);
            graph.addEdge(b, a, weight);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}