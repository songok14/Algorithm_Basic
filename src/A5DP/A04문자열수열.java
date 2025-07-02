package A5DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A04문자열수열 {
    public static void main(String[] args) throws IOException {
//        가장 긴 증가하는 부분 수열(11053): 백준
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] arr = new int[testCase];
        for (int i = 0; i < testCase; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        int[] dp = new int[testCase];
        Arrays.fill(dp, 1);

        for (int i = 0; i < testCase; i++) {
            int max = Integer.MIN_VALUE;
            boolean check = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] > max) {
                    max = dp[j];
                    check = true;
                }
            }
            if (check) {
                dp[i] = max + 1;
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

    }
}
