package A7이분탐색;

public class A01BinarySearchBasic {
    public static void main(String[] args) {
////        이분탐색은 사전에 데이터가 오름차순 정렬되어 있어야 함
//        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
////        Arrays.binarySearch(arr, 17);
//        int target = 17;
//        int answer = -1;
//
//        int start = 0;
//        int end = arr.length;
//
//        while (start <= end) {
//            int mid = (start + end) / 2;
//
//            if (target == arr[mid]) {
//                answer = mid;
//                break;
//            } else if (target > arr[mid]) {
//                start = mid + 1;
//            } else {
//                end = mid - 1;
//            }
//        }
//        System.out.println(answer);

//        target이 arr에 있다면 index 값을 리턴하고, 없다면 있어야 할 자리를 return
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 2;

        int answer = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == arr[mid]) {
                answer = mid;
                // 조건에 맞는 값을 찾았어도 최솟/최댓값을 위해 이분탐색을 계속 진행할 수 있음
            } else if (target > arr[mid]) {
                start = mid + 1;
//                조건에 맞는 값이 없을 수도 있는 경우
//                answer = mid;
            } else {
                end = mid - 1;
//                조건에 맞는 값이 없을 수도 있는 경우
                answer = mid;
            }
        }

//        응용case: 배열(탐색의 대상)을 직접 설정


    }

}
