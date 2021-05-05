public class Main {

    public static int findIt(int[] a) {
        //print out contents of array
        //print out contents array second time
        //compare the contents
        //if contents are equal increment count
        //divide the content of count to see if it is odd or even
        //return the odd

        for(int i =0; i <a.length; i++){
            int count = 0;
            for(int j = 0; j < a.length; j++){
                if(a[i] == a[j])
                    count++;
            }
            if(count % 2 != 0){
                return a[i];
            }
        }

        return -1;
    }

    static String tooCamelCase(String s){



        while(s.contains("_") || s.contains("-")) {
            if (s.contains("_")) {
                s = s.replaceFirst("_[a-z]",//replaces all underscore and alphabets
                        String.valueOf(Character.toUpperCase //finds the value of corresponding character, and change to upper case
                                (s.charAt(s.indexOf("_") + 1) //change the character of particular index to uppercase
                                )));
            }

            if (s.contains("-")) {


            s = s.replaceFirst("-[a-z]", String.valueOf(Character.toUpperCase
                    (s.charAt(s.indexOf("-") + 1))));
            }
        }
//        while(true){
//          if(s.contains("_")){
//              s = s.replaceFirst("_[a-z]", String.valueOf(
//                      Character.toUpperCase(s.charAt(s.indexOf("_")+1))
//              ));
//              break;
//          }
//          else if(s.contains("-")){
//              s = s.replaceFirst("-[a-z]", String.valueOf(Character.toUpperCase(s.charAt(s.indexOf("-")+1))
//              ));
//          }
//        }


        return s;
    }

    static String toCamelCase(String s){
        String[] parts = s.split("_");
        String camelCaseString = "";
        for (String part : parts){
            camelCaseString = camelCaseString + toProperCase(part);
        }
        return camelCaseString;
    }

    static String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase() +
                s.substring(0).toLowerCase();
    }

    public static void main(String[] args) {


        System.out.println(toCamelCase("a-large-puppy"));;
        System.out.println(toCamelCase("a_large_puppy"));;










//
//        System.out.println(findIt(new int[]{2,3,4,56,9,10}));
//        System.out.println(findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));;
//       findIt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5});
//       findIt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5});
//        findIt(new int[]{10});
//        findIt(new int[]{1,1,1,1,1,1,10,1,1,1,1});
//        findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10});
//
        String attempt = " creating_a_new_string  ";

        System.out.println("Split" + attempt.split("_"));
        String attempt2 = attempt.replace("_","");
        System.out.println("Attempt after method replace " + attempt2);

        String attempt3 = attempt.replaceAll("\\s", "");
        System.out.println("Attempt removing white space " + attempt3);


    }
}
