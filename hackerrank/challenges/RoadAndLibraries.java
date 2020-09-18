package challenges;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RoadAndLibraries {
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        for (int[] connection : cities) {
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(connection[0]);
        }

        long result = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            result += c_lib;
            visited[i] = true;

            queue.addAll(graph[i]);

            while (!queue.isEmpty()) {
                int node = queue.poll();
                if (visited[node]) continue;

                visited[node] = true;
                result += Math.min(c_lib, c_road);

                queue.addAll(graph[node]);
            }
        }

        return result;
    }
}
