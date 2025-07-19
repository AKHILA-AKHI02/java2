class Node {
int id;
Node(int id) {
this.id = id;
}
}
class LinkStateAlgorithm {
private int[][] networkGraph; // Adjacency matrix for costs
private int[][] routingTables; // Shortest path cost table
private Node[] nodes;
public LinkStateAlgorithm(int[][] graph, Node[] nodes) {
this.networkGraph = graph;
this.nodes = nodes;
this.routingTables = new int[nodes.length][nodes.length];
}
public void calculateShortestPaths(Node sourceNode) {
int n = nodes.length;
boolean[] visited = new boolean[n];
int[] dist = new int[n];
// Init distances
for (int i = 0; i < n; i++) {
dist[i] = Integer.MAX_VALUE;
visited[i] = false;
}
dist[sourceNode.id - 1] = 0;
for (int count = 0; count < n - 1; count++) {
int u = getMinDistanceNode(dist, visited);
visited[u] = true;
for (int v = 0; v < n; v++) {
if (!visited[v] && networkGraph[u][v] != 0 && dist[u] != Integer.MAX_VALUE &&
dist[u] + networkGraph[u][v] < dist[v]) {
dist[v] = dist[u] + networkGraph[u][v];
}
}
}
// Store the result
routingTables[sourceNode.id - 1] = dist;
}
private int getMinDistanceNode(int[] dist, boolean[] visited) {
int min = Integer.MAX_VALUE, minIndex = -1;
for (int i = 0; i < dist.length; i++) {
if (!visited[i] && dist[i] <= min) {
min = dist[i];
minIndex = i;
}
}
return minIndex;
}
public void updateRoutingTables() {
for (Node node : nodes) {
calculateShortestPaths(node);
}
}
public void printRoutingTables() {
for (int i = 0; i < nodes.length; i++) {
System.out.println("Node " + nodes[i].id + ":");
for (int j = 0; j < nodes.length; j++) {
if (i != j && routingTables[i][j] != Integer.MAX_VALUE) {
System.out.println("Link to Node " + (j + 1) + ", Cost: " + routingTables[i][j]);
}
}
}
}
}
public class SimpleLinkState {
public static void main(String[] args) {
// Node IDs from 1 to 5
Node[] nodes = {
new Node(1), new Node(2), new Node(3), new Node(4), new Node(5)
};
// Adjacency matrix: 0 means no direct connection
int[][] graph = {
// 1 2 3 4 5
{ 0, 1, 2, 0, 0 }, // Node 1
{ 1, 0, 1, 3, 0 }, // Node 2
{ 2, 1, 0, 1, 4 }, // Node 3
{ 0, 3, 1, 0, 2 }, // Node 4
{ 0, 0, 4, 2, 0 } // Node 5
};
LinkStateAlgorithm linkState = new LinkStateAlgorithm(graph, nodes);
linkState.updateRoutingTables();
linkState.printRoutingTables();
}
}