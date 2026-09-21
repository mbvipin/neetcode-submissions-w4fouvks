class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);
                graph.computeIfAbsent(firstEmail, k -> new ArrayList<>()).add(email);
                graph.computeIfAbsent(email, k -> new ArrayList<>()).add(firstEmail);
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> mergedAccounts = new ArrayList<>();

        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                List<String> component = new ArrayList<>();
                dfs(email, graph, visited, component);
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                mergedAccounts.add(component);
            }
        }

        return mergedAccounts;
    }

    private void dfs(String email, Map<String, List<String>> graph, Set<String> visited, List<String> component) {
        visited.add(email);
        component.add(email);
        for (String neighbor : graph.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }
}