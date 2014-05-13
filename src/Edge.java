/**
 * Class to represent an edge between two nodes
 * @author gustavo
 *
 */
public class Edge<E> {
    private E node1, node2;
    private int weight;
    
    public Edge(E node1, E node2, int weight) {
        super();
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public E getNode1() {
        return node1;
    }

    public void setNode1(E node1) {
        this.node1 = node1;
    }

    public E getNode2() {
        return node2;
    }

    public void setNode2(E node2) {
        this.node2 = node2;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    
    
    
    
    
    
}
