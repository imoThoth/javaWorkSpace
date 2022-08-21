public class BinarySearch {

    public static int binarySearch(int[] arr, int left, int right, int x){

        // base condition
        if(left > right){
            return -1;
        }

        int mid = (left + right) / 2;

        if(x == arr[mid]){
            return mid;
        }

        if(x < arr[mid]){
            return binarySearch(arr, left, mid - 1, x);
        }

        return binarySearch(arr, mid + 1, right, x);

    }

    public static void main(String[] args) {

        int[] setOfNums = new int[] {-1, 0, 1, 2, 3, 4, 7, 9, 10, 20};
        int binarySearch = binarySearch(setOfNums, 0, setOfNums.length , 10);
        System.out.println(binarySearch);
    }
}
