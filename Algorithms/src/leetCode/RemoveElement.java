package leetCode;

public class RemoveElement {

    public static int removeElement(int[] nums, int val){

        int k = nums.length;
        for(int i =0; i< nums.length; i++){
            if(nums[i] == val){
                int store = nums[i];

                //check if value to be swapped is not the same as checked value
                //return the position of the value to be swapped
                int swap = 0;
                int a = 1;
                while(a <= nums.length){
                    int find = nums[nums.length - a];
                    if(find != val){
                        swap = nums.length - a;
                        break;
                    }else{
                        a++;
                    }
                }

                //keep the value to eb swapped in a variable
                int toSwap = nums[swap];
                nums[i] = toSwap;
                nums[swap] = store;
                k--;
            }
        }

        return k;
    }


    public static int removeElement1(int[] nums, int val){
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {

        int ans = removeElement1(new int[]{0,1,2,2,3,0,4,2}, 2);
        System.out.println(ans);
        int a = 2;
        int b = 3;
        System.out.println(a + ":a:b:" + b);
        a = b;
        System.out.println(a + ":a:b:" + b);

    }
}
