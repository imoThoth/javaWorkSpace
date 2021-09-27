public class Main {

    //Regular expressions are sequence of characters which form a search pattern.
    //This search pattern can be used to described data that is to be located/matched
    public static void main(String[] args) {
	// write your code here""
        String string = "This is a string, It is unlike other Strings"; //string literal
        System.out.println(string);

        //Replace all occurrence of a character with the string replacement
        String newString = string.replaceAll("I", "HAIII");
        String newString1 = string.replaceAll("i","HEYYA");
        System.out.println(newString);
        System.out.println(newString1);

        //String alphaNum = "abcDeeeF12Ghhiiiijkl99z";

        String haiku = "An old silent pond, A frog jumps into the pond, Splash! Silence again";
        System.out.println(haiku.replaceAll(".", "Y")); //The "." regex "replaces all" characters in haiku with a Y

        //Character Boundary Matcher " ^ " - RegEx must match the beginning of the string
        System.out.println("Replace first Occurence of An old -: " + haiku.replaceAll("^An old","The new"));
        System.out.println("Replace first occurence of pond -: " + haiku.replaceAll("^A","lake"));

        //Matches Method - The whole string must match for true to be returned
        System.out.println("Find RegEx = jumps within beginning of string: " + haiku.matches("^An")); //should return false
        System.out.println("Find RegEx jumps anywhere withins string: " + haiku.matches("An")); //should return false

        //Character Boundary " $ " -RegEx must match the end of the string
        System.out.println("Replace string at end of haiku with The End: " + haiku.replaceAll("again$", "The end"));

        //Square bracket matches specific letters or set of letters
        System.out.println("Replace all instance of specific letters [aui] with x : " + haiku.replaceAll("[aui]", "w"));

        //Replace occurence of aui when followed the letter l
        System.out.println("Replace instance of [aui], followed with l: " + haiku.replaceAll("[aui][l]", "Found You"));

    }
}
