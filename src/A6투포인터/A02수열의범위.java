package A6투포인터;

import java.util.ArrayList;
import java.util.List;

public class A02수열의범위 {
    //    숫자의 표현: 프로그래머스 / 구간의 합
    class A0201숫자의표현 {
        public int solution(int n) {
            int answer = 0;

            int start = 0;
            int end = 0;
            int total = 0;

            while (start <= end && end <= n) {  // start <= end : 정렬되어있을 경우 굳이 더 할 필요 없음
                if (total == n) {
                    answer++;
                    end++;
                    total += end;
//                    total -= start;
//                    start++;
                } else if (total < n) {
                    end++;
                    total += end;
                } else if (total > n) {
                    total -= start;
                    start++;
                }
            }

            return answer;
        }
    }

    // 연속된 부분 수열의 합 : 프로그래머스
    class A0202연속된부분수열의합 {
        public int[] solution(int[] sequence, int k) {
            int[] answer = new int[2];
            int start = 0;
            int end = 0;
            int total = sequence[0];
            int length = Integer.MAX_VALUE;

            while (start <= end && end < sequence.length) {
                if (k == total) {
                    if (length > end - start) {
                        answer[0] = start;
                        answer[1] = end;
                        length = end - start;
                    }
                    total -= sequence[start];
                    start++;
                } else if (k < total) {
                    total -= sequence[start];
                    start++;
                } else if (k > total && ++end < sequence.length) {
                    total += sequence[end];
                }
            }

            return answer;
        }
    }

    class A0203연속된부분수열의합 {
        public int[] solution(int[] sequence, int k) {

            List<int[]> list = new ArrayList<>();

            int[] answer = {};

            int start = 0;
            int end = 0;
            int sum = sequence[0];

            while (start <= end && end < sequence.length) {
                // System.out.println(start + " " + end + " = " + sum);
                if (sum == k) {
                    list.add(new int[]{start, end});
                    end++;
                    if (end >= sequence.length) {
                        continue;
                    }
                    sum += sequence[end];
                } else if (sum < k) {
                    end++;
                    if (end >= sequence.length) {
                        continue;
                    }
                    sum += sequence[end];
                } else if (sum > k) {
                    sum -= sequence[start];
                    start++;
                }
            }

            list.sort((o1, o2) -> (o1[1] - o1[0]) - (o2[1] - o2[0]));

            answer = list.get(0);

            return answer;
        }
    }
}