package A3bfs;

import java.util.*;

public class A02Bfs방문순서 {
    static List<List<Integer>> adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        // 0부터 bfs로 방문 시 -> 0 -> 1 -> 2 -> 3 -> 4
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

        Queue<Integer> myQ = new LinkedList<>();
        myQ.add(0);
        visited[0] = true;

        while (!myQ.isEmpty()){
            int temp = myQ.poll();
            System.out.println(temp);

            for (int a : adjList.get(temp)){
                if (!visited[a]){
                    myQ.add(a);
                    visited[a] = true;  // 큐에 담는 시점에 true로 세팅해야 중복해야 담기지 않음
                }
            }
        }

    }
}