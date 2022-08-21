import java.util.Arrays;

public class MergeSort {
    // TODO doesnt work
    public static void mergeSort(int[] data, int start, int end){
        // divide arrays into two halves
        if(start < end){
            int mid = (start + end) / 2;
            mergeSort(data, start, mid);
            mergeSort(data, mid + 1, end);
            merge(data, start, mid, end);
        }
    }

    // TODO doesnt work
    public static void merge(int[] data, int start, int mid, int end){ 
        // build temp array to avoid modifying original content

        int[] temp = new int[end - start + 1];

        int i = start, j = mid + 1, tracker = 0;

        // linear time comparison
        // while both have value, merge in sorted order
        // i = i   halfpoint = j
        while(i <= mid && j <= end){
            if(data[i] <= data[j]){
                temp[tracker] = data[i];
                i++;
                tracker++;
            }else{
                temp[tracker] = data[j];
                j++;
                tracker++;
            }
        }

        // Add values from left sub-array into result
        while(i <= mid){
            temp[tracker] = data[i];
            tracker++; i++;
        }

        // Add values from right sub-array into result
        while(i <= end){
            temp[tracker] = data[j];
            tracker++; i++;
        }

        for(i = start; i <= end; i++){
            data[i] = temp[i - start];
        }

    }

    public static void main(String[] args) {
        int[] data = new int[] {-5, 30, 120, 20, 0, 8};
        mergeSort(data, 8, data.length - 1);
        Arrays.stream(data).forEach(System.out::println);
    }
}
