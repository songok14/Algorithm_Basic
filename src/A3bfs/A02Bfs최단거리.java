package A3bfs;

import java.util.*;

public class A02Bfs최단거리 {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) {
        // 0부터 bfs로 방문 시 -> 0 -> 1 -> 2 -> 3 -> 4
        //방문할 수 있는 점이 여러개인 경우, 정점번호가 작은것을 먼저 골라 적용
        int[][] nodes = {{0, 2}, {0, 1}, {1, 3}, {2, 3}, {2, 4}};
        // 인접리스트 활용 인접해 있는 노드에 빠르게 접근
        adjList = new ArrayList<>();
        visited = new boolean[5];
        distance = new int[5];

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

        // 만약 간선의 가중치가 있다면 Quere<int[]>로 선언하고 0번째는 node번호, 1번째는 가중치 설계 가능
        Queue<Integer> myQ = new LinkedList<>();
        int target = 4;
        myQ.add(0);
        visited[0] = true;
        
        while (!myQ.isEmpty()) {
            int temp = myQ.poll();

            for (int a : adjList.get(temp)) {
                if (!visited[a]) {
                    myQ.add(a);
                    visited[a] = true;  // 큐에 담는 시점에 true로 세팅해야 중복해야 담기지 않음
                    distance[a] = distance[temp] + 1;
                    // 만약 찾고자 하는 target이 정해져 있으면 break
                    if (target == a) {
                        break;
                    }
                }
            }
        }

        System.out.println(distance[4]);
    }
}