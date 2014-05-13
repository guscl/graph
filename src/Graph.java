import java.util.ArrayList;
import java.util.Comparator;


/**
 * 
 * @author gcdl160
 * Interface that represents a Graph
 * @param <E> the type of nodes in the graph
 */

public interface Graph<E> {
	
	/**
	 * Says if a node is part of the graph
	 * @param node the node to be verified
	 */
	boolean isNode(E node);
	
	/**
	 * Add a node to the graph
	 * @param node the to be added
	 */
	void addNode(E node,int heuristic);
	
	/**
	 * Add an Edge between two nodes
	 * @param from the initial node
	 * @param to the destination node
	 * @param weight, the weight of the edge
	 * @throws Exception if any of the nodes are not in the graph
	 */
	void addEdge(E from, E to,int weight) throws Exception;
	
	/**
	 * Remove an Edge between two nodes
	 * @param from the initial node
	 * @param to the destination node
	 * @throws Exception if any of the nodes are not in the graph
	 */
	void removeEdge(E from, E to) throws Exception;
	
	/**
	 * Return the number of Edges in the graph
	 * @return number of edges
	 */
	int numEdges();
	
	/**
	 * Return the number of Nodes in the graph
	 * @return number of nodes
	 */
	int numNodes();
	
	/**
	 * Returns the number of edges this node has
	 * @param node the node to be evaluated
	 * @return the number of edges it has
	 * @throws Exception if the node is not in the graph
	 */
	int degreeNode(E node) throws Exception;
	
	/**
	 * Remove the node from the graph
	 * @param node, node to be deleted
	 * @throws Exception if the node is not in the graph
	 */
	void removeNode(E node) throws Exception;
	
	/**
	 * Says if there is a connection between two nodes
	 * @param from the starting node
	 * @param to the destination node
	 * @return true if the connection exists and false otherwise
	 * @throws Exception if any of the nodes is not in the graph
	 */
	boolean isEdge(E from, E to)throws Exception;
	
	/**
	 * Gives a list of neighbours of the node
	 * @param node the initial node
	 * @return all the next nodes
	 * @throws Exception if the node is not in the graph
	 * 
	 */
	ArrayList<E> getNeighbours (E node) throws Exception;
	
	/**
	 * The Breadth first search algorithm
	 * @param start, the starting node
	 * @param end, the ending node of the search
	 * @param comparator, the comparator used to sort the list of neighbours
	 * @return The path from the start to the end
	 * @throws exception if the arguments are invalid
	 */
	ArrayList<E> bfs (E start,E end,Comparator<E> comparator)throws Exception ;
	
	/**
	 * The A* search algorithm
	 * @param start, the starting node
	 * @param end, the ending node of the search
	 * @param comparator, the comparator used to sort the list of neighbours
	 * @return The path from the start to the end
	 * @throws exception if the arguments are invalid
	 */
	ArrayList<E> aStar(E start, E end) throws Exception;
	
	
	
	
	
}