public class Main {

    public static String findNeedle(Object[] haystack) {
        // Your code here
        String ans = "found the needle at postion ";

        for(int i = 0; i < haystack.length; i++){

        }

        return ans;
    }

    public static void main(String[] args) {
	// write your code here


        Object[] haystack = {"3", "123124234", null, "needle", "world", "hay", 2, "3", true, false};
        Object[] haystack2 = {"283497238987234", "a dog", "a cat", "some random junk", "a piece of hay", "needle", "something somebody lost a while ago"};
        Object[] haystack3 = {1,2,3,4,5,6,7,8,8,7,5,4,3,4,5,6,67,5,5,3,3,4,2,34,234,23,4,234,324,324,"needle",1,2,3,4,5,5,6,5,4,32,3,45,54};

        int i = 0;
        for(Object word: haystack2){
            System.out.println(word);
            try{
                if(word.equals("needle")){
                    System.out.println("found the needle at postion " + i);
                    break;
                }
            } catch (NullPointerException e){

            }
            i++;
        }

    }
}
