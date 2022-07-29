package coplit.dailyCoding;

// 정렬된 배열에서 특정 target값의 idx 찾기

public class BinarySort {
    public static void main(String[] args) {
        int output = binarySearch(new int[]{4, 5, 6, 9}, 100);
        System.out.println(output);
    }
    public static int binarySearch(int[] arr, int target) {
        // TODO:
        int left = 0;
        int right = arr.length-1;
        int mid;

        while (left <= right) {
            mid = (left+right)/2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }

        return -1;
    }
}
