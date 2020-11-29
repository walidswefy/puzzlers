package algorithms;

import java.util.*;

/**
 * @author Walid Sewaify
 * <p>
 * Find cycle in dependency graph, and resolve order or dependencies using topological sort algorithm.
 * O(V+E) number of nodes and connections
 */
public class TopologicalSort {
    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Set<Node> allNodes = new HashSet<>(Arrays.asList(a, b, c, d, e));

        b.addDependency(a); // a has dependency on b, arrow from b to a
        b.addDependency(f);
        c.addDependency(a);
        c.addDependency(e);
        d.addDependency(c);
//        e.addDependency(d); // cycle

        System.out.println(isCycle(allNodes));
        resolveOrder(allNodes).forEach(System.out::println);
    }

    public static boolean isCycle(Set<Node> allNodes) {
        Set<Node> order = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        boolean result = false;
        for (Node n : allNodes) {
            result |= isCycleUtil(n, visited, order);
        }
        return result;
    }

    private static boolean isCycleUtil(Node n, Set<Node> visited, Set<Node> order) {
        if (order.contains(n)) {
            return true;
        }
        if (!visited.contains(n)) {
            visited.add(n);
            order.add(n);

            for (Node dep : n.dependencyList) {
                if (isCycleUtil(dep, visited, order)) return true;
            }
            order.remove(n);
            return false;

        }
        return false;
    }

    private static List<Node> resolveOrder(Set<Node> allNodes) {
        Stack<Node> order = new Stack<>();
        Set<Node> visited = new HashSet<>();
        for (Node n : allNodes) {
            topologicalSort(n, visited, order);
        }

        List<Node> result = new ArrayList<>();
        while (!order.isEmpty()) {
            result.add(order.pop());
        }
        return result;
    }

    private static void topologicalSort(Node n, Set<Node> visited, Stack<Node> order) {
        if (!visited.contains(n)) {
            visited.add(n);
            for (Node dependency : n.dependencyList) {
                topologicalSort(dependency, visited, order);
            }
            order.push(n);
        }
    }

    static class Node {
        String name;
        List<Node> dependencyList = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        void addDependency(Node dependency) {
            this.dependencyList.add(dependency);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(name, node.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}


