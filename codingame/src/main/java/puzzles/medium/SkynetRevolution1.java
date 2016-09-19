package puzzles.medium;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * https://www.codingame.com/training/medium/skynet-revolution-episode-1
 * <p>
 * In this puzzle, Skynet Agent is trying to escape from a graph by travelling from node to node until the closest exit
 * node. The aim is to prevent it from doing so, by removing edges of the graph.
 * </p>
 * 
 * @see http://dootrix.com/graph-theory-codingame-puzzlw-walkthrough-skynet-the-virus/
 **/
class SkynetRevolution1 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways

        // Initializing an array of non-linked nodes
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++)
            nodes[i] = new Node(i);

        // Linking nodes
        for (int i = 0; i < L; i++) {
            // N1 and N2 defines a link between these nodes
            int N1 = in.nextInt();
            int N2 = in.nextInt();
            // add neighb
            nodes[N1].addNeighb(nodes[N2]);
            nodes[N2].addNeighb(nodes[N1]);
        }

        // Initializing an array of gateway nodes
        Node[] exits = new Node[E];
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            exits[i] = nodes[EI];
        }

        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn

            /*
             * Simple strategy : Breadth First Searches : identify one shortest paths from Skynet agent to each exit
             * node, Then cutting the shortest, as close as possible to Skynet agent
             */
            Path[] shortestPaths = new Path[E];
            int minLength = Integer.MAX_VALUE;
            Path pathToCut = null;
            
            for (int i = 0 ; i < E ; i++) {
                shortestPaths[i] = new Path(nodes[SI], exits[i], nodes);
                int length = shortestPaths[i].length();
                if ((length != 0) && (length < minLength)) {
                    minLength = length;
                    pathToCut = shortestPaths[i];
                }
            }
            
            cut(pathToCut.getNode(0), pathToCut.getNode(1));
        }
    }

    /**
     * Serve the link between the given nodes
     * @param n1
     * @param n2
     */
    public static void cut(Node n1, Node n2) {
        n1.removeNeighb(n2);
        n2.removeNeighb(n1);
        System.out.println(n1.getId() + " " + n2.getId());
    }
}

/**
 * <b> Node is the class representing a node of the network. </b> Each node hold :
 * <ul>
 * <li>a unique id, constant
 * <li>a list of all their edges (neighbour nodes)
 * </ul>
 */
class Node {
    private final int id;
    private LinkedList<Node> neighb;

    public Node(int id) {
        this.id = id;
        neighb = new LinkedList<Node>();
    }

    public void addNeighb(Node m) {
        neighb.add(m);
    }

    public void removeNeighb(Node m) {
        neighb.remove(m);
    }

    public Node[] neighb() {
        return neighb.toArray(new Node[neighb.size()]);
    }

    public int getId() {
        return id;
    }
}

/**
 * <b> Path is the class representing a path in the network, by a list of nodes </b>
 */
class Path {
    private LinkedList<Node> p;

    public Node getNode(int i) {
        return p.get(i);
    }

    public int length() {
        return p.size();
    }

    public void addFirst(Node n) {
        p.addFirst(n);
    }

    public Path() {
        p = new LinkedList<Node>();
    }

    /**
     * This constructor builds a shortest path in the network described by nodes, between begin and end
     */
    public Path(Node begin, Node end, Node[] nodes) {
        p = new LinkedList<Node>();
        int N = nodes.length;

        /*
         * For each node is kept a boolean equal to true if it has been visited and an int equal to the node it has been
         * visited from (initially = -1)
         */
        boolean[] explored = new boolean[N];
        for (int i = 0; i < N; i++)
            explored[i] = false;
        explored[begin.getId()] = true;

        int[] prec = new int[N];
        for (int i = 0; i < N; i++)
            prec[i] = -1;

        /*
         * A BFS is performed, starting from node begin and until finding the node end.
         */
        LinkedList<Node> q = new LinkedList<Node>();
        q.add(begin);
        Node n = null;

        while ((q.size() != 0) && (n = q.remove()) != end) {
            for (Node m : n.neighb()) {
                if (!explored[m.getId()]) {
                    explored[m.getId()] = true;
                    prec[m.getId()] = n.getId();
                    q.add(m);
                }
            }
        }

        /*
         * if the queue is empty before finding the node end then there is no path, the new path stays empty. Else, a
         * shortest path is identified by backtracing.
         */
        if (n == end) {
            while (n != begin) {
                this.addFirst(n);
                n = nodes[prec[n.getId()]];
            }
            this.addFirst(n);
        }
    }
}