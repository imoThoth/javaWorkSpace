public class Duplicate {

    public static String[] dup(String[] arr){

//        int i = 0;
//        String solution = " ";

//        for(int j = 0; j < arr.length; j++ ) { //check length of the array
//            for(int k = 0; k < arr[j].length() -1; k++){ //checks length of characters in string
//                if (arr[j].charAt(k) == arr[j].charAt(k )+ 1) {
//                   // System.out.println("Duplicate value : " + arr[j].charAt(k));
//                }else if(!(arr[j].charAt(k) == arr[j].charAt(k + 1))){
//                    solution += arr[j].charAt(k);
//                    //System.out.println(Arrays.toString(solution));
//                }
//            }
//
//        }
//        return solution;
//        public static String dup(String[] arr){

            for (int j = 0, arrLength = arr.length; j < arrLength; j++) {
                String str = arr[j];
                for (int i = 1; i < str.length(); i++) {
                    if (str.charAt(i) == str.charAt(i - 1)) {
                        str = str.substring(0, i - 1) + str.substring(i);
                        i = 0;
                    }
                }
                arr[j] = str;
            }
            return arr;
        }

//    }

    public static void main(String[] args) {
        // write your code here
        System.out.println(dup(new String[]{"allottee", "assessee"}));


    }
}
