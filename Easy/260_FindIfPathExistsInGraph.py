class Solution(object):
    def validPath(self, n, edges, source, destination):
        """
        :type n: int
        :type edges: List[List[int]]
        :type source: int
        :type destination: int
        :rtype: bool
        """
        path_graph = self.create_path_graph(edges)
        # path_exists = self.check_if_path_exists_recursive(path_graph, source, destination, set())
        path_exists = self.check_if_path_exists_recursive_with_memoization(path_graph, source, destination, set(), {})
        return path_exists
        
    
    def create_path_graph(self, edges):
        path_graph = {}
        for edge in edges:
            from_node = edge[0]
            to_node = edge[1]

            if from_node not in path_graph:
                path_graph[from_node] = set()
            path_graph[from_node].add(to_node)

            if to_node not in path_graph:
                path_graph[to_node] = set()
            path_graph[to_node].add(from_node)

        return path_graph

    def check_if_path_exists_recursive(self, path_graph, source, destination, nodes_visited):
        path_exists = False
        if source == destination:
            path_exists = True
        elif source not in path_graph:
            path_exists = False
        else:
            nodes_visited.add(source)
            for next_node in path_graph[source]:
                if next_node not in nodes_visited:
                    path_exists_from_this_node = self.check_if_path_exists_recursive(path_graph, next_node, destination, nodes_visited)
                    if path_exists_from_this_node:
                        path_exists = True
                        break
            nodes_visited.remove(source)
        return path_exists

    def check_if_path_exists_recursive_with_memoization(self, path_graph, source, destination, nodes_visited, memory):
        path_exists = False
        if '{}-{}'.format(source,destination) in memory:
            return memory['{}-{}'.format(source,destination)]
        elif source == destination:
            path_exists = True
        elif source not in path_graph:
            path_exists = False
        else:
            nodes_visited.add(source)
            for next_node in path_graph[source]:
                if next_node not in nodes_visited:
                    path_exists_from_this_node = self.check_if_path_exists_recursive_with_memoization(path_graph, next_node, destination, nodes_visited, memory)
                    if path_exists_from_this_node:
                        path_exists = True
                        break
            nodes_visited.remove(source)
        memory['{}-{}'.format(source,destination)] = path_exists
        return path_exists

        

