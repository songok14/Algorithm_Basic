package A6투포인터;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A01TwoPointerBasic {
    public static void main(String[] args) {
//        아래 배열에서 target이 될 수 있는 두 수의 조합을 모두 찾아내어라
//        아래 코드는 복잡도 N^2

        int[] nums = {7, 8, 9, 2, 4, 5, 1, 3, 6};
        int target = 10;
        List<int[]> myList = new ArrayList<>();

//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    myList.add(new int[]{nums[i], nums[j]});
//                }
//            }
//        }
//
//        for (int[] n : myList) {
//            System.out.println(Arrays.toString(n));
//        }

//        위 배열을 정렬 시: 1, 2, 3, 4, 5, 6, 7, 8, 9
//        end가 0부터 출발하는 경우:, end가 length-1부터 시작하는 경우로 2가지 존재
        int start = 0;
        int end = nums.length - 1;
//
//        정렬이 필요한 경우: 두 수의 합 등
//        정렬이 필요하지 않은 경우: 구간의 합 등
        Arrays.sort(nums);      // n*log(n)

        while (start < end) {        // <= 또는 < 인 경우로 2가지 존재
            int total = nums[start] + nums[end];

            if (total == target) {
                myList.add(new int[]{nums[start], nums[end]});
                start++; // 또는 end--;
            } else if (total < target) {
                start++;
            } else if (total > target) {
                end--;
            }
            System.out.println(nums[start]+", "+nums[end]);
        }

        for (int[] n : myList) {
            System.out.println(Arrays.toString(n));
        }

//        같은 위치에서 시작할 때: 시간복잡도 증가
//        Arrays.sort(nums);
//        int start = 0;
//        int end = 1;
//
//        while (start <= nums.length - 2) {
//            int total = nums[start] + nums[end];
//
//            if (total == target) {
//                myList.add(new int[]{nums[start], nums[end]});
//                start++;
//                end = start + 1;
//            } else if (total < target) {
//                end++;
//            } else {
//                start++;
//            }
//            System.out.println(nums[start] + " " + nums[end]);
//        }
//
//        for (int[] n : myList) {
//            System.out.println(Arrays.toString(n));
//        }

    }
}