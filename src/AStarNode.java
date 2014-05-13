/**
 * Class to represent the A* node It holds the data information and the
 * heuristic value
 * 
 * @author gustavo
 * 
 */
public class AStarNode<E> implements Comparable<AStarNode<E>> {

    private E data;
    private int heuristic;

    public AStarNode(E data, int heuristic) {
        super();
        this.data = data;
        this.heuristic = heuristic;
    }

    /**
     * Method to compare this object with another
     * If this goes to a sorting method the smallest will be put ahead
     */
    @Override
    public int compareTo(AStarNode other) {
        return getHeuristic() - other.getHeuristic();
    }

    public E getData() {
        return data;
    }
    
    public int getHeuristic() {
        return heuristic;
    }


}
