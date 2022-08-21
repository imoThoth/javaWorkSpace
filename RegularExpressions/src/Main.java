import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    //Regular expressions are sequence of characters which form a search pattern.
    //This search pattern can be used to described data that is to be located/matched
    public static void main(String[] args) {
        String string = "This is a string, It is unlike other Strings"; //string literal
        System.out.println(string);

        //Replace all occurrence of a character with the string replacement
        String newString = string.replaceAll("I", "HAIII");
        String newString1 = string.replaceAll("i","HEYYA");
        System.out.println(newString);
        System.out.println(newString1);

        String haiku = "An old silent pond, A frog jumps into the pond, Splash! Silence again";
        System.out.println(haiku.replaceAll(".", "Y")); //The "." regex "replaces all" characters in haiku with a Y

        //Character Boundary Matcher " ^ " - RegEx(Carrot) must match the beginning of the string
        //Layman - Carrot is used to specify elements which match beginning of string or line
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

        String alpha = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ123456789";

        //replace all lowercases of targeted value with upperCase
        System.out.println("Change lowercase to upper case: " + alpha.replaceAll("[a]","A"));

        // "^" The carrot within square brackets matches all occurrences that are not the specified element
        System.out.println("Change all element to x apart from e: " + alpha.replaceAll("[^e]","x"));
        System.out.println("Change all element to x apart from e: " + alpha.replaceAll("\\w","x"));

        //Change all occurence of a-g and 1-6 to x  *Regular Expressiongs are case sensitive
        System.out.println("Change all occurence of a-g and 1-6 to x: " + alpha.replaceAll("[abcdefg123456]", "X"));
        System.out.println("Change all occurence of a-g and 1-6 to x: " + alpha.replaceAll("[a-gA-G1-6]","X"));

        //Turning off case sensitive with Regular Expressions with (?i) and (?iu) for uni-code
        System.out.println(alpha.replaceAll("(?i)[a-d3-8]", "LOL"));

        //Replace all numbers within the String
        System.out.println("Replace all numbers with string " + alpha.replaceAll("[1-9]", "X"));
        System.out.println("Replace all numbers with string " + alpha.replaceAll("\\d", "X"));
        System.out.println("Replace all letters with Troll " + alpha.replaceAll("\\D", "TROLoLOL"));

        String creat = "A creatre of blank\t origins\n";
        System.out.println(creat);
        System.out.println("Remove white space: " + creat.replaceAll("\\s", ""));
        System.out.println("Remove non-white space: " + creat.replaceAll("\\S", ""));
        System.out.println("Remove white blank space: " + creat.replaceAll("\t", ""));
        System.out.println("Replace all nums, letters and unicode with x " + creat.replaceAll("\\w", "x"));
        System.out.println("Creates a boundary around the word: " + creat.replaceAll("\\b","*"));

        //<--Quantifiers-->
        String quantify = "AaaabbbbbbCcccccDdddeEEEFFFFF";

        //{x} Quantifiers change the preceeding leters in element to the replacement
        System.out.println("Quantified String: " + quantify.replaceAll("^Aaaab{6}","J"));
        System.out.println("Quantified String: " + quantify.replaceAll("^Aaaab+","J"));

        //Wild quanitifier "*" replaces all elements which contain a ,that is or is not preceding b
        System.out.println("Quantified String Wild " + quantify.replaceAll("^Aaab*", "KKK"));

        //{x,x} matches elements within the specified numbers
        System.out.println("Quantifed String using location " + quantify.replaceAll("^Aaaab{2,6}","UUUHOo"));

        //+ Match all b elements, * Match all c elements that is or is no preceeding d
        String quantify1 = "aaaabbbbbbbcccddddeeeeeffffggggghhhiii";
        System.out.println("Matches all element between " + quantify1.replaceAll("b+c*d","u"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading<h1/>");
        htmlText.append("<h2>Sub-Heading</h2>");
        htmlText.append("<p>Here comes the first paragraph</p>");
        htmlText.append("<p>Here comes the second paragraph</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here comes the summary</p>");

        String h2Pattern = "<p>"; //Returns false
        //String h2Pattern = ".*<p>.*"; //Returns true, Regex matches all characters in htmlText
        Pattern pattern = Pattern.compile(h2Pattern);
        //Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE); //Change
        Matcher matcher= pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        //matcher.reset() //needed when using regex patterns with matcher

        //Findig occurences and when they occure
        //find method looks for occurences of a pattern used to create the matcher
        int count = 0;
        while(matcher.find()){
            count++;
            System.out.println("Occurence " + count + " : " + matcher.start() + " to " + matcher.end());

        }



    }
}
