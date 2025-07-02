package A5DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A02동전관련 {
    public static void main(String[] args) throws IOException {
//        // 1, 4, 5의 숫자가 있을 때, 조합하여 13을 만들 수 있는 조합 중 가장 짧은 조합의 길이
//        Integer[] arr = {1, 4, 5};
//        int target = 13;
//
//        // greedy 문제를 풀 경우: 5*2 + 1*3 = 5개
//        // dfs, bfs -> 시간 또는 메모리 초과
//        // dp로 문제를 풀 경우: 4*2 + 5*1 = 3개
//        // f(n) = Math.min(f(n-arr[1]), f(n-arr[2))+1;
//
//        int[] answer = new int[target+1];
//        answer[0] = 0;
//        answer[1] = 1;
//        answer[2] = 2;
//        answer[3] = 3;
//        answer[4] = 1;
//        answer[5] = 1;
//
//        for (int i = 6; i < answer.length; i++) {
//            answer[i] = Math.min(answer[i - 4], answer[i - 5]) + 1;
//        }
//
//        System.out.println(answer[13]);

        /// 동전 2(2294번): 백준
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] answer = new int[k + 1];
        answer[0] = 0;
        for (int i = 1; i <= k; i++) {
            int min = 10001;
            for (int c : coins) {
                if (i - c >= 0 && answer[i - c] != -1 && min > answer[i - c]) {
                    min = answer[i - c];
                }
            }

            if (min == 10001) {
                answer[i] = -1;
            } else {
                answer[i] = min + 1;
            }
        }
        System.out.println(answer[k]);

        br.close();
    }
}
