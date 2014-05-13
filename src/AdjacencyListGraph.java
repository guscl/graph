import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Class that implements the graph interface
 * 
 * @author gcdl160
 * 
 */
public class AdjacencyListGraph<E> implements Graph<E> {

    ArrayList<LinkedList<E>> nodes;

    public AdjacencyListGraph() {
        nodes = new ArrayList<LinkedList<E>>();
    }

    @Override
    public boolean isNode(E node) {
        for (int i = 0; i < nodes.size(); i++) {
            if (node.equals(nodes.get(i).get(0)))
                return true;
        }
        return false;
    }

    @Override
    public void addNode(E node, int heuristic) {
        LinkedList<E> listNode = new LinkedList<E>();
        listNode.add(node);
        nodes.add(listNode);
    }

    @Override
    public void addEdge(E from, E to, int weight) throws Exception {
        if (!isNode(from)) {
            throw new Exception("From is not in the graph");
        }
        if (!isNode(to)) {
            throw new Exception("To is not in the graph");
        }
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).get(0).equals(from)) {
                nodes.get(i).add(to);
            }
        }

    }

    @Override
    public void removeEdge(E from, E to) throws Exception {
        if (!isNode(from)) {
            throw new Exception("From is not in the graph");
        }
        if (!isNode(to)) {
            throw new Exception("To is not in the graph");
        }

        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).get(0).equals(from)) {
                for (int k = 0; k < nodes.get(i).size(); k++) {
                    if (nodes.get(i).get(k).equals(to)) {
                        nodes.get(i).remove(k);
                    }
                }
            }
        }

    }

    @Override
    public int numEdges() {
        int numEdges = 0;
        for (int i = 0; i < nodes.size(); i++) {
            for (int k = 0; k < nodes.get(i).size(); k++) {
                numEdges++;
            }
            numEdges--;
        }

        return numEdges;
    }

    @Override
    public int numNodes() {
        return nodes.size();
    }

    @Override
    public int degreeNode(E node) throws Exception {
        if (!isNode(node)) {
            throw new Exception("Node is not in the graph");
        }

        int degree = 0;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).get(0).equals(node)) {
                degree = nodes.get(i).size() - 1;
            }
        }
        return degree;
    }

    @Override
    public void removeNode(E node) throws Exception {
        if (!isNode(node)) {
            throw new Exception("Node is not in the graph");
        }

        for (int i = 0; i < nodes.size(); i++) {
            // Removing all the references that have the node as destination
            // of a link
            for (int k = 1; k < nodes.get(i).size(); k++) {
                if (nodes.get(i).get(k).equals(node)) {
                    nodes.get(i).remove(k);
                }
            }
            if (nodes.get(i).get(0).equals(node)) {
                // Remove the list that has node as the first element
                nodes.remove(i);
            }

        }

    }

    @Override
    public boolean isEdge(E from, E to) throws Exception {
        if (!isNode(from)) {
            throw new Exception("From is not in the graph");
        }
        if (!isNode(to)) {
            throw new Exception("To is not in the graph");
        }
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).get(0).equals(from)) {
                for (int k = 1; k < nodes.get(i).size(); k++) {
                    if (nodes.get(i).get(k).equals(to)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public ArrayList<E> getNeighbours(E node) throws Exception {
        if (!isNode(node)) {
            throw new Exception("From is not in the graph");
        }

        ArrayList<E> neighbours = new ArrayList<E>();

        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).get(0).equals(node)) {
                for (int k = 1; k < nodes.get(i).size(); k++) {
                    neighbours.add(nodes.get(i).get(k));
                }
            }
        }

        return neighbours;
    }

    @Override
    public ArrayList<E> bfs(E start, E end, Comparator<E> comparator)
            throws Exception {
        if (!isNode(start)) {
            throw new Exception("Start is not in the graph");
        }
        if (!isNode(end)) {
            throw new Exception("End is not in the graph");
        }
        // Parent List
        ArrayList<LinkedList<E>> parentList = parentList();
        // Neighbours
        ArrayList<E> neighbours;
        // Queue for the bfs
        Queue<E> fifo = new LinkedList<E>();
        fifo.add(start);

        while (!fifo.isEmpty()) {
            E node = fifo.poll();
            neighbours = getNeighbours(node);
            Collections.sort(neighbours, comparator);
            // Taking out the visited elements and setting the parent
            for (E e : neighbours) {
                for (int i = 0; i < parentList.size(); i++) {
                    if (e.equals(parentList.get(i).get(0))) {
                        if (parentList.get(i).get(1) == null) {
                            parentList.get(i).set(1, node);
                            // Checking if the element is the end point
                            if (e.equals(end))
                                return getPath(parentList, start, end);
                            // Adding the element to the list
                            fifo.add(e);
                        }
                    }
                }
            }

        }

        return null;
    }

    /**
     * Method to create a list of the nodes in the graph. This list is used to
     * store who is the parent of the node. If the second element is null the
     * node was not yet visited.
     * 
     * @return parentList to be filled
     */
    private ArrayList<LinkedList<E>> parentList() {
        ArrayList<LinkedList<E>> parentList = new ArrayList<LinkedList<E>>();
        for (int i = 0; i < nodes.size(); i++) {
            LinkedList<E> node = new LinkedList<E>();
            node.add(nodes.get(i).get(0));
            node.add(null);
            parentList.add(node);
        }
        return parentList;
    }

    /**
     * Method to return the path
     * 
     * @param parentList
     *            , the list of the parents
     * @param end
     *            , the end node
     * @return path
     */
    private ArrayList<E> getPath(ArrayList<LinkedList<E>> parentList, E start,
            E end) {
        ArrayList<E> path = new ArrayList<E>();
        path.add(end);
        E node = end;
        while (true) {
            path.add(getParent(parentList, node));
            node = getParent(parentList, node);
            if (node.equals(start))
                break;
        }
        Collections.reverse(path);
        return path;
    }

    /**
     * Method to get the parent of a node
     * 
     * @param parentList
     * @param node
     * @return
     */
    private E getParent(ArrayList<LinkedList<E>> parentList, E node) {
        for (int i = 0; i < parentList.size(); i++) {
            if (node.equals(parentList.get(i).get(0)))
                return parentList.get(i).get(1);
        }
        return null;
    }

    @Override
    public ArrayList<E> aStar(E start, E end) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}