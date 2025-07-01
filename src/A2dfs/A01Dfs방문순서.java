package A2dfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class A01Dfs방문순서 {
    static List<List<Integer>> adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        // 0부터 dfs로 방문 시 -> 0 -> 1 -> 3 -> 2 -> 4
        //방문할 수 있는 점이 여러개인 경우, 정점번호가 작은것을 먼저 골라 적용
        int[][] nodes = {{0, 2}, {0, 1}, {1, 3}, {2, 3}, {2, 4}};

        // 인접리스트 활용 인접해 있는 노드에 빠르게 접근
        adjList = new ArrayList<>();
        visited = new boolean[5];

        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < nodes.length; i++) {
            adjList.get(nodes[i][0]).add(nodes[i][1]);  // 단반향
            adjList.get(nodes[i][1]).add(nodes[i][0]);  // 양방향
        }

        for (int i = 0; i < adjList.size(); i++) {
            adjList.get(i).sort(Comparator.naturalOrder());
        }
        dfs(0);
    }

    static void dfs(int start) {
        // 인접리스트 순회 시 보통 향상된 for문 사용
        System.out.println(start);
        visited[start] = true;

        for (int a : adjList.get(start)) {
            if (!visited[a]) {
                dfs(a);
            }
        }
    }

    // 백준: dfsbfs(1260), 연결요소의 개수(11724)

}