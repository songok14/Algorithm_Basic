package A3bfs;

import java.util.*;

//public class A03인접리스트활용최단거리 {
//    public static void main(String[] args) {
//        // 프로그래머스: 가장 먼 노드
//        Solution sol = new Solution();
//        int n = 6;
//
//        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
//
//        System.out.println(sol.solution(n, edge));
//    }
//}

//// 프로그래머스: 가장 먼 노드
//class Solution {
//    public int solution(int n, int[][] edge) {
//        List<List<Integer>> myList = new ArrayList<>();
//        Queue<Integer> myQ = new LinkedList<>();
//        boolean[] visitied = new boolean[n + 1];
//        int[] ditance = new int[n + 1];
//
//        for (int i = 0; i < n + 1; i++) {
//            myList.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < edge.length; i++) {
//            int x = edge[i][0];
//            int y = edge[i][1];
//            myList.get(x).add(y);
//            myList.get(y).add(x);
//        }
//
//        myQ.add(1);
////        visitied[1] = true;
//        Arrays.fill(ditance, -1);
//
//
//        while (!myQ.isEmpty()) {
//            int temp = myQ.poll();
//
//            for (int a : myList.get(temp)) {
//                if (ditance[a] == -1) {
//                    myQ.add(a);
////                    visitied[a] = true;
//                    ditance[a] = ditance[temp] + 1;
////                    max = Math.max(max, ditance[a]);
//                }
//            }
//        }
//
////        for (int d : ditance) {
////            if (max == d) {
////                answer++;
////            }
////        }
//
//        int max = Arrays.stream(ditance).max().getAsInt();
//        int answer = (int) Arrays.stream(ditance).filter(a -> a == max).count();
//
//        return answer;
//    }
//}
