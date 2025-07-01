package A2dfs;

public class A04완전탐색관련 {
    public static void main(String[] args) {
        // 숫자판점프: 백준
        // 상하좌우 이동
        int[][] arr = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 2, 1}, {1, 1, 1, 1, 1}};
        int[] current = {1, 1};

        int[] up = {current[0] - 1, current[1]};        // 위로 이동
        int[] down = {current[0] + 1, current[1]};      // 아래로 이동
        int[] left = {current[0], current[1] - 1};      // 왼쪽으로 이동
        int[] right = {current[0], current[1] + 1};     // 오른쪽으로 이동

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int nx = current[0] + dx[i];
            int ny = current[1] + dy[i];
            System.out.println(nx + ", " + ny);
        }

        // 피로도: 프로그래머스
    }
}
