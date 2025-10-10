import java.util.*;

public class ComponentCalculator {

    static class Pair {
        String component;
        int quantity;

        Pair(String component, int quantity) {
            this.component = component;
            this.quantity = quantity;
        }
    }

    public static String computeOutput(List<String> inputLines) {
        // First line is component order
        String[] components = inputLines.get(0).split(",");
        List<String> componentOrder = Arrays.asList(components);

        // Build dependency graph
        Map<String, List<Pair>> graph = new HashMap<>();
        Set<String> dependents = new HashSet<>();
        Map<String, Integer> inDegree = new HashMap<>();

        for (String c : componentOrder) {
            graph.put(c, new ArrayList<>());
            inDegree.put(c, 0);
        }

        // Parse rest of the input lines
        for (int i = 1; i < inputLines.size(); i++) {
            String line = inputLines.get(i).trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(" is ");
            String parent = parts[0].trim();
            String[] tokens = parts[1].trim().split(" ");
            int qty = Integer.parseInt(tokens[0]);
            String child = tokens[1].trim();

            graph.get(parent).add(new Pair(child, qty));
            dependents.add(child);

            inDegree.put(child, inDegree.get(child) + 1); // Correct update
        }

        // Save original inDegree BEFORE BFS
        Map<String, Integer> inDegreeOriginal = new HashMap<>(inDegree);

        // Find the largest component (root component)
        String largestComponent = null;
        for (String comp : componentOrder) {
            if (!dependents.contains(comp)) {
                largestComponent = comp;
                break;
            }
        }

        // BFS to compute quantities
        Map<String, Integer> quantities = new HashMap<>();
        for (String comp : componentOrder) {
            quantities.put(comp, 0);
        }
        quantities.put(largestComponent, 1);

        Queue<String> queue = new LinkedList<>();
        queue.add(largestComponent);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int currentQty = quantities.get(current);

            for (Pair p : graph.get(current)) {
                quantities.put(p.component, quantities.get(p.component) + currentQty * p.quantity);
                queue.add(p.component);
            }
        }

        // Output in correct order (topological order using original inDegree)
        List<String> topoOrder = topologicalSort(graph, inDegreeOriginal);

        StringBuilder sb = new StringBuilder();
        sb.append("1").append(largestComponent);
        for (int i = 1; i < topoOrder.size(); i++) {
            String comp = topoOrder.get(i);
            sb.append(" equals ").append(quantities.get(comp)).append(comp);
        }

        return sb.toString();
    }

    private static List<String> topologicalSort(Map<String, List<Pair>> graph, Map<String, Integer> inDegreeOriginal) {
        Map<String, Integer> inDegree = new HashMap<>(inDegreeOriginal); // copy
        Queue<String> queue = new LinkedList<>();
        List<String> order = new ArrayList<>();

        for (String node : inDegree.keySet()) {
            if (inDegree.get(node) == 0) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            String node = queue.poll();
            order.add(node);

            for (Pair p : graph.get(node)) {
                String neighbor = p.component;
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return order;
    }

    public static void main(String[] args) {
        List<String> inputLines = Arrays.asList(
                "Shelve,Draw,Rack,Wardrobe",
                "Shelve is 2 Draw",
                "Rack is 3 Shelve",
                "Wardrobe is 36 Draw"
        );

        String result = computeOutput(inputLines);
        System.out.println(result);
    }
}