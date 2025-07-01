package A1sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class A01HeapSort구현 {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};
        // 절반 잘라서 부모노드만 탐색 -> (n/2) - 1
        // 최초 힙구성: n*log(n)
        for (int i = (arr.length / 2) - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        // root 노드와 최 하위 노드를 바꾸면서 재힙화 -> 자리바꾼 root 노드는 자리 고정
        for (int i = arr.length - 1; i >= 0; i--) {
            // 0번째 index와 마지막 index의 자리 교체
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
        System.out.println(Arrays.toString(arr));

        // pq를 통한 정렬방법
        Queue<Integer> pq = new PriorityQueue<>(Arrays.asList(7, 6, 5, 8, 3, 5, 9, 1, 6));
        System.out.println(pq.poll());  // log(n)
        pq.add(6);                      // log(n) -> 마지막 노드에 추가하고 상향식 heapify
                                        // 상향식 heapify: 부모노드와 자식노드만 비교하면서 정렬

    }

    public static void heapify(int[] arr, int parent, int length) {
        // 자식 노드의 index = (부모노드 index * 2) +1 or +2
        // 자식노드와의 비교
//        int left = parent * 2 + 1;
//        int right = parent * 2 + 2;
        int child = parent;

//        if (length - 1 > left && arr[child] > arr[left]) {
//            child = left;
//        }
//
//        if (length - 1 > right && arr[child] > arr[right]) {
//            child = right;
//        }

        if (length - 1 >= (parent * 2) + 2) {
            if (arr[(parent * 2) + 1] > arr[(parent * 2) + 2]) {
                child = parent * 2 + 2;
            } else {
                child = parent * 2 + 1;
            }
        } else if (length - 1 >= (parent * 2) + 1) {
            child = parent * 2 + 1;
        }

        // 만약 자리가 바뀌면 재귀호출
        if (child != parent) {
            int temp = arr[parent];
            arr[parent] = arr[child];
            arr[child] = temp;
            heapify(arr, child, length);
        }
    }
}
