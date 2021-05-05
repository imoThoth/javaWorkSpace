import com.sun.xml.internal.ws.addressing.WsaActionUtil;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static int nbYear(int p0, double percent, int aug, int p) {


        int count = 0;


        while(p0 < p){

            p0 = (int) (p0 + p0 * (percent/100 )+ aug) ;
           count ++;
        }

        return count;
    }

    public static boolean getXO (String str) {

        int o = 0;
        int x = 0;
        int i = 0;

        while(i < str.length()){
            if('x' == (str.charAt(i))){
                x++;

            } else if ('o' == (str.charAt(i))){
                o++;
            } else{

            }

            i++;
        }

      return o == x;

    }

    public static boolean check(String sentence) {
        //code
        int ans = 0;
        int i = 0;
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        String alphabets = "abcdefghijklmnopqrstuvwxyz";

     

        while (i < sentence.length()) {
            for(int j =0; j < alphabets.length(); j++){
               if(sentence.charAt(i) == alphabets.charAt(j)){
                   ans++;
               }
            }
            i++;
        }
        return ans == 26 || ans >= 26;
    }

    public static void main(String[] args) {
	// write your code here
        System.out.println( check("abcdefghijklmnopqrstuvw"));

        System.out.println(nbYear(1500, 5, 100, 5000));
        System.out.println(getXO("xxo"));

        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k",
                "l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};


        String alphabets = "abcdefghijklmnopqrstuvwxyz";


        for(int j =0; j < alphabets.length(); j++){
            System.out.println(alphabets.charAt(j));
        }

//        for(String a: alphabet){
//            System.out.println(a);
//        }
    }
}
