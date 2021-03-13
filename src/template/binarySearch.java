package template;

public class binarySearch {
    private static void binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (key == arr[mid]) {//종료조건..?
                break;
            }
            if (key < arr[mid]) {//조건1
                right = mid - 1;
            }
            else {//조건2
                left = mid + 1;
            }
        }
    }
}
//알고리즘 템플릿은 직접구현을 우선으로..
